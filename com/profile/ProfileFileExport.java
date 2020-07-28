package com.profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.util.ExportExcelFile;
import com.util.ExportTxtFile;

public class ProfileFileExport {

    public void exportTxtFile(Map<String, List<List<String>>> profileFieldPermissionMap) throws IOException {
        for(String filename : profileFieldPermissionMap.keySet()) {
            String myContents = filename + " Comparision File";
            List<List<String>> diffObjList = profileFieldPermissionMap.get(filename);
            List<String> appDiffList = diffObjList.get(0);
            if(appDiffList.size() > 0) {
                myContents += "\n\nApplicationVisiblities(Difference in Repo and Org)) /";
                for(String str : appDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> appNotInRepo = diffObjList.get(1);
            if(appNotInRepo.size() > 0) {
                myContents += "\n\nApplicationVisiblities(Not in Repo but in Org) /";
                for(String str : appNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> classAccessDiffList = diffObjList.get(2);
            if(classAccessDiffList.size() > 0) {
                myContents += "\n\nClassAccesses(Difference in Repo and Org)) /";
                for(String str : classAccessDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> classAccessNotInRepo = diffObjList.get(3);
            if(classAccessNotInRepo.size() > 0) {
                myContents += "\n\nClassAccesses(Not in Repo but in Org) /";
                for(String str : classAccessNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> customPermissionDiffList = diffObjList.get(4);
            if(customPermissionDiffList.size() > 0) {
                myContents += "\n\nCustomPermission(Difference in Repo and Org)) /";
                for(String str : customPermissionDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> customPermissionNotInRepo = diffObjList.get(5);
            if(customPermissionNotInRepo.size() > 0) {
                myContents += "\n\nCustomPermission(Not in Repo but in Org) /";
                for(String str : customPermissionNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> fieldPermissionDiffList = diffObjList.get(6);
            if(fieldPermissionDiffList.size() > 0) {
                myContents += "\n\nFieldPermissions(Difference in Repo and Org) /";
                for(String str : fieldPermissionDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> fieldPermissionNotInRepo = diffObjList.get(7);
            if(fieldPermissionNotInRepo.size() > 0) {
                myContents += "\n\nFieldPermissions(Not in Repo but in Org) /";
                for(String str : fieldPermissionNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> fieldPermissionNotInRepoAndIsPackageField = diffObjList.get(8);
            if(fieldPermissionNotInRepoAndIsPackageField.size() > 0) {
                myContents += "\n\nFieldPermissions(Not in Repo but in Org and package field) /";
                for(String str : fieldPermissionNotInRepoAndIsPackageField) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> layoutAssignmentNotInRepo = diffObjList.get(9);
            if(layoutAssignmentNotInRepo.size() > 0) {
                myContents += "\n\nLayoutAssignment(Not in Repo but in Org) /";
                for(String str : layoutAssignmentNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> objectPermissionDiffList = diffObjList.get(10);
            if(objectPermissionDiffList.size() > 0) {
                myContents += "\n\nObjectPermissions(Difference in Repo and Org)) /";
                for(String str : objectPermissionDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> objectPermissionNotInRepo = diffObjList.get(11);
            if(objectPermissionNotInRepo.size() > 0) {
                myContents += "\n\nObjectPermissions(Not in Repo but in Org) /";
                for(String str : objectPermissionNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> pageAccessesDiffList = diffObjList.get(12);
            if(pageAccessesDiffList.size() > 0) {
                myContents += "\n\nPageAccesses(Difference in Repo and Org)) /";
                for(String str : pageAccessesDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> pageAccessesNotInRepo = diffObjList.get(13);
            if(pageAccessesNotInRepo.size() > 0) {
                myContents += "\n\nPageAccesses(Not in Repo but in Org) /";
                for(String str : pageAccessesNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> recordTypeVisibilitiesDiffList = diffObjList.get(14);
            if(recordTypeVisibilitiesDiffList.size() > 0) {
                myContents += "\n\nRecordTypeVisibilities(Difference in Repo and Org)) /";
                for(String str : recordTypeVisibilitiesDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> recordTypeVisibilitiesNotInRepo = diffObjList.get(15);
            if(recordTypeVisibilitiesNotInRepo.size() > 0) {
                myContents += "\n\nRecordTypeVisibilities(Not in Repo but in Org) /";
                for(String str : recordTypeVisibilitiesNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> tabVisibilitiesDiffList = diffObjList.get(16);
            if(tabVisibilitiesDiffList.size() > 0) {
                myContents += "\n\nTabVisibilities(Difference in Repo and Org)) /";
                for(String str : tabVisibilitiesDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> tabVisibilitiesNotInRepo = diffObjList.get(17);
            if(tabVisibilitiesNotInRepo.size() > 0) {
                myContents += "\n\nTabVisibilities(Not in Repo but in Org) /";
                for(String str : tabVisibilitiesNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> userPermissionDiffList = diffObjList.get(18);
            if(userPermissionDiffList.size() > 0) {
                myContents += "\n\nUserPermissions(Difference in Repo and Org)) /";
                for(String str : userPermissionDiffList) {
                    myContents += "\n\t" + str;
                }
            }
            List<String> userPermissionNotInRepo = diffObjList.get(19);
            if(userPermissionNotInRepo.size() > 0) {
                myContents += "\n\nUserPermissions(Not in Repo but in Org) /";
                for(String str : userPermissionNotInRepo) {
                    myContents += "\n\t" + str;
                }
            }
            new ExportTxtFile().exportFile(filename, myContents);
        }
    }

    public void exportExcelFile(Map<String, List<List<String>>> profileFieldPermissionMap) throws IOException {
        for(String filename : profileFieldPermissionMap.keySet()) {
            List<List<Object>> myContents = new ArrayList<>();
            List<List<String>> diffObjList = profileFieldPermissionMap.get(filename);
            
            List<Object> row1 = new ArrayList<Object>();
            List<Object> row2 = new ArrayList<Object>();
            List<Object> row3 = new ArrayList<Object>();

            List<String> appDiffList = diffObjList.get(0);
            row1.add("ApplicationVisiblities(Difference in Repo and Org)");
            row1.addAll(appDiffList);
            myContents.add(row1);
            
            
            List<String> appNotInRepo = diffObjList.get(1);
            row2.add("ApplicationVisiblities(Not in Repo but in Org)");
            row2.addAll(appNotInRepo);
            myContents.add(row2);

            if(myContents != null && myContents.size() > 0) {
                new ExportExcelFile().exportFile(filename, "ApplicationVisiblities", myContents);
            }

            myContents.clear();
            row1.clear();
            List<String> classAccessDiffList = diffObjList.get(2);
            row1.add("ClassAccesses(Difference in Repo and Org)");
            row1.addAll(classAccessDiffList);
            myContents.add(row1);

            row2.clear();
            List<String> classAccessNotInRepo = diffObjList.get(3);
            row2.add("ClassAccesses(Not in Repo but in Org)");
            row2.addAll(classAccessNotInRepo);
            myContents.add(row2);

            if(myContents != null && myContents.size() > 0) {
                new ExportExcelFile().exportFile(filename, "ClassAccesses", myContents);
            }

            myContents.clear();
            row1.clear();
            List<String> customPermissionDiffList = diffObjList.get(4);
            row1.add("CustomPermission(Difference in Repo and Org)");
            row1.addAll(customPermissionDiffList);
            myContents.add(row1);

            row2.clear();
            List<String> customPermissionNotInRepo = diffObjList.get(5);
            row2.add("CustomPermission(Not in Repo but in Org)");
            row2.addAll(customPermissionNotInRepo);
            myContents.add(row2);

            if(myContents != null && myContents.size() > 0) {
                new ExportExcelFile().exportFile(filename, "CustomPermission", myContents);
            }

            myContents.clear();
            row1.clear();
            List<String> fieldPermissionDiffList = diffObjList.get(6);
            row1.add("FieldPermissions(Difference in Repo and Org)");
            row1.addAll(fieldPermissionDiffList);
            myContents.add(row1);

            row2.clear();
            List<String> fieldPermissionNotInRepo = diffObjList.get(7);
            row2.add("FieldPermissions(Not in Repo but in Org)");
            row2.addAll(fieldPermissionNotInRepo);
            myContents.add(row2);

            row3.clear();
            List<String> fieldPermissionNotInRepoAndIsPackageField = diffObjList.get(8);
            row3.add("FieldPermissions(Not in Repo but in Org)");
            row3.addAll(fieldPermissionNotInRepoAndIsPackageField);
            myContents.add(row3);

            if(myContents != null && myContents.size() > 0) {
                new ExportExcelFile().exportFile(filename, "FieldPermissions", myContents);
            }

            myContents.clear();
            row1.clear();
            List<String> layoutAssignmentNotInRepo = diffObjList.get(9);
            row1.add("LayoutAssignment(Difference in Repo and Org)");
            row1.addAll(layoutAssignmentNotInRepo);
            myContents.add(row1);

            if(myContents != null && myContents.size() > 0) {
                new ExportExcelFile().exportFile(filename, "FieldPermissions", myContents);
            }

            myContents.clear();
            row1.clear();
            List<String> objectPermissionDiffList = diffObjList.get(10);
            row1.add("ObjectPermissions(Difference in Repo and Org)");
            row1.addAll(objectPermissionDiffList);
            myContents.add(row1);

            row2.clear();
            List<String> objectPermissionNotInRepo = diffObjList.get(11);
            row2.add("ObjectPermissions(Not in Repo but in Org)");
            row2.addAll(objectPermissionNotInRepo);
            myContents.add(row2);

            if(myContents != null && myContents.size() > 0) {
                new ExportExcelFile().exportFile(filename, "ObjectPermissions", myContents);
            }

            myContents.clear();
            row1.clear();
            List<String> pageAccessesDiffList = diffObjList.get(12);
            row1.add("PageAccesses(Difference in Repo and Org)");
            row1.addAll(pageAccessesDiffList);
            myContents.add(row1);

            row2.clear();
            List<String> pageAccessesNotInRepo = diffObjList.get(13);
            row2.add("PageAccesses(Not in Repo but in Org)");
            row2.addAll(pageAccessesNotInRepo);
            myContents.add(row2);

            if(myContents != null && myContents.size() > 0) {
                new ExportExcelFile().exportFile(filename, "PageAccesses", myContents);
            }

            myContents.clear();
            row1.clear();
            List<String> recordTypeVisibilitiesDiffList = diffObjList.get(14);
            row1.add("RecordTypeVisibilities(Difference in Repo and Org)");
            row1.addAll(recordTypeVisibilitiesDiffList);
            myContents.add(row1);

            row2.clear();
            List<String> recordTypeVisibilitiesNotInRepo = diffObjList.get(15);
            row2.add("RecordTypeVisibilities(Not in Repo but in Org)");
            row2.addAll(recordTypeVisibilitiesNotInRepo);
            myContents.add(row2);

            if(myContents != null && myContents.size() > 0) {
                new ExportExcelFile().exportFile(filename, "RecordTypeVisibilities", myContents);
            }

            myContents.clear();
            row1.clear();
            List<String> tabVisibilitiesDiffList = diffObjList.get(16);
            row1.add("TabVisibilities(Difference in Repo and Org)");
            row1.addAll(tabVisibilitiesDiffList);
            myContents.add(row1);

            row2.clear();
            List<String> tabVisibilitiesNotInRepo = diffObjList.get(17);
            row2.add("TabVisibilities(Not in Repo but in Org)");
            row2.addAll(tabVisibilitiesNotInRepo);
            myContents.add(row2);

            if(myContents != null && myContents.size() > 0) {
                new ExportExcelFile().exportFile(filename, "TabVisibilities", myContents);
            }

            myContents.clear();
            row1.clear();
            List<String> userPermissionDiffList = diffObjList.get(18);
            row1.add("UserPermissions(Difference in Repo and Org)");
            row1.addAll(userPermissionDiffList);
            myContents.add(row1);

            row2.clear();
            List<String> userPermissionNotInRepo = diffObjList.get(19);
            row2.add("UserPermissions(Not in Repo but in Org)");
            row2.addAll(userPermissionNotInRepo);
            myContents.add(row2);

            if(myContents != null && myContents.size() > 0) {
                new ExportExcelFile().exportFile(filename, "UserPermissions", myContents);
            }
        }
    }
}