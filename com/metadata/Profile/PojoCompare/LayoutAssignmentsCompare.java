package com.metadata.Profile.PojoCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metadata.Profile.Profiles;
import com.metadata.Profile.Pojo.LayoutAssignments;

public class LayoutAssignmentsCompare {
    
    private List<String> layoutAssignmentsNotInRepo;
    private List<LayoutAssignments> layoutAssignmentsToAddInBitbucket;

    public void compare(Profiles orgProfile, Profiles bitbucketProfile) {
        List<LayoutAssignments> bitbucketLayoutAssignments = bitbucketProfile.getLayoutAssignments();
        List<LayoutAssignments> orgLayoutAssignments = orgProfile.getLayoutAssignments();
        layoutAssignmentsNotInRepo = new ArrayList<String>();
        layoutAssignmentsToAddInBitbucket = new ArrayList<LayoutAssignments>();
        if (bitbucketLayoutAssignments != null && orgLayoutAssignments != null) {
            for (LayoutAssignments orgla : orgLayoutAssignments) {
                if (!containsLAByLayoutName(
                        orgla.getLayout() + (orgla.getRecordType() == null ? "" : orgla.getRecordType()),
                        bitbucketLayoutAssignments)) {
                    layoutAssignmentsNotInRepo.add(orgla.getLayout());
                }
            }
            layoutAssignmentsToAddInBitbucket.addAll(bitbucketLayoutAssignments);
        } else if (bitbucketLayoutAssignments == null && orgLayoutAssignments != null) {
            for (LayoutAssignments orgla : orgLayoutAssignments) {
                layoutAssignmentsNotInRepo.add(orgla.getLayout());
            }
        }
        if (layoutAssignmentsToAddInBitbucket.size() > 0) {
            Collections.sort(layoutAssignmentsToAddInBitbucket, LayoutAssignments.layoutAssignmentComparator);
        }
    }

    private boolean containsLAByLayoutName(String name, List<LayoutAssignments> layoutPermissions) {
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

    public List<String> getLayoutAssignmentsNotInRepo() {
        return layoutAssignmentsNotInRepo;
    }

    public List<LayoutAssignments> getLayoutAssignmentsToAddInBitbucket() {
        return layoutAssignmentsToAddInBitbucket;
    }
}