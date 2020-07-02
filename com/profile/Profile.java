package com.profile;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;
 
@XmlRootElement(name = "Profile")
@XmlAccessorType(XmlAccessType.FIELD)
public class Profile implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private String profileName;
	@XmlElement(name = "applicationVisibilities")
	private List<ApplicationVisibilities> applicationVisibilities;
	@XmlElement(name = "classAccesses")
	private List<ClassAccesses> classAccesses;
	@XmlElement(name = "custom")
	private Boolean custom;
	@XmlElement(name = "customPermissions")
	private List<CustomPermissions> customPermissions;
	@XmlElement(name = "fieldPermissions")
	private List<FieldPermissions> fieldPermissions;
	@XmlElement(name = "layoutAssignments")
	private List<LayoutAssignments> layoutAssignments;
	@XmlElement(name = "objectPermissions")
	private List<ObjectPermissions> objectPermissions;
	@XmlElement(name = "pageAccesses")
	private List<PageAccesses> pageAccesses;
	@XmlElement(name = "recordTypeVisibilities")
	private List<RecordTypeVisibilities> recordTypeVisibilities;
	@XmlElement(name = "tabVisibilities")
	private List<TabVisibilities> tabVisibilities;
	@XmlElement(name = "userLicense")
	private String userLicense;
	@XmlElement(name = "userPermissions")
	private List<UserPermissions> userPermissions;
     
    public Profile() {
        super();
    }
 
    public Profile(List<ApplicationVisibilities> applicationVisibilities, List<ClassAccesses> classAccesses, Boolean custom, List<CustomPermissions> customPermissions,
	List<FieldPermissions> fieldPermissions, List<LayoutAssignments> layoutAssignments, List<ObjectPermissions> objectPermissions, List<PageAccesses> pageAccesses,
	List<RecordTypeVisibilities> recordTypeVisibilities, List<TabVisibilities> tabVisibilities, String userLicense, List<UserPermissions> userPermissions) {
        super();
		this.applicationVisibilities = applicationVisibilities;
		this.classAccesses = classAccesses;
		this.custom = custom;
		this.customPermissions = customPermissions;
		this.fieldPermissions = fieldPermissions;
		this.layoutAssignments = layoutAssignments;
		this.objectPermissions = objectPermissions;
		this.pageAccesses = pageAccesses;
		this.recordTypeVisibilities = recordTypeVisibilities;
		this.tabVisibilities = tabVisibilities;
		this.userLicense = userLicense;
		this.userPermissions = userPermissions;
    }

	public List<ApplicationVisibilities> getApplicationVisibilities() {
		return applicationVisibilities;
	}

	public void setApplicationVisibilities(List<ApplicationVisibilities> applicationVisibilities) {
		this.applicationVisibilities = applicationVisibilities;
	}

	public List<ClassAccesses> getClassAccesses() {
		return classAccesses;
	}

	public void setClassAccesses(List<ClassAccesses> classAccesses) {
		this.classAccesses = classAccesses;
	}

	public Boolean getCustom() {
		return custom;
	}

	public void setCustom(Boolean custom) {
		this.custom = custom;
	}

	public List<CustomPermissions> getCustomPermissions() {
		return customPermissions;
	}

	public void setCustomPermissions(List<CustomPermissions> customPermissions) {
		this.customPermissions = customPermissions;
	}

	public List<FieldPermissions> getFieldPermissions() {
		return fieldPermissions;
	}

	public void setFieldPermissions(List<FieldPermissions> fieldPermissions) {
		this.fieldPermissions = fieldPermissions;
	}

	public List<LayoutAssignments> getLayoutAssignments() {
		return layoutAssignments;
	}

	public void setLayoutAssignments(List<LayoutAssignments> layoutAssignments) {
		this.layoutAssignments = layoutAssignments;
	}

	public List<ObjectPermissions> getObjectPermissions() {
		return objectPermissions;
	}

	public void setObjectPermissions(List<ObjectPermissions> objectPermissions) {
		this.objectPermissions = objectPermissions;
	}

	public List<PageAccesses> getPageAccesses() {
		return pageAccesses;
	}

	public void setPageAccesses(List<PageAccesses> pageAccesses) {
		this.pageAccesses = pageAccesses;
	}

	public List<RecordTypeVisibilities> getRecordTypeVisibilities() {
		return recordTypeVisibilities;
	}

	public void setRecordTypeVisibilities(List<RecordTypeVisibilities> recordTypeVisibilities) {
		this.recordTypeVisibilities = recordTypeVisibilities;
	}

	public List<TabVisibilities> getTabVisibilities() {
		return tabVisibilities;
	}

	public void setTabVisibilities(List<TabVisibilities> tabVisibilities) {
		this.tabVisibilities = tabVisibilities;
	}

	public String getUserLicense() {
		return userLicense;
	}

	public void setUserLicense(String userLicense) {
		this.userLicense = userLicense;
	}

	public List<UserPermissions> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(List<UserPermissions> userPermissions) {
		this.userPermissions = userPermissions;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationVisibilities == null) ? 0 : applicationVisibilities.hashCode());
		result = prime * result + ((classAccesses == null) ? 0 : classAccesses.hashCode());
		result = prime * result + ((custom == null) ? 0 : custom.hashCode());
		result = prime * result + ((customPermissions == null) ? 0 : customPermissions.hashCode());
		result = prime * result + ((fieldPermissions == null) ? 0 : fieldPermissions.hashCode());
		result = prime * result + ((layoutAssignments == null) ? 0 : layoutAssignments.hashCode());
		result = prime * result + ((objectPermissions == null) ? 0 : objectPermissions.hashCode());
		result = prime * result + ((pageAccesses == null) ? 0 : pageAccesses.hashCode());
		result = prime * result + ((profileName == null) ? 0 : profileName.hashCode());
		result = prime * result + ((recordTypeVisibilities == null) ? 0 : recordTypeVisibilities.hashCode());
		result = prime * result + ((tabVisibilities == null) ? 0 : tabVisibilities.hashCode());
		result = prime * result + ((userLicense == null) ? 0 : userLicense.hashCode());
		result = prime * result + ((userPermissions == null) ? 0 : userPermissions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (applicationVisibilities == null) {
			if (other.applicationVisibilities != null)
				return false;
		} else if (!applicationVisibilities.equals(other.applicationVisibilities))
			return false;
		if (classAccesses == null) {
			if (other.classAccesses != null)
				return false;
		} else if (!classAccesses.equals(other.classAccesses))
			return false;
		if (custom == null) {
			if (other.custom != null)
				return false;
		} else if (!custom.equals(other.custom))
			return false;
		if (customPermissions == null) {
			if (other.customPermissions != null)
				return false;
		} else if (!customPermissions.equals(other.customPermissions))
			return false;
		if (fieldPermissions == null) {
			if (other.fieldPermissions != null)
				return false;
		} else if (!fieldPermissions.equals(other.fieldPermissions))
			return false;
		if (layoutAssignments == null) {
			if (other.layoutAssignments != null)
				return false;
		} else if (!layoutAssignments.equals(other.layoutAssignments))
			return false;
		if (objectPermissions == null) {
			if (other.objectPermissions != null)
				return false;
		} else if (!objectPermissions.equals(other.objectPermissions))
			return false;
		if (pageAccesses == null) {
			if (other.pageAccesses != null)
				return false;
		} else if (!pageAccesses.equals(other.pageAccesses))
			return false;
		if (profileName == null) {
			if (other.profileName != null)
				return false;
		} else if (!profileName.equals(other.profileName))
			return false;
		if (recordTypeVisibilities == null) {
			if (other.recordTypeVisibilities != null)
				return false;
		} else if (!recordTypeVisibilities.equals(other.recordTypeVisibilities))
			return false;
		if (tabVisibilities == null) {
			if (other.tabVisibilities != null)
				return false;
		} else if (!tabVisibilities.equals(other.tabVisibilities))
			return false;
		if (userLicense == null) {
			if (other.userLicense != null)
				return false;
		} else if (!userLicense.equals(other.userLicense))
			return false;
		if (userPermissions == null) {
			if (other.userPermissions != null)
				return false;
		} else if (!userPermissions.equals(other.userPermissions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profile [applicationVisibilities=" + applicationVisibilities + ", classAccesses=" + classAccesses
				+ ", custom=" + custom + ", customPermissions=" + customPermissions + ", fieldPermissions="
				+ fieldPermissions + ", layoutAssignments=" + layoutAssignments + ", objectPermissions="
				+ objectPermissions + ", pageAccesses=" + pageAccesses + ", profileName=" + profileName
				+ ", recordTypeVisibilities=" + recordTypeVisibilities + ", tabVisibilities=" + tabVisibilities
				+ ", userLicense=" + userLicense + ", userPermissions=" + userPermissions + "]";
	}
}