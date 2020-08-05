package com.metadata.Profile.PojoCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metadata.Profile.Profiles;
import com.metadata.Profile.Pojo.ApplicationVisibilities;

public class ApplicationVisiblityCompare {

    private List<String> applicationVisiblityNotInRepo;
    private List<String> applicationVisiblityDiffList;
    private List<ApplicationVisibilities> applicationVisiblityToAddInBitbucket;
    
    public void compare(Profiles orgProfile, Profiles bitbucketProfile) {
        List<ApplicationVisibilities> bitbucketApplicationVisibilities = bitbucketProfile.getApplicationVisibilities();
        List<ApplicationVisibilities> orgApplicationVisibilities = orgProfile.getApplicationVisibilities();
        applicationVisiblityNotInRepo = new ArrayList<String>();
        applicationVisiblityDiffList = new ArrayList<String>();
        applicationVisiblityToAddInBitbucket = new ArrayList<ApplicationVisibilities>();
        
        if (bitbucketApplicationVisibilities != null && orgApplicationVisibilities != null) {
            for (ApplicationVisibilities orgav : orgApplicationVisibilities) {
                if (containsAVByApplicationName(orgav.getApplication(), bitbucketApplicationVisibilities)) {
                    ApplicationVisibilities bitbucketav = getAVByApplicationName(orgav.getApplication(),
                            bitbucketApplicationVisibilities);
                    if (!orgav.equals(bitbucketav)) {
                        applicationVisiblityDiffList.add(orgav.getApplication());
                    }
                } else {
                    if (orgav.getDefaultTag() || orgav.getVisible()) {
                        applicationVisiblityNotInRepo.add(orgav.getApplication());
                    } else if (!orgav.getDefaultTag() && !orgav.getVisible()) {
                        applicationVisiblityToAddInBitbucket.add(orgav);
                    }
                }
            }
            applicationVisiblityToAddInBitbucket.addAll(bitbucketApplicationVisibilities);
        } else if (bitbucketApplicationVisibilities == null && orgApplicationVisibilities != null) {
            for (ApplicationVisibilities orgApplicationVisibility : orgApplicationVisibilities) {
                if (orgApplicationVisibility.getDefaultTag() || orgApplicationVisibility.getVisible()) {
                    applicationVisiblityNotInRepo.add(orgApplicationVisibility.getApplication());
                } else if (!orgApplicationVisibility.getDefaultTag() && !orgApplicationVisibility.getVisible()) {
                    applicationVisiblityToAddInBitbucket.add(orgApplicationVisibility);
                }
            }
        }
        if (applicationVisiblityToAddInBitbucket.size() > 0) {
            Collections.sort(applicationVisiblityToAddInBitbucket, ApplicationVisibilities.applicationComparator);
        }
    }

    public Boolean containsAVByApplicationName(String applicationName, List<ApplicationVisibilities> applicationPermissions) {
		if(applicationPermissions == null) {
			return false;
		}
		for(ApplicationVisibilities applicationPermission: applicationPermissions) {
			if (applicationName.equals(applicationPermission.getApplication())) {
				return true;
			}
		}
		return false;
	}

	public ApplicationVisibilities getAVByApplicationName(String applicationName, List<ApplicationVisibilities> applicationPermissions) {
		for(ApplicationVisibilities applicationPermission: applicationPermissions) {
			if (applicationName.equals(applicationPermission.getApplication())) {
				return applicationPermission;
			}
		}
		return null;
	}

    public List<String> getApplicationVisiblityNotInRepo() {
        return applicationVisiblityNotInRepo;
    }

    public List<String> getApplicationVisiblityDiffList() {
        return applicationVisiblityDiffList;
    }

    public List<ApplicationVisibilities> getApplicationVisiblityToAddInBitbucket() {
        return applicationVisiblityToAddInBitbucket;
    }
}