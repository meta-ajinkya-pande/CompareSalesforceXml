package com.metadata.Profile.PojoCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metadata.Profile.Profiles;
import com.metadata.Profile.Pojo.FieldPermissions;

public class FieldPermissionsCompare {

    private List<String> fieldPermissionNotInRepo;
    private List<String> fieldPermissionNotInRepoAndIsPackaageField;
    private List<String> fieldPermissionDiffList;
    private List<FieldPermissions> fieldPermissionToAddInBitBucket;

    public void compare(Profiles orgProfile, Profiles bitbucketProfile) {
        List<FieldPermissions> bitbucketFieldPermissions = bitbucketProfile.getFieldPermissions();
        List<FieldPermissions> orgFieldPermissions = orgProfile.getFieldPermissions();
        fieldPermissionNotInRepo = new ArrayList<String>();
        fieldPermissionNotInRepoAndIsPackaageField = new ArrayList<String>();
        fieldPermissionDiffList = new ArrayList<String>();
        fieldPermissionToAddInBitBucket = new ArrayList<FieldPermissions>();
        if (bitbucketFieldPermissions != null && orgFieldPermissions != null) {
            for (FieldPermissions orgfp : orgFieldPermissions) {
                if (containsFPByFieldName(orgfp.getField(), bitbucketFieldPermissions)) {
                    FieldPermissions bitbucketfp = getFPByFieldName(orgfp.getField(), bitbucketFieldPermissions);
                    if (!orgfp.equals(bitbucketfp)) {
                        fieldPermissionDiffList.add(orgfp.getField());
                    }
                } else {
                    String fullFieldName = orgfp.getField();
                    String[] fieldWithoutObjectName = fullFieldName.split("\\.");
                    String fieldWithoutUUC = fieldWithoutObjectName[1].substring(0,
                            fieldWithoutObjectName[1].length() - 3);
                    if ((orgfp.getEditable() || orgfp.getReadable()) && !fieldWithoutUUC.contains("__")) {
                        fieldPermissionNotInRepo.add(orgfp.getField());
                    } else if ((orgfp.getEditable() || orgfp.getReadable()) && fieldWithoutUUC.contains("__")) {
                        fieldPermissionNotInRepoAndIsPackaageField.add(orgfp.getField());
                    } else if (!orgfp.getEditable() && !orgfp.getReadable()) {
                        fieldPermissionToAddInBitBucket.add(orgfp);
                    }
                }
            }
            fieldPermissionToAddInBitBucket.addAll(bitbucketFieldPermissions);
        } else if (bitbucketFieldPermissions == null && orgFieldPermissions != null) {
            for (FieldPermissions orgfp : orgFieldPermissions) {
                String fullFieldName = orgfp.getField();
                String[] fieldWithoutObjectName = fullFieldName.split("\\.");
                String fieldWithoutUUC = fieldWithoutObjectName[1].substring(0, fieldWithoutObjectName[1].length() - 3);
                if ((orgfp.getEditable() || orgfp.getReadable()) && !fieldWithoutUUC.contains("__")) {
                    fieldPermissionNotInRepo.add(orgfp.getField());
                } else if ((orgfp.getEditable() || orgfp.getReadable()) && fieldWithoutUUC.contains("__")) {
                    fieldPermissionNotInRepoAndIsPackaageField.add(orgfp.getField());
                } else if (!orgfp.getEditable() && !orgfp.getReadable()) {
                    fieldPermissionToAddInBitBucket.add(orgfp);
                }
            }
        }
        if (fieldPermissionToAddInBitBucket.size() > 0) {
            Collections.sort(fieldPermissionToAddInBitBucket, FieldPermissions.fieldPermissionComparator);
        }
    }

    private Boolean containsFPByFieldName(String fieldName, List<FieldPermissions> fieldPermissions) {
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

	private FieldPermissions getFPByFieldName(String fieldName, List<FieldPermissions> fieldPermissions) {
		for(FieldPermissions fieldPermission: fieldPermissions) {
			if (fieldName.equals(fieldPermission.getField())) {
				return fieldPermission;
			}
		}
		return null;
	}

    public List<String> getFieldPermissionNotInRepo() {
        return fieldPermissionNotInRepo;
    }

    public List<String> getFieldPermissionNotInRepoAndIsPackaageField() {
        return fieldPermissionNotInRepoAndIsPackaageField;
    }

    public List<String> getFieldPermissionDiffList() {
        return fieldPermissionDiffList;
    }

    public List<FieldPermissions> getFieldPermissionToAddInBitBucket() {
        return fieldPermissionToAddInBitBucket;
    }
}