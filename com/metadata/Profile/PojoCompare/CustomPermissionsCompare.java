package com.metadata.Profile.PojoCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metadata.Profile.Profiles;
import com.metadata.Profile.Pojo.CustomPermissions;

public class CustomPermissionsCompare {

    private List<String> customPermissionsNotInRepo;
    private List<String> customPermissionsDiffList;
    private List<CustomPermissions> customPermissionsToAddInBitbucket;

    public void compare(Profiles orgProfile, Profiles bitbucketProfile) {
        List<CustomPermissions> bitbucketCustomPermissions = bitbucketProfile.getCustomPermissions();
        List<CustomPermissions> orgCustomPermissions = orgProfile.getCustomPermissions();
        customPermissionsNotInRepo = new ArrayList<String>();
        customPermissionsDiffList = new ArrayList<String>();
        customPermissionsToAddInBitbucket = new ArrayList<CustomPermissions>();
        if (bitbucketCustomPermissions != null && orgCustomPermissions != null) {
            for (CustomPermissions orgcp : orgCustomPermissions) {
                if (containsCPByName(orgcp.getName(), bitbucketCustomPermissions)) {
                    CustomPermissions bitbucketcp = getCPByName(orgcp.getName(), bitbucketCustomPermissions);
                    if (!orgcp.equals(bitbucketcp)) {
                        customPermissionsDiffList.add(orgcp.getName());
                    }
                } else {
                    if (orgcp.getEnabled()) {
                        customPermissionsNotInRepo.add(orgcp.getName());
                    } else if (!orgcp.getEnabled()) {
                        customPermissionsToAddInBitbucket.add(orgcp);
                    }
                }
            }
            customPermissionsToAddInBitbucket.addAll(bitbucketCustomPermissions);
        } else if (bitbucketCustomPermissions == null && orgCustomPermissions != null) {
            for (CustomPermissions orgcp : orgCustomPermissions) {
                if (orgcp.getEnabled()) {
                    customPermissionsNotInRepo.add(orgcp.getName());
                } else if (!orgcp.getEnabled()) {
                    customPermissionsToAddInBitbucket.add(orgcp);
                }
            }
        }
        if (customPermissionsToAddInBitbucket.size() > 0) {
            Collections.sort(customPermissionsToAddInBitbucket, CustomPermissions.customPermissionComparator);
        }
    }

    private boolean containsCPByName(String name, List<CustomPermissions> customPermissions) {
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

	private CustomPermissions getCPByName(String name, List<CustomPermissions> customPermissions) {
		for(CustomPermissions applicationPermission: customPermissions) {
			if (name.equals(applicationPermission.getName())) {
				return applicationPermission;
			}
		}
		return null;
	}

    public List<String> getCustomPermissionsNotInRepo() {
        return customPermissionsNotInRepo;
    }

    public List<String> getCustomPermissionsDiffList() {
        return customPermissionsDiffList;
    }

    public List<CustomPermissions> getCustomPermissionsToAddInBitbucket() {
        return customPermissionsToAddInBitbucket;
    }
}