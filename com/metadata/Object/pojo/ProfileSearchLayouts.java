package com.metadata.Object.pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "profileSearchLayouts")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class ProfileSearchLayouts {
    @XmlElement(name = "profileName")
    private List<String> profileName;
    @XmlElement(name = "fields")
    private List<String> fields;

    public List<String> getProfileName() {
        return profileName;
    }

    public void setProfileName(List<String> profileName) {
        this.profileName = profileName;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    @Override
    public int hashCode() {
        final Integer prime = 31;
        Integer result = 1;
        result = prime * result + ((fields == null) ? 0 : fields.hashCode());
        result = prime * result + ((profileName == null) ? 0 : profileName.hashCode());
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
        ProfileSearchLayouts other = (ProfileSearchLayouts) obj;
        if (fields == null) {
            if (other.fields != null)
                return false;
        } else if (!fields.equals(other.fields))
            return false;
        if (profileName == null) {
            if (other.profileName != null)
                return false;
        } else if (!profileName.equals(other.profileName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProfileSearchLayouts [fields=" + fields + ", profileName=" + profileName + "]";
    }
}
