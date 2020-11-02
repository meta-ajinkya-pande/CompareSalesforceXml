package com.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.main.util.FileHandling;
import com.main.util.ReadExcelFile;
import com.main.util.XmlToObject;
import com.metadata.Object.CustomObject;
import com.metadata.Object.objectUtil.ObjectFileExport;
import com.metadata.Profile.Profiles;
import com.metadata.Profile.ProfileUtil.ProfileCompare;
import com.metadata.Profile.ProfileUtil.ProfileFileExport;

public class MetadataCompare {

	private final static Boolean IS_PROFILE_COMPARE = false;
	private final static Boolean IS_OBJECT_EXTERNAL_ACCESS = false;
	private final static Boolean IS_OBJECT_EXTERNAL_CHANGE = true;

	public static void main(String args[]) {
		if (IS_PROFILE_COMPARE) {
			initProfileCompare();
		}
		if (IS_OBJECT_EXTERNAL_ACCESS || IS_OBJECT_EXTERNAL_CHANGE) {
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
			Map<String, CustomObject> orgObjectMap = objectXmlToObject.convertXMLsToObjects("compareFolder/org/objects");
			for(String key : orgObjectMap.keySet()) {
				orgObjectMap.get(key).setObjectName(key);
			}
			Map<String, CustomObject> customObjectNotInRepoMap = new TreeMap<String, CustomObject>();
			if(IS_OBJECT_EXTERNAL_CHANGE) {
				Map<String, List<Object>> sheetDataMap;
				ReadExcelFile readExcelFile = new ReadExcelFile();
				sheetDataMap = readExcelFile.readObjectExcelFile("compareFolder/temp/CustomObject.xlsx");
				for(String objectName : sheetDataMap.keySet()) {
					if(bitbucketObjectMap.containsKey(objectName+".object")) {
						bitbucketObjectMap.get(objectName+".object").setExternalSharingModel((String)sheetDataMap.get(objectName).get(0));
					} else if(orgObjectMap.containsKey(objectName+".object")) {
						CustomObject temp = orgObjectMap.get(objectName+".object");
						temp.setExternalSharingModel((String)sheetDataMap.get(objectName).get(0));
						customObjectNotInRepoMap.put(objectName+".object", temp);
					}
				}
			}
			exportObjectExcelFiles(bitbucketObjectMap, customObjectNotInRepoMap);
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

	public static void exportObjectExcelFiles(Map<String, CustomObject> bitbucketObjectMap, Map<String, CustomObject> orgObjectNotInRepoMap) throws Exception {
		ObjectFileExport objectFileExport = new ObjectFileExport();
		if(IS_OBJECT_EXTERNAL_ACCESS) {
			objectFileExport.exportExternalSharingExcelFile(bitbucketObjectMap);
		} else if(IS_OBJECT_EXTERNAL_CHANGE) {
			Collection<CustomObject> objectMapCollectionBitbucket = new ArrayList<CustomObject>();
			Collection<CustomObject> objectMapCollectionOrg = new ArrayList<CustomObject>();
			for(String objectName : bitbucketObjectMap.keySet()) {
				objectMapCollectionBitbucket.add(bitbucketObjectMap.get(objectName));
			}
			for(String objectName : orgObjectNotInRepoMap.keySet()) {
				objectMapCollectionOrg.add(orgObjectNotInRepoMap.get(objectName));
			}
			objectFileExport.exportXmlFile(objectMapCollectionBitbucket,"BitbucketObjectTemp");
			objectFileExport.exportXmlFile(objectMapCollectionOrg,"OrgObjectNotInRepoTemp");
		}
	}
}