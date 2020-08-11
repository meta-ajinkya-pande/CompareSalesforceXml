package com.main;

import java.util.Map;

import com.main.util.FileHandling;
import com.main.util.XmlToObject;
import com.metadata.Object.CustomObject;
import com.metadata.Object.objectUtil.ObjectFileExport;
import com.metadata.Profile.Profiles;
import com.metadata.Profile.ProfileUtil.ProfileCompare;
import com.metadata.Profile.ProfileUtil.ProfileFileExport;

public class MetadataCompare {

	private final static Boolean IS_PROFILE_COMPARE = false;
	private final static Boolean IS_OBJECT_EXTERNAL_ACCESS = true;

	public static void main(String args[]) {
		if (IS_PROFILE_COMPARE) {
			initProfileCompare();
		}
		if (IS_OBJECT_EXTERNAL_ACCESS) {
			initObjectCompare();
		}
	}

	public static void initObjectCompare() {
		XmlToObject<CustomObject> objectXmlToObject = new XmlToObject<CustomObject>(CustomObject.class);
		try {
			Map<String, CustomObject> bitbucketObjectMap = objectXmlToObject.convertXMLsToObjects("compareFolder/bitbucket/objects");
			for(String key : bitbucketObjectMap.keySet()) {
				bitbucketObjectMap.get(key).setObjectName(key);
			}
			exportObjectExcelFiles(bitbucketObjectMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initProfileCompare() {
		try {
			ProfileCompare profileCompare = new ProfileCompare();
			XmlToObject<Profiles> profileXmlToObject = new XmlToObject<Profiles>(Profiles.class);
			Map<String, Profiles> bitbucketNameProfileMap = profileXmlToObject.convertXMLsToObjects("compareFolder/bitbucket/profiles");
			Map<String, Profiles> orgNameProfileMap = profileXmlToObject.convertXMLsToObjects("compareFolder/org/profiles");
			profileCompare.compare(orgNameProfileMap, bitbucketNameProfileMap);
			emptyResultFolder();
			exportProfilesFiles(profileCompare);
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

	public static void exportProfilesFiles(ProfileCompare profileCompare) throws Exception {
		ProfileFileExport profileFileExport = new ProfileFileExport();
		profileFileExport.exportXmlFile(profileCompare.getBitbucketTempProfiles());
		profileFileExport.exportTxtFile(profileCompare.getProfileFieldPermissionMap());
		profileFileExport.exportExcelFile(profileCompare.getProfileFieldPermissionMap());
	}

	public static void exportObjectExcelFiles(Map<String, CustomObject> bitbucketObjectMap) throws Exception {
		ObjectFileExport objectFileExport = new ObjectFileExport();
		objectFileExport.exportExternalSharingExcelFile(bitbucketObjectMap);
	}
}