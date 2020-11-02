package com.metadata.Object.pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "namedFilter")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class NamedFilter {
    @XmlElement(name = "active")
    private Boolean active;
    @XmlElement(name = "booleanFilter")
    private String booleanFilter;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "errorMessage")
    private String errorMessage;
    @XmlElement(name = "field")
    private String field;
    @XmlElement(name = "filterItems")
    private List<FilterItem> filterItems;
    @XmlElement(name = "infoMessage")
    private String infoMessage;
    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "isOptional")
    private Boolean isOptional;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "sourceObject")
    private String sourceObject;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getBooleanFilter() {
        return booleanFilter;
    }

    public void setBooleanFilter(String booleanFilter) {
        this.booleanFilter = booleanFilter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List<FilterItem> getFilterItems() {
        return filterItems;
    }

    public void setFilterItems(List<FilterItem> filterItems) {
        this.filterItems = filterItems;
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getIsOptional() {
        return isOptional;
    }

    public void setIsOptional(Boolean isOptional) {
        this.isOptional = isOptional;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceObject() {
        return sourceObject;
    }

    public void setSourceObject(String sourceObject) {
        this.sourceObject = sourceObject;
    }

    @Override
    public int hashCode() {
        final Integer prime = 31;
        Integer result = 1;
        result = prime * result + ((active == null) ? 0 : active.hashCode());
        result = prime * result + ((booleanFilter == null) ? 0 : booleanFilter.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
        result = prime * result + ((field == null) ? 0 : field.hashCode());
        result = prime * result + ((filterItems == null) ? 0 : filterItems.hashCode());
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((infoMessage == null) ? 0 : infoMessage.hashCode());
        result = prime * result + ((isOptional == null) ? 0 : isOptional.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((sourceObject == null) ? 0 : sourceObject.hashCode());
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
        NamedFilter other = (NamedFilter) obj;
        if (active == null) {
            if (other.active != null)
                return false;
        } else if (!active.equals(other.active))
            return false;
        if (booleanFilter == null) {
            if (other.booleanFilter != null)
                return false;
        } else if (!booleanFilter.equals(other.booleanFilter))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (errorMessage == null) {
            if (other.errorMessage != null)
                return false;
        } else if (!errorMessage.equals(other.errorMessage))
            return false;
        if (field == null) {
            if (other.field != null)
                return false;
        } else if (!field.equals(other.field))
            return false;
        if (filterItems == null) {
            if (other.filterItems != null)
                return false;
        } else if (!filterItems.equals(other.filterItems))
            return false;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        if (infoMessage == null) {
            if (other.infoMessage != null)
                return false;
        } else if (!infoMessage.equals(other.infoMessage))
            return false;
        if (isOptional == null) {
            if (other.isOptional != null)
                return false;
        } else if (!isOptional.equals(other.isOptional))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (sourceObject == null) {
            if (other.sourceObject != null)
                return false;
        } else if (!sourceObject.equals(other.sourceObject))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "NamedFilter [active=" + active + ", booleanFilter=" + booleanFilter + ", description=" + description
                + ", errorMessage=" + errorMessage + ", field=" + field + ", filterItems=" + filterItems + ", fullName="
                + fullName + ", infoMessage=" + infoMessage + ", isOptional=" + isOptional + ", name=" + name
                + ", sourceObject=" + sourceObject + "]";
    }
}
