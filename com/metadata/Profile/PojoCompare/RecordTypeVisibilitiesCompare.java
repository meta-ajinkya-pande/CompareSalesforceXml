package com.metadata.Profile.PojoCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metadata.Profile.Profiles;
import com.metadata.Profile.Pojo.RecordTypeVisibilities;

public class RecordTypeVisibilitiesCompare {
    
    private List<String> recordTypeVisibilitiesNotInRepo;
    private List<String> recordTypeVisibilitiesDiffList;
    private List<RecordTypeVisibilities> recordTypeVisibilitiesToAddInBitbucket;

    public void compare(Profiles orgProfile, Profiles bitbucketProfile) {
        List<RecordTypeVisibilities> bitbucketRecordTypeVisibilities = bitbucketProfile.getRecordTypeVisibilities();
        List<RecordTypeVisibilities> orgRecordTypeVisibilities = orgProfile.getRecordTypeVisibilities();
        recordTypeVisibilitiesNotInRepo = new ArrayList<String>();
        recordTypeVisibilitiesDiffList = new ArrayList<String>();
        recordTypeVisibilitiesToAddInBitbucket = new ArrayList<RecordTypeVisibilities>();
        if (bitbucketRecordTypeVisibilities != null && orgRecordTypeVisibilities != null) {
            for (RecordTypeVisibilities orgrv : orgRecordTypeVisibilities) {
                if (containsRVByRecordTypeName(orgrv.getRecordType(), bitbucketRecordTypeVisibilities)) {
                    RecordTypeVisibilities bitbucketrv = getRVByRecordTypeName(orgrv.getRecordType(),
                            bitbucketRecordTypeVisibilities);
                    if (!orgrv.equals(bitbucketrv)) {
                        recordTypeVisibilitiesDiffList.add(orgrv.getRecordType());
                    }
                } else {
                    if (orgrv.getDefaultTagRTV() || orgrv.getVisible()) {
                        recordTypeVisibilitiesNotInRepo.add(orgrv.getRecordType());
                    } else if (!orgrv.getDefaultTagRTV() && !orgrv.getVisible()) {
                        recordTypeVisibilitiesToAddInBitbucket.add(orgrv);
                    }
                }
            }
            recordTypeVisibilitiesToAddInBitbucket.addAll(bitbucketRecordTypeVisibilities);
        } else if (bitbucketRecordTypeVisibilities == null && orgRecordTypeVisibilities != null) {
            for (RecordTypeVisibilities orgrv : orgRecordTypeVisibilities) {
                if (orgrv.getDefaultTagRTV() || orgrv.getVisible()) {
                    recordTypeVisibilitiesNotInRepo.add(orgrv.getRecordType());
                } else if (!orgrv.getDefaultTagRTV() && !orgrv.getVisible()) {
                    recordTypeVisibilitiesToAddInBitbucket.add(orgrv);
                }
            }
        }
        if (recordTypeVisibilitiesToAddInBitbucket.size() > 0) {
            Collections.sort(recordTypeVisibilitiesToAddInBitbucket, RecordTypeVisibilities.recordTypeVisiblitiesComparator);
        }
    }

    private boolean containsRVByRecordTypeName(String name, List<RecordTypeVisibilities> recordTypeVisibilities) {
		if(recordTypeVisibilities == null) {
			return false;
		}
		for(RecordTypeVisibilities recordTypeVisibility: recordTypeVisibilities) {
			if (name.equals(recordTypeVisibility.getRecordType())) {
				return true;
			}
		}
		return false;
	}

	private RecordTypeVisibilities getRVByRecordTypeName(String name, List<RecordTypeVisibilities> recordTypeVisibilities) {
		for(RecordTypeVisibilities recordTypeVisibility: recordTypeVisibilities) {
			if (name.equals(recordTypeVisibility.getRecordType())) {
				return recordTypeVisibility;
			}
		}
		return null;
	}

    public List<String> getRecordTypeVisibilitiesNotInRepo() {
        return recordTypeVisibilitiesNotInRepo;
    }

    public List<String> getRecordTypeVisibilitiesDiffList() {
        return recordTypeVisibilitiesDiffList;
    }

    public List<RecordTypeVisibilities> getRecordTypeVisibilitiesToAddInBitbucket() {
        return recordTypeVisibilitiesToAddInBitbucket;
    }
}