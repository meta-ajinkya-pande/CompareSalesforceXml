package com.metadata.Profile.ProfileUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.main.util.XmlToObject;
import com.metadata.Profile.Profiles;
import com.metadata.Profile.PojoCompare.ApplicationVisiblityCompare;
import com.metadata.Profile.PojoCompare.ClassAccessCompare;
import com.metadata.Profile.PojoCompare.CustomPermissionsCompare;
import com.metadata.Profile.PojoCompare.FieldPermissionsCompare;
import com.metadata.Profile.PojoCompare.LayoutAssignmentsCompare;
import com.metadata.Profile.PojoCompare.ObjectPermissionsCompare;
import com.metadata.Profile.PojoCompare.PageAccessesCompare;
import com.metadata.Profile.PojoCompare.RecordTypeVisibilitiesCompare;
import com.metadata.Profile.PojoCompare.TabVisibilitiesCompare;
import com.metadata.Profile.PojoCompare.UserPermissionsCompare;

public class ProfileCompare {

	private Collection<Profiles> bitbucketProfiles;
	private Collection<Profiles> orgProfiles;
	private Collection<Profiles> bitbucketTempProfiles;
	private List<String> profilesNotInRepo;
	private List<List<String>> diffPermissionLists;
	private Map<String, List<List<String>>> profileFieldPermissionMap;

    public void compare() {
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
					CustomPermissionsCompare cpCompare = new CustomPermissionsCompare();
					cpCompare.compare(orgProfile, bitbucketProfile);
					diffPermissionLists.add(cpCompare.getCustomPermissionsDiffList());
					diffPermissionLists.add(cpCompare.getCustomPermissionsNotInRepo());
					if(cpCompare.getCustomPermissionsToAddInBitbucket() != null && cpCompare.getCustomPermissionsToAddInBitbucket().size() > 0) {
						bitbucketTempProfile.setCustomPermissions(cpCompare.getCustomPermissionsToAddInBitbucket());
					}
					// Diff Custom Permission End
					
					// Diff Field Permissions Start
					FieldPermissionsCompare fpCompare = new FieldPermissionsCompare();
					fpCompare.compare(orgProfile, bitbucketProfile);
					diffPermissionLists.add(fpCompare.getFieldPermissionDiffList());
					diffPermissionLists.add(fpCompare.getFieldPermissionNotInRepo());
					diffPermissionLists.add(fpCompare.getFieldPermissionNotInRepoAndIsPackaageField());
					if(fpCompare.getFieldPermissionToAddInBitBucket() != null && fpCompare.getFieldPermissionToAddInBitBucket().size() > 0) {
						bitbucketTempProfile.setFieldPermissions(fpCompare.getFieldPermissionToAddInBitBucket());
					}
					// Diff Field Permission End

					// Diff Layout Assignment Start
					LayoutAssignmentsCompare laCompare = new LayoutAssignmentsCompare();
					laCompare.compare(orgProfile, bitbucketProfile);
					diffPermissionLists.add(laCompare.getLayoutAssignmentsNotInRepo());
					if(laCompare.getLayoutAssignmentsToAddInBitbucket() != null && laCompare.getLayoutAssignmentsToAddInBitbucket().size() > 0) {
						bitbucketTempProfile.setLayoutAssignments(laCompare.getLayoutAssignmentsToAddInBitbucket());
					}
					// Diff Layout Assignment End

					// Diff Object Permission Start
					ObjectPermissionsCompare opCompare = new ObjectPermissionsCompare();
					opCompare.compare(orgProfile, bitbucketProfile);
					diffPermissionLists.add(opCompare.getObjectPermissionDiffList());
					diffPermissionLists.add(opCompare.getObjectPermissionNotInRepo());
					if(opCompare.getObjectPermissionToAddInBitbucket() != null && opCompare.getObjectPermissionToAddInBitbucket().size() > 0) {
						bitbucketTempProfile.setObjectPermissions(opCompare.getObjectPermissionToAddInBitbucket());
					}
					// Diff Object Permission End

					// Diff Page Accesses Start
					PageAccessesCompare paCompare = new PageAccessesCompare();
					paCompare.compare(orgProfile, bitbucketProfile);
					diffPermissionLists.add(paCompare.getPageAccessesDiffList());
					diffPermissionLists.add(paCompare.getPageAccessesNotInRepo());
					if(paCompare.getPageAccessesToAddInBitbucket() != null && paCompare.getPageAccessesToAddInBitbucket().size() > 0) {
						bitbucketTempProfile.setPageAccesses(paCompare.getPageAccessesToAddInBitbucket());
					}
					// Diff Page Accesses End

					// Diff Recordtype Visiblities Start
					RecordTypeVisibilitiesCompare rvCompare = new RecordTypeVisibilitiesCompare();
					rvCompare.compare(orgProfile, bitbucketProfile);
					diffPermissionLists.add(rvCompare.getRecordTypeVisibilitiesDiffList());
					diffPermissionLists.add(rvCompare.getRecordTypeVisibilitiesNotInRepo());
					if(rvCompare.getRecordTypeVisibilitiesToAddInBitbucket() != null && rvCompare.getRecordTypeVisibilitiesToAddInBitbucket().size() > 0) {
						bitbucketTempProfile.setRecordTypeVisibilities(rvCompare.getRecordTypeVisibilitiesToAddInBitbucket());
					}
					// Diff Recordtype Visiblities End

					// Diff Tab Visibility Start
					TabVisibilitiesCompare tvCompare = new TabVisibilitiesCompare();
					tvCompare.compare(orgProfile, bitbucketProfile);
					diffPermissionLists.add(tvCompare.getTabVisibilitiesDiffList());
					diffPermissionLists.add(tvCompare.getTabVisibilitiesNotInRepo());
					if(tvCompare.getTabVisibilitiesToAddInBitbucket() != null && tvCompare.getTabVisibilitiesToAddInBitbucket().size() > 0) {
						bitbucketTempProfile.setTabVisibilities(tvCompare.getTabVisibilitiesToAddInBitbucket());
					}
					// Diff Tab Visibility End

					// Diff User Permissions Start
					UserPermissionsCompare upCompare = new UserPermissionsCompare();
					upCompare.compare(orgProfile, bitbucketProfile);
					diffPermissionLists.add(upCompare.getUserPermissionsDiffList());
					diffPermissionLists.add(upCompare.getUserPermissionsNotInRepo());
					if(upCompare.getUserPermissionsToAddInBitbucket() != null && upCompare.getUserPermissionsToAddInBitbucket().size() > 0) {
						bitbucketTempProfile.setUserPermissions(upCompare.getUserPermissionsToAddInBitbucket());
					}
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

	public Collection<Profiles> getBitbucketProfiles() {
		return bitbucketProfiles;
	}

	public Collection<Profiles> getOrgProfiles() {
		return orgProfiles;
	}

	public Collection<Profiles> getBitbucketTempProfiles() {
		return bitbucketTempProfiles;
	}

	public List<String> getProfilesNotInRepo() {
		return profilesNotInRepo;
	}

	public List<List<String>> getDiffPermissionLists() {
		return diffPermissionLists;
	}

	public Map<String, List<List<String>>> getProfileFieldPermissionMap() {
		return profileFieldPermissionMap;
	}
}