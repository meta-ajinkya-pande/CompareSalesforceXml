package com.main;

import java.util.Map;

import com.main.util.FileHandling;
import com.main.util.XmlToObject;
import com.metadata.Profile.Profiles;
import com.metadata.Profile.ProfileUtil.ProfileCompare;
import com.metadata.Profile.ProfileUtil.ProfileFileExport;

public class MetadataCompare {

	public static void main(String args[]) {
		try {
			ProfileCompare profileCompare = new ProfileCompare();
			XmlToObject<Profiles> profileXmlToObject = new XmlToObject<Profiles>(Profiles.class);
			Map<String, Profiles> bitbucketNameProfileMap = profileXmlToObject
					.convertXMLsToObjects("compareFolder/bitbucket/profiles");
			Map<String, Profiles> orgNameProfileMap = profileXmlToObject
					.convertXMLsToObjects("compareFolder/org/profiles");
			profileCompare.compare(orgNameProfileMap, bitbucketNameProfileMap);
			emptyResultFolder();
			exportFiles(profileCompare);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("File Written Successfully");
	}

	public static void emptyResultFolder() {
		FileHandling dir = new FileHandling();
		dir.deleteFilesFromFolder("Result/ProfileCompareTextFiles");
		dir.deleteFilesFromFolder("Result/BitbucketProfilesTemp");
		dir.deleteFilesFromFolder("Result/ProfileCompareExcelFiles");
	}

	public static void exportFiles(ProfileCompare profileCompare) throws Exception {
		ProfileFileExport profileFileExport = new ProfileFileExport();
		profileFileExport.exportXmlFile(profileCompare.getBitbucketTempProfiles());
		profileFileExport.exportTxtFile(profileCompare.getProfileFieldPermissionMap());
		profileFileExport.exportExcelFile(profileCompare.getProfileFieldPermissionMap());
	}
}