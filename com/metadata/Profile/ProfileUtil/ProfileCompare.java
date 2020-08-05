package com.metadata.Profile.ProfileUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.main.util.FileHandling;
import com.main.util.ObjectToXML;
import com.main.util.XmlToObject;
import com.metadata.Profile.Profiles;
import com.metadata.Profile.Pojo.CustomPermissions;
import com.metadata.Profile.Pojo.FieldPermissions;
import com.metadata.Profile.Pojo.LayoutAssignments;
import com.metadata.Profile.Pojo.ObjectPermissions;
import com.metadata.Profile.Pojo.PageAccesses;
import com.metadata.Profile.Pojo.RecordTypeVisibilities;
import com.metadata.Profile.Pojo.TabVisibilities;
import com.metadata.Profile.Pojo.UserPermissions;
import com.metadata.Profile.PojoCompare.ApplicationVisiblityCompare;
import com.metadata.Profile.PojoCompare.ClassAccessCompare;

public class ProfileCompare {
    public void compare() {
        Collection<Profiles> bitbucketProfiles, orgProfiles, bitbucketTempProfiles;
		List<String> profilesNotInRepo;
		List<List<String>> diffPermissionLists;
		Map<String, List<List<String>>> profileFieldPermissionMap;
		try {
			bitbucketProfiles = new ArrayList<Profiles>();
			orgProfiles = new ArrayList<Profiles>();
			bitbucketTempProfiles = new ArrayList<Profiles>();
			XmlToObject<Profiles> profileXmlToObject = new XmlToObject<Profiles>(Profiles.class);
			Map<String, Profiles> bitbucketNameProfileMap = profileXmlToObject.convertXMLsToObjects("compareFolder/bitbucket/profiles");
			Map<String, Profiles> orgNameProfileMap = profileXmlToObject.convertXMLsToObjects("compareFolder/org/profiles");
			for(String profileName : bitbucketNameProfileMap.keySet()) {
				bitbucketNameProfileMap.get(profileName).setProfileName(profileName);
			}
			for(String profileName : orgNameProfileMap.keySet()) {
				orgNameProfileMap.get(profileName).setProfileName(profileName);
			}
			bitbucketProfiles = bitbucketNameProfileMap.values();
			orgProfiles = orgNameProfileMap.values();
			profilesNotInRepo = new ArrayList<String>();
			profileFieldPermissionMap = new TreeMap<String, List<List<String>>>();
			for (Profiles orgProfile : orgProfiles) {
				if (containsProfile(orgProfile.getProfileName(), bitbucketProfiles)) {
					
					Profiles bitbucketProfile = getProfileByName(orgProfile.getProfileName(), bitbucketProfiles);
					Profiles bitbucketTempProfile = new Profiles();
					diffPermissionLists = new ArrayList<>();
					
					// Diff Application Visiblity Start
					ApplicationVisiblityCompare avCompare = new ApplicationVisiblityCompare();
					avCompare.compare(orgProfile, bitbucketProfile);
					diffPermissionLists.add(avCompare.getApplicationVisiblityDiffList());
					diffPermissionLists.add(avCompare.getApplicationVisiblityNotInRepo());
					if(avCompare.getApplicationVisiblityToAddInBitbucket() != null && avCompare.getApplicationVisiblityToAddInBitbucket().size() > 0) {
						bitbucketTempProfile.setApplicationVisibilities(avCompare.getApplicationVisiblityToAddInBitbucket());
					}
					// Diff Application Visiblity End

					// Diff Class Accesses Start
					ClassAccessCompare caCompare = new ClassAccessCompare();
					caCompare.compare(orgProfile, bitbucketProfile);
					diffPermissionLists.add(caCompare.getClassAccessDiffList());
					diffPermissionLists.add(caCompare.getClassAccessNotInRepo());
					if(caCompare.getClassAccessToAddInBitbucket() != null && caCompare.getClassAccessToAddInBitbucket().size() > 0) {
						bitbucketTempProfile.setClassAccesses(caCompare.getClassAccessToAddInBitbucket());
					}
					// Diff Class Accesses End

					// Diff Custom Permission Start
					List<CustomPermissions> bitbucketCustomPermissions = bitbucketProfile.getCustomPermissions();
					List<CustomPermissions> orgCustomPermissions = orgProfile.getCustomPermissions();
					List<String> customPermissionsNotInRepo = new ArrayList<String>();
					List<String> customPermissionsDiffList = new ArrayList<String>();
					List<CustomPermissions> customPermissionsToAddInBitbucket = new ArrayList<CustomPermissions>();
					if(bitbucketCustomPermissions != null && orgCustomPermissions != null) {
						for (CustomPermissions orgcp : orgCustomPermissions) {
							if (containsCPByName(orgcp.getName(), bitbucketCustomPermissions)) {
								CustomPermissions bitbucketcp = getCPByName(orgcp.getName(), bitbucketCustomPermissions);
								if (!orgcp.equals(bitbucketcp)) {
									customPermissionsDiffList.add(orgcp.getName());
								}
							} else {
								if(orgcp.getEnabled()) {
									customPermissionsNotInRepo.add(orgcp.getName());
								} else if(!orgcp.getEnabled()) {
									customPermissionsToAddInBitbucket.add(orgcp);
								}
							}
						}
						customPermissionsToAddInBitbucket.addAll(bitbucketCustomPermissions);
					} else if(bitbucketCustomPermissions == null && orgCustomPermissions != null) {
						for (CustomPermissions orgcp : orgCustomPermissions) {
							if(orgcp.getEnabled()) {
								customPermissionsNotInRepo.add(orgcp.getName());
							} else if(!orgcp.getEnabled()) {
								customPermissionsToAddInBitbucket.add(orgcp);
							}
						}
					}
					if(customPermissionsToAddInBitbucket.size() > 0) {
						Collections.sort(customPermissionsToAddInBitbucket, CustomPermissions.customPermissionComparator);
						bitbucketProfile.setCustomPermissions(customPermissionsToAddInBitbucket);
					}
					diffPermissionLists.add(customPermissionsDiffList);
					diffPermissionLists.add(customPermissionsNotInRepo);
					// Diff Custom Permission End
					
					// Diff Field Permissions Start
					List<FieldPermissions> bitbucketFieldPermissions = bitbucketProfile.getFieldPermissions();
					List<FieldPermissions> orgFieldPermissions = orgProfile.getFieldPermissions();
					List<String> fieldPermissionNotInRepo = new ArrayList<String>();
					List<String> fieldPermissionNotInRepoAndIsPackaageField = new ArrayList<String>();
					List<String> fieldPermissionDiffList = new ArrayList<String>();
					List<FieldPermissions> fieldPermissionToAddInBitBucket = new ArrayList<FieldPermissions>();
					if(bitbucketFieldPermissions != null && orgFieldPermissions != null) {
						for (FieldPermissions orgfp : orgFieldPermissions) {
							if (containsFPByFieldName(orgfp.getField(), bitbucketFieldPermissions)) {
								FieldPermissions bitbucketfp = getFPByFieldName(orgfp.getField(), bitbucketFieldPermissions);
								if (!orgfp.equals(bitbucketfp)) {
									fieldPermissionDiffList.add(orgfp.getField());
								}
							} else {
								String fullFieldName = orgfp.getField();
								String[] fieldWithoutObjectName = fullFieldName.split("\\.");
								String fieldWithoutUUC = fieldWithoutObjectName[1].substring(0, fieldWithoutObjectName[1].length() - 3);
								if((orgfp.getEditable() || orgfp.getReadable()) && !fieldWithoutUUC.contains("__")){
									fieldPermissionNotInRepo.add(orgfp.getField());
								} else if((orgfp.getEditable() || orgfp.getReadable()) && fieldWithoutUUC.contains("__")) {
									fieldPermissionNotInRepoAndIsPackaageField.add(orgfp.getField());
								} else if(!orgfp.getEditable() && !orgfp.getReadable()) {
									fieldPermissionToAddInBitBucket.add(orgfp);
								}
							}
						}
						fieldPermissionToAddInBitBucket.addAll(bitbucketFieldPermissions);
					} else if(bitbucketFieldPermissions == null && orgFieldPermissions != null) {
						for (FieldPermissions orgfp : orgFieldPermissions) {
							String fullFieldName = orgfp.getField();
							String[] fieldWithoutObjectName = fullFieldName.split("\\.");
							String fieldWithoutUUC = fieldWithoutObjectName[1].substring(0, fieldWithoutObjectName[1].length() - 3);
							if((orgfp.getEditable() || orgfp.getReadable()) && !fieldWithoutUUC.contains("__")){
								fieldPermissionNotInRepo.add(orgfp.getField());
							} else if((orgfp.getEditable() || orgfp.getReadable()) && fieldWithoutUUC.contains("__")) {
								fieldPermissionNotInRepoAndIsPackaageField.add(orgfp.getField());
							} else if(!orgfp.getEditable() && !orgfp.getReadable()) {
								fieldPermissionToAddInBitBucket.add(orgfp);
							}
						}
					}
					if(fieldPermissionToAddInBitBucket.size() > 0) {
						Collections.sort(fieldPermissionToAddInBitBucket, FieldPermissions.fieldPermissionComparator);
						bitbucketTempProfile.setFieldPermissions(fieldPermissionToAddInBitBucket);
					}
					diffPermissionLists.add(fieldPermissionDiffList);
					diffPermissionLists.add(fieldPermissionNotInRepo);
					diffPermissionLists.add(fieldPermissionNotInRepoAndIsPackaageField);
					// Diff Field Permission End

					// Diff Layout Assignment Start
					List<LayoutAssignments> bitbucketLayoutAssignments = bitbucketProfile.getLayoutAssignments();
					List<LayoutAssignments> orgLayoutAssignments = orgProfile.getLayoutAssignments();
					List<String> layoutAssignmentsNotInRepo = new ArrayList<String>();
					List<LayoutAssignments> layoutAssignmentsToAddInBitbucket = new ArrayList<LayoutAssignments>();
					if(bitbucketLayoutAssignments != null && orgLayoutAssignments!= null) {
						for (LayoutAssignments orgla : orgLayoutAssignments) {
							if (!containsLAByLayoutName(orgla.getLayout() + (orgla.getRecordType() == null? "" : orgla.getRecordType()), bitbucketLayoutAssignments)) {
								layoutAssignmentsNotInRepo.add(orgla.getLayout());
							}
						}
						layoutAssignmentsToAddInBitbucket.addAll(bitbucketLayoutAssignments);
					} else if(bitbucketLayoutAssignments == null && orgLayoutAssignments!= null) {
						for (LayoutAssignments orgla : orgLayoutAssignments) {
							layoutAssignmentsNotInRepo.add(orgla.getLayout());
						}
					}
					if(layoutAssignmentsToAddInBitbucket.size() > 0) {
						Collections.sort(layoutAssignmentsToAddInBitbucket, LayoutAssignments.layoutAssignmentComparator);
						bitbucketProfile.setLayoutAssignments(layoutAssignmentsToAddInBitbucket);
					}
					diffPermissionLists.add(layoutAssignmentsNotInRepo);
					// Diff Layout Assignment End

					// Diff Object Permission Start
					List<ObjectPermissions> bitbucketObjectPermissions = bitbucketProfile.getObjectPermissions();
					List<ObjectPermissions> orgObjectPermissions = orgProfile.getObjectPermissions();
					List<String> objectPermissionNotInRepo = new ArrayList<String>();
					List<String> objectPermissionDiffList = new ArrayList<String>();
					List<ObjectPermissions> objectPermissionToAddInBitbucket = new ArrayList<ObjectPermissions>();
					if(bitbucketObjectPermissions != null && orgObjectPermissions != null) {
						for (ObjectPermissions orgop : orgObjectPermissions) {
							if (containsOPByObjectName(orgop.getObject(), bitbucketObjectPermissions)) {
								ObjectPermissions bitbucketop = getOPByObjectName(orgop.getObject(), bitbucketObjectPermissions);
								if (!orgop.equals(bitbucketop)) {
									objectPermissionDiffList.add(orgop.getObject());
								}
							} else {
								if(orgop.getAllowCreate() || orgop.getAllowDelete() || orgop.getAllowEdit() || orgop.getAllowRead() ||
									orgop.getModifyAllRecords() || orgop.getViewAllRecords()) {
										objectPermissionNotInRepo.add(orgop.getObject());
								} else if(!orgop.getAllowCreate() && !orgop.getAllowDelete() && !orgop.getAllowEdit() && !orgop.getAllowRead() &&
									!orgop.getModifyAllRecords() && !orgop.getViewAllRecords()) {
										objectPermissionToAddInBitbucket.add(orgop);
								}
							}
						}
						objectPermissionToAddInBitbucket.addAll(bitbucketObjectPermissions);
					} else if(bitbucketObjectPermissions == null && orgObjectPermissions != null) {
						for (ObjectPermissions orgop : orgObjectPermissions) {
							if(orgop.getAllowCreate() || orgop.getAllowDelete() || orgop.getAllowEdit() || orgop.getAllowRead() ||
								orgop.getModifyAllRecords() || orgop.getViewAllRecords()) {
									objectPermissionNotInRepo.add(orgop.getObject());
							} else if(!orgop.getAllowCreate() && !orgop.getAllowDelete() && !orgop.getAllowEdit() && !orgop.getAllowRead() &&
								!orgop.getModifyAllRecords() && !orgop.getViewAllRecords()) {
									objectPermissionToAddInBitbucket.add(orgop);
							}
						}
					}
					if(objectPermissionToAddInBitbucket.size() > 0) {
						Collections.sort(objectPermissionToAddInBitbucket, ObjectPermissions.objectPermissionComparator);
						bitbucketTempProfile.setObjectPermissions(objectPermissionToAddInBitbucket);
					}
					diffPermissionLists.add(objectPermissionDiffList);
					diffPermissionLists.add(objectPermissionNotInRepo);
					// Diff Object Permission End

					// Diff Page Accesses Start
					List<PageAccesses> bitbucketPageAccesses = bitbucketProfile.getPageAccesses();
					List<PageAccesses> orgPageAccesses = orgProfile.getPageAccesses();
					List<String> pageAccessesNotInRepo = new ArrayList<String>();
					List<String> pageAccessesDiffList = new ArrayList<String>();
					List<PageAccesses> pageAccessesToAddInBitbucket = new ArrayList<PageAccesses>();
					if(bitbucketPageAccesses != null && orgPageAccesses != null) {
						for (PageAccesses orgpa : orgPageAccesses) {
							if (containsPAByApexPageName(orgpa.getApexPage(), bitbucketPageAccesses)) {
								PageAccesses bitbucketpa = getPAByApexPageName(orgpa.getApexPage(), bitbucketPageAccesses);
								if (!orgpa.equals(bitbucketpa)) {
									pageAccessesDiffList.add(orgpa.getApexPage());
								}
							} else {
								if(orgpa.getEnabled()) {
									pageAccessesNotInRepo.add(orgpa.getApexPage());
								} else if(!orgpa.getEnabled()) {
									pageAccessesToAddInBitbucket.add(orgpa);
								}
							}
						}
						pageAccessesToAddInBitbucket.addAll(bitbucketPageAccesses);
					} else if(bitbucketPageAccesses == null && orgPageAccesses != null) {
						for (PageAccesses orgpa : orgPageAccesses) {
							if(orgpa.getEnabled()) {
								pageAccessesNotInRepo.add(orgpa.getApexPage());
							} else if(!orgpa.getEnabled()) {
								pageAccessesToAddInBitbucket.add(orgpa);
							}
						}
					}
					if(pageAccessesToAddInBitbucket.size() > 0) {
						Collections.sort(pageAccessesToAddInBitbucket, PageAccesses.pageAccessesComparator);
						bitbucketTempProfile.setPageAccesses(pageAccessesToAddInBitbucket);
					}
					diffPermissionLists.add(pageAccessesDiffList);
					diffPermissionLists.add(pageAccessesNotInRepo);
					// Diff Page Accesses End

					// Diff Recordtype Visiblities Start
					List<RecordTypeVisibilities> bitbucketRecordTypeVisibilities = bitbucketProfile.getRecordTypeVisibilities();
					List<RecordTypeVisibilities> orgRecordTypeVisibilities = orgProfile.getRecordTypeVisibilities();
					List<String> recordTypeVisibilitiesNotInRepo = new ArrayList<String>();
					List<String> recordTypeVisibilitiesDiffList = new ArrayList<String>();
					List<RecordTypeVisibilities> recordTypeVisibilitiesToAddInBitbucket = new ArrayList<RecordTypeVisibilities>();
					if(bitbucketRecordTypeVisibilities != null && orgRecordTypeVisibilities != null) {
						for (RecordTypeVisibilities orgrv : orgRecordTypeVisibilities) {
							if (containsRVByRecordTypeName(orgrv.getRecordType(), bitbucketRecordTypeVisibilities)) {
								RecordTypeVisibilities bitbucketrv = getRVByRecordTypeName(orgrv.getRecordType(), bitbucketRecordTypeVisibilities);
								if (!orgrv.equals(bitbucketrv)) {
									recordTypeVisibilitiesDiffList.add(orgrv.getRecordType());
								}
							} else {
								if(orgrv.getDefaultTagRTV() || orgrv.getVisible()) {
									recordTypeVisibilitiesNotInRepo.add(orgrv.getRecordType());
								} else if(!orgrv.getDefaultTagRTV() && !orgrv.getVisible()) {
									recordTypeVisibilitiesToAddInBitbucket.add(orgrv);
								}
							}
						}
						recordTypeVisibilitiesToAddInBitbucket.addAll(bitbucketRecordTypeVisibilities);
					} else if(bitbucketRecordTypeVisibilities == null && orgRecordTypeVisibilities != null) {
						for (RecordTypeVisibilities orgrv : orgRecordTypeVisibilities) {
							if(orgrv.getDefaultTagRTV() || orgrv.getVisible()) {
								recordTypeVisibilitiesNotInRepo.add(orgrv.getRecordType());
							} else if(!orgrv.getDefaultTagRTV() && !orgrv.getVisible()) {
								recordTypeVisibilitiesToAddInBitbucket.add(orgrv);
							}
						}
					}
					if(recordTypeVisibilitiesToAddInBitbucket.size() > 0) {
						Collections.sort(recordTypeVisibilitiesToAddInBitbucket, RecordTypeVisibilities.recordTypeVisiblitiesComparator);
						bitbucketTempProfile.setRecordTypeVisibilities(recordTypeVisibilitiesToAddInBitbucket);
					}
					diffPermissionLists.add(recordTypeVisibilitiesDiffList);
					diffPermissionLists.add(recordTypeVisibilitiesNotInRepo);
					// Diff Recordtype Visiblities End

					// Diff Tab Visibility Start
					List<TabVisibilities> bitbucketTabVisibilities = bitbucketProfile.getTabVisibilities();
					List<TabVisibilities> orgTabVisibilities = orgProfile.getTabVisibilities();
					List<String> tabVisibilitiesNotInRepo = new ArrayList<String>();
					List<String> tabVisibilitiesDiffList = new ArrayList<String>();
					List<TabVisibilities> tabVisibilitiesToAddInBitbucket = new ArrayList<TabVisibilities>();
					if(bitbucketTabVisibilities != null && orgTabVisibilities != null) {
						for (TabVisibilities orgtv : orgTabVisibilities) {
							if (containsTVByTabName(orgtv.getTab(), bitbucketTabVisibilities)) {
								TabVisibilities bitbuckettv = getTVByTabName(orgtv.getTab(), bitbucketTabVisibilities);
								if (!orgtv.equals(bitbuckettv)) {
									tabVisibilitiesDiffList.add(orgtv.getTab());
								}
							} else {
								tabVisibilitiesNotInRepo.add(orgtv.getTab());
							}
						}
						tabVisibilitiesToAddInBitbucket.addAll(bitbucketTabVisibilities);
					} else if(bitbucketTabVisibilities == null && orgTabVisibilities != null) {
						for (TabVisibilities orgtv : orgTabVisibilities) {
							tabVisibilitiesNotInRepo.add(orgtv.getTab());
						}
					}
					if(tabVisibilitiesToAddInBitbucket.size() > 0) {
						Collections.sort(tabVisibilitiesToAddInBitbucket, TabVisibilities.tabVisibilitiesComparator);
						bitbucketTempProfile.setTabVisibilities(tabVisibilitiesToAddInBitbucket);
					}
					diffPermissionLists.add(tabVisibilitiesDiffList);
					diffPermissionLists.add(tabVisibilitiesNotInRepo);
					// Diff Tab Visibility End

					// Diff User Permissions Start
					List<UserPermissions> bitbucketUserPermissions = bitbucketProfile.getUserPermissions();
					List<UserPermissions> orgLayoutUserPermissions = orgProfile.getUserPermissions();
					List<String> userPermissionsNotInRepo = new ArrayList<String>();
					List<String> userPermissionsDiffList = new ArrayList<String>();
					List<UserPermissions> userPermissionsToAddInBitbucket = new ArrayList<UserPermissions>();
					if(bitbucketUserPermissions != null && orgLayoutUserPermissions != null) {
						for (UserPermissions orgup : orgLayoutUserPermissions) {
							if (containsUPByName(orgup.getName(), bitbucketUserPermissions)) {
								UserPermissions bitbucketup = getUPByName(orgup.getName(), bitbucketUserPermissions);
								if (!orgup.equals(bitbucketup)) {
									userPermissionsDiffList.add(orgup.getName());
								}
							} else {
								if(orgup.getEnabled()) {
									userPermissionsNotInRepo.add(orgup.getName());
								} else if(!orgup.getEnabled()) {
									userPermissionsToAddInBitbucket.add(orgup);
								}
							}
						}
						userPermissionsToAddInBitbucket.addAll(bitbucketUserPermissions);
					} else if(bitbucketUserPermissions == null && orgLayoutUserPermissions != null) {
						for (UserPermissions orgup : orgLayoutUserPermissions) {
							if(orgup.getEnabled()) {
								userPermissionsNotInRepo.add(orgup.getName());
							} else if(!orgup.getEnabled()) {
								userPermissionsToAddInBitbucket.add(orgup);
							}
						}
					}
					if(userPermissionsToAddInBitbucket.size() > 0) {
						Collections.sort(userPermissionsToAddInBitbucket, UserPermissions.userPermissionsComparator);
						bitbucketTempProfile.setUserPermissions(userPermissionsToAddInBitbucket);
					}
					diffPermissionLists.add(userPermissionsDiffList);
					diffPermissionLists.add(userPermissionsNotInRepo);
					// Diff User Permission End
					profileFieldPermissionMap.put(orgProfile.getProfileName(), diffPermissionLists);
					bitbucketTempProfile.setCustom(bitbucketProfile.getCustom());
					bitbucketTempProfile.setUserLicense(bitbucketProfile.getUserLicense());
					bitbucketTempProfile.setProfileName(bitbucketProfile.getProfileName());
					bitbucketTempProfiles.add(bitbucketTempProfile);
				} else {
					profilesNotInRepo.add(orgProfile.getProfileName());
				}
			}
			FileHandling dir = new FileHandling();
			dir.deleteFilesFromFolder("Result/ProfileCompareTextFiles");
			dir.deleteFilesFromFolder("Result/BitbucketProfilesTemp");
			dir.deleteFilesFromFolder("Result/ProfileCompareExcelFiles");
			
			ObjectToXML objectToXML = new ObjectToXML();
			for(Profiles tempProfile : bitbucketTempProfiles) {
				objectToXML.setFileOutputStream("Result/BitbucketProfilesTemp/"+tempProfile.getProfileName());
				objectToXML.convertObjecttoXml(tempProfile);
			}
			new ProfileFileExport().exportTxtFile(profileFieldPermissionMap);
			new ProfileFileExport().exportExcelFile(profileFieldPermissionMap);
			System.out.println("File Written Successfully");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
    }

    public static Boolean containsProfile(String profileName, Collection<Profiles> bitbucketProfiles) {
		for (Profiles profile : bitbucketProfiles) {
			if (profileName.equals(profile.getProfileName())) {
				return true;
			}
		}
		return false;
	}

	public static Profiles getProfileByName(String profileName, Collection<Profiles> bitbucketProfiles) {
		for (Profiles profile : bitbucketProfiles) {
			if (profileName.equals(profile.getProfileName())) {
				return profile;
			}
		}
		return null;
	}

	public static Boolean containsFPByFieldName(String fieldName, List<FieldPermissions> fieldPermissions) {
		if(fieldPermissions == null) {
			return false;
		}
		for(FieldPermissions fieldPermission: fieldPermissions) {
			if (fieldName.equals(fieldPermission.getField())) {
				return true;
			}
		}
		return false;
	}

	public static FieldPermissions getFPByFieldName(String fieldName, List<FieldPermissions> fieldPermissions) {
		for(FieldPermissions fieldPermission: fieldPermissions) {
			if (fieldName.equals(fieldPermission.getField())) {
				return fieldPermission;
			}
		}
		return null;
	}

	private static boolean containsCPByName(String name, List<CustomPermissions> customPermissions) {
		if(customPermissions == null) {
			return false;
		}
		for(CustomPermissions applicationPermission: customPermissions) {
			if (name.equals(applicationPermission.getName())) {
				return true;
			}
		}
		return false;
	}

	private static CustomPermissions getCPByName(String name, List<CustomPermissions> customPermissions) {
		for(CustomPermissions applicationPermission: customPermissions) {
			if (name.equals(applicationPermission.getName())) {
				return applicationPermission;
			}
		}
		return null;
	}

	private static boolean containsLAByLayoutName(String name, List<LayoutAssignments> layoutPermissions) {
		if(layoutPermissions == null) {
			return false;
		}
		for(LayoutAssignments layoutAssignment: layoutPermissions) {
			if (name.equals(layoutAssignment.getLayout() + (layoutAssignment.getRecordType() == null ? "" : layoutAssignment.getRecordType()) )) {
				return true;
			}
		}
		return false;
	}

	private static boolean containsOPByObjectName(String name, List<ObjectPermissions> objectPermissions) {
		if(objectPermissions == null) {
			return false;
		}
		for(ObjectPermissions objectPermission: objectPermissions) {
			if (name.equals(objectPermission.getObject())) {
				return true;
			}
		}
		return false;
	}

	private static ObjectPermissions getOPByObjectName(String name, List<ObjectPermissions> objectPermissions) {
		for(ObjectPermissions objectPermission: objectPermissions) {
			if (name.equals(objectPermission.getObject())) {
				return objectPermission;
			}
		}
		return null;
	}

	private static boolean containsPAByApexPageName(String name, List<PageAccesses> pageAccesses) {
		if(pageAccesses == null) {
			return false;
		}
		for(PageAccesses pageAccess: pageAccesses) {
			if (name.equals(pageAccess.getApexPage())) {
				return true;
			}
		}
		return false;
	}

	private static PageAccesses getPAByApexPageName(String name, List<PageAccesses> pageAccesses) {
		for(PageAccesses pageAccess: pageAccesses) {
			if (name.equals(pageAccess.getApexPage())) {
				return pageAccess;
			}
		}
		return null;
	}

	private static boolean containsRVByRecordTypeName(String name, List<RecordTypeVisibilities> recordTypeVisibilities) {
		if(recordTypeVisibilities == null) {
			return false;
		}
		for(RecordTypeVisibilities recordTypeVisibility: recordTypeVisibilities) {
			if (name.equals(recordTypeVisibility.getRecordType())) {
				return true;
			}
		}
		return false;
	}

	private static RecordTypeVisibilities getRVByRecordTypeName(String name, List<RecordTypeVisibilities> recordTypeVisibilities) {
		for(RecordTypeVisibilities recordTypeVisibility: recordTypeVisibilities) {
			if (name.equals(recordTypeVisibility.getRecordType())) {
				return recordTypeVisibility;
			}
		}
		return null;
	}

	private static boolean containsTVByTabName(String name, List<TabVisibilities> tabVisibilities) {
		if(tabVisibilities == null) {
			return false;
		}
		for(TabVisibilities recordTypeVisibility: tabVisibilities) {
			if (name.equals(recordTypeVisibility.getTab())) {
				return true;
			}
		}
		return false;
	}

	private static TabVisibilities getTVByTabName(String name, List<TabVisibilities> tabVisibilities) {
		for(TabVisibilities recordTypeVisibility: tabVisibilities) {
			if (name.equals(recordTypeVisibility.getTab())) {
				return recordTypeVisibility;
			}
		}
		return null;
	}

	private static boolean containsUPByName(String name, List<UserPermissions> userPermissions) {
		if(userPermissions == null) {
			return false;
		}
		for(UserPermissions userPermission: userPermissions) {
			if (name.equals(userPermission.getName())) {
				return true;
			}
		}
		return false;
	}

	private static UserPermissions getUPByName(String name, List<UserPermissions> userPermissions) {
		for(UserPermissions userPermission: userPermissions) {
			if (name.equals(userPermission.getName())) {
				return userPermission;
			}
		}
		return null;
	}
}