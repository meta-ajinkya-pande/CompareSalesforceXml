package com.metadata.Profile.PojoCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metadata.Profile.Profiles;
import com.metadata.Profile.Pojo.ClassAccesses;

public class ClassAccessCompare {

    List<String> classAccessNotInRepo;
    List<String> classAccessDiffList;
    List<ClassAccesses> classAccessToAddInBitbucket;

    public void compare(Profiles orgProfile, Profiles bitbucketProfile) {
        List<ClassAccesses> bitbucketClassAccesses = bitbucketProfile.getClassAccesses();
        List<ClassAccesses> orgClassAccesses = orgProfile.getClassAccesses();
        classAccessNotInRepo = new ArrayList<String>();
        classAccessDiffList = new ArrayList<String>();
        classAccessToAddInBitbucket = new ArrayList<ClassAccesses>();
        if(bitbucketClassAccesses != null && orgClassAccesses != null) {
            for (ClassAccesses orgca : orgClassAccesses) {
                if (containsCAByApexClassName(orgca.getApexClass(), bitbucketClassAccesses)) {
                    ClassAccesses bitbucketca = getCAByApexClassName(orgca.getApexClass(), bitbucketClassAccesses);
                    if (!orgca.equals(bitbucketca)) {
                        classAccessDiffList.add(orgca.getApexClass());
                    }
                } else {
                    if(orgca.getEnabled()) {
                        classAccessNotInRepo.add(orgca.getApexClass());
                    } else if(!orgca.getEnabled()) {
                        classAccessToAddInBitbucket.add(orgca);
                    }
                }
            }
            classAccessToAddInBitbucket.addAll(bitbucketClassAccesses);
        } else if(bitbucketClassAccesses == null && orgClassAccesses != null) {
            for (ClassAccesses orgClassAccess : orgClassAccesses) {
                if(orgClassAccess.getEnabled()) {
                    classAccessNotInRepo.add(orgClassAccess.getApexClass());
                } else if(!orgClassAccess.getEnabled()) {
                    classAccessToAddInBitbucket.add(orgClassAccess);
                }
            }
        }
        if(classAccessToAddInBitbucket.size() > 0) {
            Collections.sort(classAccessToAddInBitbucket, ClassAccesses.apexClassComparator);
        }
    }

    public Boolean containsCAByApexClassName(String apexClassName, List<ClassAccesses> classAccesses) {
		if(classAccesses == null) {
			return false;
		}
		for(ClassAccesses applicationPermission: classAccesses) {
			if (apexClassName.equals(applicationPermission.getApexClass())) {
				return true;
			}
		}
		return false;
	}

	public ClassAccesses getCAByApexClassName(String apexClassName, List<ClassAccesses> classAccesses) {
		for(ClassAccesses applicationPermission: classAccesses) {
			if (apexClassName.equals(applicationPermission.getApexClass())) {
				return applicationPermission;
			}
		}
		return null;
	}

    public List<String> getClassAccessNotInRepo() {
        return classAccessNotInRepo;
    }

    public List<String> getClassAccessDiffList() {
        return classAccessDiffList;
    }

    public List<ClassAccesses> getClassAccessToAddInBitbucket() {
        return classAccessToAddInBitbucket;
    }
}