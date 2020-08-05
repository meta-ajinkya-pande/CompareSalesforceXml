package com.metadata.Profile.PojoCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metadata.Profile.Profiles;
import com.metadata.Profile.Pojo.PageAccesses;

public class PageAccessesCompare {
    
    private List<String> pageAccessesNotInRepo;
    private List<String> pageAccessesDiffList;
    private List<PageAccesses> pageAccessesToAddInBitbucket;

    public void compare(Profiles orgProfile, Profiles bitbucketProfile) {
        List<PageAccesses> bitbucketPageAccesses = bitbucketProfile.getPageAccesses();
        List<PageAccesses> orgPageAccesses = orgProfile.getPageAccesses();
        pageAccessesNotInRepo = new ArrayList<String>();
        pageAccessesDiffList = new ArrayList<String>();
        pageAccessesToAddInBitbucket = new ArrayList<PageAccesses>();
        if (bitbucketPageAccesses != null && orgPageAccesses != null) {
            for (PageAccesses orgpa : orgPageAccesses) {
                if (containsPAByApexPageName(orgpa.getApexPage(), bitbucketPageAccesses)) {
                    PageAccesses bitbucketpa = getPAByApexPageName(orgpa.getApexPage(), bitbucketPageAccesses);
                    if (!orgpa.equals(bitbucketpa)) {
                        pageAccessesDiffList.add(orgpa.getApexPage());
                    }
                } else {
                    if (orgpa.getEnabled()) {
                        pageAccessesNotInRepo.add(orgpa.getApexPage());
                    } else if (!orgpa.getEnabled()) {
                        pageAccessesToAddInBitbucket.add(orgpa);
                    }
                }
            }
            pageAccessesToAddInBitbucket.addAll(bitbucketPageAccesses);
        } else if (bitbucketPageAccesses == null && orgPageAccesses != null) {
            for (PageAccesses orgpa : orgPageAccesses) {
                if (orgpa.getEnabled()) {
                    pageAccessesNotInRepo.add(orgpa.getApexPage());
                } else if (!orgpa.getEnabled()) {
                    pageAccessesToAddInBitbucket.add(orgpa);
                }
            }
        }
        if (pageAccessesToAddInBitbucket.size() > 0) {
            Collections.sort(pageAccessesToAddInBitbucket, PageAccesses.pageAccessesComparator);
        }
    }

    private static boolean containsPAByApexPageName(String name, List<PageAccesses> pageAccesses) {
		if(pageAccesses == null) {
			return false;
		}
		for(PageAccesses pageAccess: pageAccesses) {
			if (name.equals(pageAccess.getApexPage())) {
				return true;
			}
		}
		return false;
	}

	private static PageAccesses getPAByApexPageName(String name, List<PageAccesses> pageAccesses) {
		for(PageAccesses pageAccess: pageAccesses) {
			if (name.equals(pageAccess.getApexPage())) {
				return pageAccess;
			}
		}
		return null;
	}

    public List<String> getPageAccessesNotInRepo() {
        return pageAccessesNotInRepo;
    }

    public List<String> getPageAccessesDiffList() {
        return pageAccessesDiffList;
    }

    public List<PageAccesses> getPageAccessesToAddInBitbucket() {
        return pageAccessesToAddInBitbucket;
    }
}