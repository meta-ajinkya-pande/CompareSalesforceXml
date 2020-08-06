package com.metadata.Profile.ProfileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.main.util.ExportExcelFile;
import com.main.util.ExportTxtFile;
import com.main.util.ObjectToXML;
import com.metadata.Profile.Profiles;

public class ProfileFileExport {

    public void exportTxtFile(Map<String, List<List<String>>> profileFieldPermissionMap) throws IOException {
        for(String filename : profileFieldPermissionMap.keySet()) {
            String myContents = filename + " Comparision File";
            List<List<String>> diffObjList = profileFieldPermissionMap.get(filename);
            List<String> appDiffList = diffObjList.get(0);
            if(appDiffList != null && appDiffList.size() > 0) {
                myContents += "\n\nApplicationVisiblities(Difference in Repo and Org)) /";
                for(String str : appDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> appNotInRepo = diffObjList.get(1);
            if(appNotInRepo != null && appNotInRepo.size() > 0) {
                myContents += "\n\nApplicationVisiblities(Not in Repo but in Org) /";
                for(String str : appNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> classAccessDiffList = diffObjList.get(2);
            if(classAccessDiffList != null && classAccessDiffList.size() > 0) {
                myContents += "\n\nClassAccesses(Difference in Repo and Org)) /";
                for(String str : classAccessDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> classAccessNotInRepo = diffObjList.get(3);
            if(classAccessNotInRepo!= null && classAccessNotInRepo.size() > 0) {
                myContents += "\n\nClassAccesses(Not in Repo but in Org) /";
                for(String str : classAccessNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> customPermissionDiffList = diffObjList.get(4);
            if(customPermissionDiffList!= null && customPermissionDiffList.size() > 0) {
                myContents += "\n\nCustomPermission(Difference in Repo and Org)) /";
                for(String str : customPermissionDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> customPermissionNotInRepo = diffObjList.get(5);
            if(customPermissionNotInRepo != null && customPermissionNotInRepo.size() > 0) {
                myContents += "\n\nCustomPermission(Not in Repo but in Org) /";
                for(String str : customPermissionNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> fieldPermissionDiffList = diffObjList.get(6);
            if(fieldPermissionDiffList != null && fieldPermissionDiffList.size() > 0) {
                myContents += "\n\nFieldPermissions(Difference in Repo and Org) /";
                for(String str : fieldPermissionDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> fieldPermissionNotInRepo = diffObjList.get(7);
            if(fieldPermissionNotInRepo != null && fieldPermissionNotInRepo.size() > 0) {
                myContents += "\n\nFieldPermissions(Not in Repo but in Org) /";
                for(String str : fieldPermissionNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> fieldPermissionNotInRepoAndIsPackageField = diffObjList.get(8);
            if(fieldPermissionNotInRepoAndIsPackageField != null && fieldPermissionNotInRepoAndIsPackageField.size() > 0) {
                myContents += "\n\nFieldPermissions(Not in Repo but in Org and package field) /";
                for(String str : fieldPermissionNotInRepoAndIsPackageField) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> layoutAssignmentNotInRepo = diffObjList.get(9);
            if(layoutAssignmentNotInRepo != null && layoutAssignmentNotInRepo.size() > 0) {
                myContents += "\n\nLayoutAssignment(Not in Repo but in Org) /";
                for(String str : layoutAssignmentNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> objectPermissionDiffList = diffObjList.get(10);
            if(objectPermissionDiffList != null && objectPermissionDiffList.size() > 0) {
                myContents += "\n\nObjectPermissions(Difference in Repo and Org)) /";
                for(String str : objectPermissionDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> objectPermissionNotInRepo = diffObjList.get(11);
            if(objectPermissionNotInRepo != null && objectPermissionNotInRepo.size() > 0) {
                myContents += "\n\nObjectPermissions(Not in Repo but in Org) /";
                for(String str : objectPermissionNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> pageAccessesDiffList = diffObjList.get(12);
            if(pageAccessesDiffList != null && pageAccessesDiffList.size() > 0) {
                myContents += "\n\nPageAccesses(Difference in Repo and Org)) /";
                for(String str : pageAccessesDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> pageAccessesNotInRepo = diffObjList.get(13);
            if(pageAccessesNotInRepo != null && pageAccessesNotInRepo.size() > 0) {
                myContents += "\n\nPageAccesses(Not in Repo but in Org) /";
                for(String str : pageAccessesNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> recordTypeVisibilitiesDiffList = diffObjList.get(14);
            if(recordTypeVisibilitiesDiffList != null && recordTypeVisibilitiesDiffList.size() > 0) {
                myContents += "\n\nRecordTypeVisibilities(Difference in Repo and Org)) /";
                for(String str : recordTypeVisibilitiesDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> recordTypeVisibilitiesNotInRepo = diffObjList.get(15);
            if(recordTypeVisibilitiesNotInRepo != null && recordTypeVisibilitiesNotInRepo.size() > 0) {
                myContents += "\n\nRecordTypeVisibilities(Not in Repo but in Org) /";
                for(String str : recordTypeVisibilitiesNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> tabVisibilitiesDiffList = diffObjList.get(16);
            if(tabVisibilitiesDiffList != null && tabVisibilitiesDiffList.size() > 0) {
                myContents += "\n\nTabVisibilities(Difference in Repo and Org)) /";
                for(String str : tabVisibilitiesDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> tabVisibilitiesNotInRepo = diffObjList.get(17);
            if(tabVisibilitiesNotInRepo != null && tabVisibilitiesNotInRepo.size() > 0) {
                myContents += "\n\nTabVisibilities(Not in Repo but in Org) /";
                for(String str : tabVisibilitiesNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> userPermissionDiffList = diffObjList.get(18);
            if(userPermissionDiffList != null && userPermissionDiffList.size() > 0) {
                myContents += "\n\nUserPermissions(Difference in Repo and Org)) /";
                for(String str : userPermissionDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> userPermissionNotInRepo = diffObjList.get(19);
            if(userPermissionNotInRepo != null && userPermissionNotInRepo.size() > 0) {
                myContents += "\n\nUserPermissions(Not in Repo but in Org) /";
                for(String str : userPermissionNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            new ExportTxtFile().exportFile(filename + "_compare.txt", myContents);
        }
    }

    public void exportExcelFile(Map<String, List<List<String>>> profileFieldPermissionMap) throws IOException {
        for(String filename : profileFieldPermissionMap.keySet()) {
            Map<String, List<List<Object>>> workbook = new TreeMap<>();
            List<List<String>> diffObjList = profileFieldPermissionMap.get(filename);
            
            List<List<Object>> appContents = new ArrayList<>();
            
            List<String> appDiffList = diffObjList.get(0);
            List<Object> apCol1 = new ArrayList<Object>();
            apCol1.add("ApplicationVisiblities(Difference in Repo and Org)");
            apCol1.addAll(appDiffList);
            appContents.add(apCol1);
            
            List<String> appNotInRepo = diffObjList.get(1);
            List<Object> apCol2 = new ArrayList<Object>();
            apCol2.add("ApplicationVisiblities(Not in Repo but in Org)");
            apCol2.addAll(appNotInRepo);
            appContents.add(apCol2);

            if(appContents != null && appContents.size() > 0) {
                workbook.put("ApplicationVisiblities", appContents);
            }

            List<List<Object>> classContents = new ArrayList<>();
            List<String> classAccessDiffList = diffObjList.get(2);
            List<Object> classAccessCol1 = new ArrayList<Object>();
            classAccessCol1.add("ClassAccesses(Difference in Repo and Org)");
            classAccessCol1.addAll(classAccessDiffList);
            classContents.add(classAccessCol1);

            List<String> classAccessNotInRepo = diffObjList.get(3);
            List<Object> classAccessCol2 = new ArrayList<Object>();
            classAccessCol2.add("ClassAccesses(Not in Repo but in Org)");
            classAccessCol2.addAll(classAccessNotInRepo);
            classContents.add(classAccessCol2);

            if(classContents != null && classContents.size() > 0) {
                workbook.put("ClassAccesses", classContents);
            }

            List<List<Object>> customPermissionContents = new ArrayList<>();
            List<String> customPermissionDiffList = diffObjList.get(4);
            List<Object> customPermissionCol1 = new ArrayList<Object>();
            customPermissionCol1.add("CustomPermission(Difference in Repo and Org)");
            customPermissionCol1.addAll(customPermissionDiffList);
            customPermissionContents.add(customPermissionCol1);

            List<String> customPermissionNotInRepo = diffObjList.get(5);
            List<Object> customPermissionCol2 = new ArrayList<Object>();
            customPermissionCol2.add("CustomPermission(Not in Repo but in Org)");
            customPermissionCol2.addAll(customPermissionNotInRepo);
            customPermissionContents.add(customPermissionCol2);

            if(customPermissionContents != null && customPermissionContents.size() > 0) {
                workbook.put("CustomPermission", customPermissionContents);
            }

            List<List<Object>> fieldPermissionContents = new ArrayList<>();
            List<String> fieldPermissionDiffList = diffObjList.get(6);
            List<Object> fieldPermissionCol1 = new ArrayList<Object>();
            fieldPermissionCol1.add("FieldPermissions(Difference in Repo and Org)");
            fieldPermissionCol1.addAll(fieldPermissionDiffList);
            fieldPermissionContents.add(fieldPermissionCol1);

            List<String> fieldPermissionNotInRepo = diffObjList.get(7);
            List<Object> fieldPermissionCol2 = new ArrayList<Object>();
            fieldPermissionCol2.add("FieldPermissions(Not in Repo but in Org)");
            fieldPermissionCol2.addAll(fieldPermissionNotInRepo);
            fieldPermissionContents.add(fieldPermissionCol2);

            List<String> fieldPermissionNotInRepoAndIsPackageField = diffObjList.get(8);
            List<Object> fieldPermissionCol3 = new ArrayList<Object>();
            fieldPermissionCol3.add("FieldPermissions(Not in Repo but in Org and Package fields)");
            fieldPermissionCol3.addAll(fieldPermissionNotInRepoAndIsPackageField);
            fieldPermissionContents.add(fieldPermissionCol3);

            if(fieldPermissionContents != null && fieldPermissionContents.size() > 0) {
                workbook.put("FieldPermissions", fieldPermissionContents);
            }

            List<List<Object>> layoutContents = new ArrayList<>();
            List<String> layoutAssignmentNotInRepo = diffObjList.get(9);
            List<Object> layoutCol1 = new ArrayList<Object>();
            layoutCol1.add("LayoutAssignment(Difference in Repo and Org)");
            layoutCol1.addAll(layoutAssignmentNotInRepo);
            layoutContents.add(layoutCol1);

            if(layoutContents != null && layoutContents.size() > 0) {
                workbook.put("LayoutAssignment", layoutContents);
            }

            List<List<Object>> objectPermissionsContents = new ArrayList<>();
            List<String> objectPermissionDiffList = diffObjList.get(10);
            List<Object> objectPermissionsCol1 = new ArrayList<Object>();
            objectPermissionsCol1.add("ObjectPermissions(Difference in Repo and Org)");
            objectPermissionsCol1.addAll(objectPermissionDiffList);
            objectPermissionsContents.add(objectPermissionsCol1);

            List<String> objectPermissionNotInRepo = diffObjList.get(11);
            List<Object> objectPermissionsCol2 = new ArrayList<Object>();
            objectPermissionsCol2.add("ObjectPermissions(Not in Repo but in Org)");
            objectPermissionsCol2.addAll(objectPermissionNotInRepo);
            objectPermissionsContents.add(objectPermissionsCol2);

            if(objectPermissionsContents != null && objectPermissionsContents.size() > 0) {
                workbook.put("ObjectPermissions", objectPermissionsContents);
            }

            List<List<Object>> pageAccessesContents = new ArrayList<>();
            List<String> pageAccessesDiffList = diffObjList.get(12);
            List<Object> pageAccessesCol1 = new ArrayList<Object>();
            pageAccessesCol1.add("PageAccesses(Difference in Repo and Org)");
            pageAccessesCol1.addAll(pageAccessesDiffList);
            pageAccessesContents.add(pageAccessesCol1);

            List<String> pageAccessesNotInRepo = diffObjList.get(13);
            List<Object> pageAccessesCol2 = new ArrayList<Object>();
            pageAccessesCol2.add("PageAccesses(Not in Repo but in Org)");
            pageAccessesCol2.addAll(pageAccessesNotInRepo);
            pageAccessesContents.add(pageAccessesCol2);

            if(pageAccessesContents != null && pageAccessesContents.size() > 0) {
                workbook.put("PageAccesses", pageAccessesContents);
            }

            List<List<Object>> recordTypeVisibilitiesContents = new ArrayList<>();
            List<String> recordTypeVisibilitiesDiffList = diffObjList.get(14);
            List<Object> recordTypeVisibilitiesCol1 = new ArrayList<Object>();
            recordTypeVisibilitiesCol1.add("RecordTypeVisibilities(Difference in Repo and Org)");
            recordTypeVisibilitiesCol1.addAll(recordTypeVisibilitiesDiffList);
            recordTypeVisibilitiesContents.add(recordTypeVisibilitiesCol1);

            List<String> recordTypeVisibilitiesNotInRepo = diffObjList.get(15);
            List<Object> recordTypeVisibilitiesCol2 = new ArrayList<Object>();
            recordTypeVisibilitiesCol2.add("RecordTypeVisibilities(Not in Repo but in Org)");
            recordTypeVisibilitiesCol2.addAll(recordTypeVisibilitiesNotInRepo);
            recordTypeVisibilitiesContents.add(recordTypeVisibilitiesCol2);

            if(recordTypeVisibilitiesContents != null && recordTypeVisibilitiesContents.size() > 0) {
                workbook.put("RecordTypeVisibilities", recordTypeVisibilitiesContents);
            }

            List<List<Object>> tabVisibilitiesContents = new ArrayList<>();
            List<String> tabVisibilitiesDiffList = diffObjList.get(16);
            List<Object> tabVisibilitiesCol1 = new ArrayList<Object>();
            tabVisibilitiesCol1.add("TabVisibilities(Difference in Repo and Org)");
            tabVisibilitiesCol1.addAll(tabVisibilitiesDiffList);
            tabVisibilitiesContents.add(tabVisibilitiesCol1);

            List<String> tabVisibilitiesNotInRepo = diffObjList.get(17);
            List<Object> tabVisibilitiesCol2 = new ArrayList<Object>();
            tabVisibilitiesCol2.add("TabVisibilities(Not in Repo but in Org)");
            tabVisibilitiesCol2.addAll(tabVisibilitiesNotInRepo);
            tabVisibilitiesContents.add(tabVisibilitiesCol2);

            if(tabVisibilitiesContents != null && tabVisibilitiesContents.size() > 0) {
                workbook.put("TabVisibilities", tabVisibilitiesContents);
            }

            List<List<Object>> userPermissionContents = new ArrayList<>();
            List<String> userPermissionDiffList = diffObjList.get(18);
            List<Object> userPermissionCol1 = new ArrayList<Object>();
            userPermissionCol1.add("UserPermissions(Difference in Repo and Org)");
            userPermissionCol1.addAll(userPermissionDiffList);
            userPermissionContents.add(userPermissionCol1);

            List<String> userPermissionNotInRepo = diffObjList.get(19);
            List<Object> userPermissionCol2 = new ArrayList<Object>();
            userPermissionCol2.add("UserPermissions(Not in Repo but in Org)");
            userPermissionCol2.addAll(userPermissionNotInRepo);
            userPermissionContents.add(userPermissionCol2);

            if(userPermissionContents != null && userPermissionContents.size() > 0) {
                workbook.put("UserPermissions", userPermissionContents);
            }

            new ExportExcelFile().exportFile(filename, workbook);
        }
    }

    public void exportXmlFile(Collection<Profiles> profileCollection) throws Exception {
        ObjectToXML objectToXML = new ObjectToXML();
        for (Profiles tempProfile : profileCollection) {
            objectToXML.setFileOutputStream("Result/BitbucketProfilesTemp/" + tempProfile.getProfileName());
            objectToXML.convertObjecttoXml(tempProfile);
        }
    }
}