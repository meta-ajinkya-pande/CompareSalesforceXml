package com.metadata.Profile.PojoCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metadata.Profile.Profiles;
import com.metadata.Profile.Pojo.TabVisibilities;

public class TabVisibilitiesCompare {
    
    private List<String> tabVisibilitiesNotInRepo;
    private List<String> tabVisibilitiesDiffList;
    private List<TabVisibilities> tabVisibilitiesToAddInBitbucket;

    public void compare(Profiles orgProfile, Profiles bitbucketProfile) {
        List<TabVisibilities> bitbucketTabVisibilities = bitbucketProfile.getTabVisibilities();
        List<TabVisibilities> orgTabVisibilities = orgProfile.getTabVisibilities();
        tabVisibilitiesNotInRepo = new ArrayList<String>();
        tabVisibilitiesDiffList = new ArrayList<String>();
        tabVisibilitiesToAddInBitbucket = new ArrayList<TabVisibilities>();
        if (bitbucketTabVisibilities != null && orgTabVisibilities != null) {
            for (TabVisibilities orgtv : orgTabVisibilities) {
                if (containsTVByTabName(orgtv.getTab(), bitbucketTabVisibilities)) {
                    TabVisibilities bitbuckettv = getTVByTabName(orgtv.getTab(), bitbucketTabVisibilities);
                    if (!orgtv.equals(bitbuckettv)) {
                        tabVisibilitiesDiffList.add(orgtv.getTab());
                    }
                } else {
                    tabVisibilitiesNotInRepo.add(orgtv.getTab());
                }
            }
            tabVisibilitiesToAddInBitbucket.addAll(bitbucketTabVisibilities);
        } else if (bitbucketTabVisibilities == null && orgTabVisibilities != null) {
            for (TabVisibilities orgtv : orgTabVisibilities) {
                tabVisibilitiesNotInRepo.add(orgtv.getTab());
            }
        }
        if (tabVisibilitiesToAddInBitbucket.size() > 0) {
            Collections.sort(tabVisibilitiesToAddInBitbucket, TabVisibilities.tabVisibilitiesComparator);
        }
    }

    private boolean containsTVByTabName(String name, List<TabVisibilities> tabVisibilities) {
		if(tabVisibilities == null) {
			return false;
		}
		for(TabVisibilities recordTypeVisibility: tabVisibilities) {
			if (name.equals(recordTypeVisibility.getTab())) {
				return true;
			}
		}
		return false;
	}

	private TabVisibilities getTVByTabName(String name, List<TabVisibilities> tabVisibilities) {
		for(TabVisibilities recordTypeVisibility: tabVisibilities) {
			if (name.equals(recordTypeVisibility.getTab())) {
				return recordTypeVisibility;
			}
		}
		return null;
	}

    public List<String> getTabVisibilitiesNotInRepo() {
        return tabVisibilitiesNotInRepo;
    }

    public List<String> getTabVisibilitiesDiffList() {
        return tabVisibilitiesDiffList;
    }

    public List<TabVisibilities> getTabVisibilitiesToAddInBitbucket() {
        return tabVisibilitiesToAddInBitbucket;
    }
}