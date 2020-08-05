package com.metadata.Profile.PojoCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metadata.Profile.Profiles;
import com.metadata.Profile.Pojo.UserPermissions;

public class UserPermissionsCompare {

    private List<String> userPermissionsNotInRepo;
    private List<String> userPermissionsDiffList;
    private List<UserPermissions> userPermissionsToAddInBitbucket;

    public void compare(Profiles orgProfile, Profiles bitbucketProfile) {
        List<UserPermissions> bitbucketUserPermissions = bitbucketProfile.getUserPermissions();
        List<UserPermissions> orgLayoutUserPermissions = orgProfile.getUserPermissions();
        userPermissionsNotInRepo = new ArrayList<String>();
        userPermissionsDiffList = new ArrayList<String>();
        userPermissionsToAddInBitbucket = new ArrayList<UserPermissions>();
        if (bitbucketUserPermissions != null && orgLayoutUserPermissions != null) {
            for (UserPermissions orgup : orgLayoutUserPermissions) {
                if (containsUPByName(orgup.getName(), bitbucketUserPermissions)) {
                    UserPermissions bitbucketup = getUPByName(orgup.getName(), bitbucketUserPermissions);
                    if (!orgup.equals(bitbucketup)) {
                        userPermissionsDiffList.add(orgup.getName());
                    }
                } else {
                    if (orgup.getEnabled()) {
                        userPermissionsNotInRepo.add(orgup.getName());
                    } else if (!orgup.getEnabled()) {
                        userPermissionsToAddInBitbucket.add(orgup);
                    }
                }
            }
            userPermissionsToAddInBitbucket.addAll(bitbucketUserPermissions);
        } else if (bitbucketUserPermissions == null && orgLayoutUserPermissions != null) {
            for (UserPermissions orgup : orgLayoutUserPermissions) {
                if (orgup.getEnabled()) {
                    userPermissionsNotInRepo.add(orgup.getName());
                } else if (!orgup.getEnabled()) {
                    userPermissionsToAddInBitbucket.add(orgup);
                }
            }
        }
        if (userPermissionsToAddInBitbucket.size() > 0) {
            Collections.sort(userPermissionsToAddInBitbucket, UserPermissions.userPermissionsComparator);
        }
    }

    private boolean containsUPByName(String name, List<UserPermissions> userPermissions) {
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

	private UserPermissions getUPByName(String name, List<UserPermissions> userPermissions) {
		for(UserPermissions userPermission: userPermissions) {
			if (name.equals(userPermission.getName())) {
				return userPermission;
			}
		}
		return null;
	}

    public List<String> getUserPermissionsNotInRepo() {
        return userPermissionsNotInRepo;
    }

    public List<String> getUserPermissionsDiffList() {
        return userPermissionsDiffList;
    }

    public List<UserPermissions> getUserPermissionsToAddInBitbucket() {
        return userPermissionsToAddInBitbucket;
    }
}