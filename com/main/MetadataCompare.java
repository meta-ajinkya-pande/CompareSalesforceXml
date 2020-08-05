package com.main;

import com.main.util.FileHandling;
import com.main.util.ObjectToXML;
import com.metadata.Profile.Profiles;
import com.metadata.Profile.ProfileUtil.ProfileCompare;
import com.metadata.Profile.ProfileUtil.ProfileFileExport;

public class MetadataCompare {

	public static void main(String args[]) {
		ProfileCompare profileCompare = new ProfileCompare();
		profileCompare.compare();

		FileHandling dir = new FileHandling();
		dir.deleteFilesFromFolder("Result/ProfileCompareTextFiles");
		dir.deleteFilesFromFolder("Result/BitbucketProfilesTemp");
		dir.deleteFilesFromFolder("Result/ProfileCompareExcelFiles");
		
		try {
			ObjectToXML objectToXML = new ObjectToXML();
			for (Profiles tempProfile : profileCompare.getBitbucketTempProfiles()) {
				objectToXML.setFileOutputStream("Result/BitbucketProfilesTemp/" + tempProfile.getProfileName());
				objectToXML.convertObjecttoXml(tempProfile);
			}
			new ProfileFileExport().exportTxtFile(profileCompare.getProfileFieldPermissionMap());
			new ProfileFileExport().exportExcelFile(profileCompare.getProfileFieldPermissionMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("File Written Successfully");
	}
}