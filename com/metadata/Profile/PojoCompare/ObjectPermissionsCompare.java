package com.metadata.Profile.PojoCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metadata.Profile.Profiles;
import com.metadata.Profile.Pojo.ObjectPermissions;

public class ObjectPermissionsCompare {
    
    private List<String> objectPermissionNotInRepo;
    private List<String> objectPermissionDiffList;
    private List<ObjectPermissions> objectPermissionToAddInBitbucket;

    public void compare(Profiles orgProfile, Profiles bitbucketProfile) {
        List<ObjectPermissions> bitbucketObjectPermissions = bitbucketProfile.getObjectPermissions();
        List<ObjectPermissions> orgObjectPermissions = orgProfile.getObjectPermissions();
        objectPermissionNotInRepo = new ArrayList<String>();
        objectPermissionDiffList = new ArrayList<String>();
        objectPermissionToAddInBitbucket = new ArrayList<ObjectPermissions>();
        if (bitbucketObjectPermissions != null && orgObjectPermissions != null) {
            for (ObjectPermissions orgop : orgObjectPermissions) {
                if (containsOPByObjectName(orgop.getObject(), bitbucketObjectPermissions)) {
                    ObjectPermissions bitbucketop = getOPByObjectName(orgop.getObject(), bitbucketObjectPermissions);
                    if (!orgop.equals(bitbucketop)) {
                        objectPermissionDiffList.add(orgop.getObject());
                    }
                } else {
                    if (orgop.getAllowCreate() || orgop.getAllowDelete() || orgop.getAllowEdit() || orgop.getAllowRead()
                            || orgop.getModifyAllRecords() || orgop.getViewAllRecords()) {
                        objectPermissionNotInRepo.add(orgop.getObject());
                    } else if (!orgop.getAllowCreate() && !orgop.getAllowDelete() && !orgop.getAllowEdit()
                            && !orgop.getAllowRead() && !orgop.getModifyAllRecords() && !orgop.getViewAllRecords()) {
                        objectPermissionToAddInBitbucket.add(orgop);
                    }
                }
            }
            objectPermissionToAddInBitbucket.addAll(bitbucketObjectPermissions);
        } else if (bitbucketObjectPermissions == null && orgObjectPermissions != null) {
            for (ObjectPermissions orgop : orgObjectPermissions) {
                if (orgop.getAllowCreate() || orgop.getAllowDelete() || orgop.getAllowEdit() || orgop.getAllowRead()
                        || orgop.getModifyAllRecords() || orgop.getViewAllRecords()) {
                    objectPermissionNotInRepo.add(orgop.getObject());
                } else if (!orgop.getAllowCreate() && !orgop.getAllowDelete() && !orgop.getAllowEdit()
                        && !orgop.getAllowRead() && !orgop.getModifyAllRecords() && !orgop.getViewAllRecords()) {
                    objectPermissionToAddInBitbucket.add(orgop);
                }
            }
        }
        if (objectPermissionToAddInBitbucket.size() > 0) {
            Collections.sort(objectPermissionToAddInBitbucket, ObjectPermissions.objectPermissionComparator);
        }
    }

    private boolean containsOPByObjectName(String name, List<ObjectPermissions> objectPermissions) {
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

	private ObjectPermissions getOPByObjectName(String name, List<ObjectPermissions> objectPermissions) {
		for(ObjectPermissions objectPermission: objectPermissions) {
			if (name.equals(objectPermission.getObject())) {
				return objectPermission;
			}
		}
		return null;
	}

    public List<String> getObjectPermissionNotInRepo() {
        return objectPermissionNotInRepo;
    }

    public List<String> getObjectPermissionDiffList() {
        return objectPermissionDiffList;
    }

    public List<ObjectPermissions> getObjectPermissionToAddInBitbucket() {
        return objectPermissionToAddInBitbucket;
    }
}