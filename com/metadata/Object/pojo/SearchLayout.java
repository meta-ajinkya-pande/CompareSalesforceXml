package com.metadata.Object.pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "searchLayout")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class SearchLayout {
    
    @XmlElement(name = "customTabListAdditionalFields")
    private List<String> customTabListAdditionalFields;
    @XmlElement(name = "lookupDialogsAdditionalFields")
    private List<String> lookupDialogsAdditionalFields;
    @XmlElement(name = "lookupFilterFields")
    private List<String> lookupFilterFields;
    @XmlElement(name = "lookupPhoneDialogsAdditionalFields")
    private List<String> lookupPhoneDialogsAdditionalFields;
    @XmlElement(name = "searchFilterFields")
    private List<String> searchFilterFields;
    @XmlElement(name = "searchResultsAdditionalFields")
    private List<String> searchResultsAdditionalFields;

    public List<String> getCustomTabListAdditionalFields() {
        return customTabListAdditionalFields;
    }

    public void setCustomTabListAdditionalFields(List<String> customTabListAdditionalFields) {
        this.customTabListAdditionalFields = customTabListAdditionalFields;
    }

    public List<String> getLookupDialogsAdditionalFields() {
        return lookupDialogsAdditionalFields;
    }

    public void setLookupDialogsAdditionalFields(List<String> lookupDialogsAdditionalFields) {
        this.lookupDialogsAdditionalFields = lookupDialogsAdditionalFields;
    }

    public List<String> getLookupFilterFields() {
        return lookupFilterFields;
    }

    public void setLookupFilterFields(List<String> lookupFilterFields) {
        this.lookupFilterFields = lookupFilterFields;
    }

    public List<String> getLookupPhoneDialogsAdditionalFields() {
        return lookupPhoneDialogsAdditionalFields;
    }

    public void setLookupPhoneDialogsAdditionalFields(List<String> lookupPhoneDialogsAdditionalFields) {
        this.lookupPhoneDialogsAdditionalFields = lookupPhoneDialogsAdditionalFields;
    }

    public List<String> getSearchFilterFields() {
        return searchFilterFields;
    }

    public void setSearchFilterFields(List<String> searchFilterFields) {
        this.searchFilterFields = searchFilterFields;
    }

    public List<String> getSearchResultsAdditionalFields() {
        return searchResultsAdditionalFields;
    }

    public void setSearchResultsAdditionalFields(List<String> searchResultsAdditionalFields) {
        this.searchResultsAdditionalFields = searchResultsAdditionalFields;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((customTabListAdditionalFields == null) ? 0 : customTabListAdditionalFields.hashCode());
        result = prime * result
                + ((lookupDialogsAdditionalFields == null) ? 0 : lookupDialogsAdditionalFields.hashCode());
        result = prime * result + ((lookupFilterFields == null) ? 0 : lookupFilterFields.hashCode());
        result = prime * result
                + ((lookupPhoneDialogsAdditionalFields == null) ? 0 : lookupPhoneDialogsAdditionalFields.hashCode());
        result = prime * result + ((searchFilterFields == null) ? 0 : searchFilterFields.hashCode());
        result = prime * result
                + ((searchResultsAdditionalFields == null) ? 0 : searchResultsAdditionalFields.hashCode());
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
        SearchLayout other = (SearchLayout) obj;
        if (customTabListAdditionalFields == null) {
            if (other.customTabListAdditionalFields != null)
                return false;
        } else if (!customTabListAdditionalFields.equals(other.customTabListAdditionalFields))
            return false;
        if (lookupDialogsAdditionalFields == null) {
            if (other.lookupDialogsAdditionalFields != null)
                return false;
        } else if (!lookupDialogsAdditionalFields.equals(other.lookupDialogsAdditionalFields))
            return false;
        if (lookupFilterFields == null) {
            if (other.lookupFilterFields != null)
                return false;
        } else if (!lookupFilterFields.equals(other.lookupFilterFields))
            return false;
        if (lookupPhoneDialogsAdditionalFields == null) {
            if (other.lookupPhoneDialogsAdditionalFields != null)
                return false;
        } else if (!lookupPhoneDialogsAdditionalFields.equals(other.lookupPhoneDialogsAdditionalFields))
            return false;
        if (searchFilterFields == null) {
            if (other.searchFilterFields != null)
                return false;
        } else if (!searchFilterFields.equals(other.searchFilterFields))
            return false;
        if (searchResultsAdditionalFields == null) {
            if (other.searchResultsAdditionalFields != null)
                return false;
        } else if (!searchResultsAdditionalFields.equals(other.searchResultsAdditionalFields))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SearchLayout [customTabListAdditionalFields=" + customTabListAdditionalFields
                + ", lookupDialogsAdditionalFields=" + lookupDialogsAdditionalFields + ", lookupFilterFields="
                + lookupFilterFields + ", lookupPhoneDialogsAdditionalFields=" + lookupPhoneDialogsAdditionalFields
                + ", searchFilterFields=" + searchFilterFields + ", searchResultsAdditionalFields="
                + searchResultsAdditionalFields + "]";
    }
}
