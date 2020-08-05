package com.metadata.Object.pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fieldSet")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class FieldSet {

    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "displayedFields")
    private List<DisplayedField> displayedFields;
    @XmlElement(name = "availableFields")
    private List<AvailableField> availableFields;
    @XmlElement(name = "label")
    private String label;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DisplayedField> getDisplayedFields() {
        return displayedFields;
    }

    public void setDisplayedFields(List<DisplayedField> displayedFields) {
        this.displayedFields = displayedFields;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((availableFields == null) ? 0 : availableFields.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((displayedFields == null) ? 0 : displayedFields.hashCode());
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((label == null) ? 0 : label.hashCode());
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
        FieldSet other = (FieldSet) obj;
        if (availableFields == null) {
            if (other.availableFields != null)
                return false;
        } else if (!availableFields.equals(other.availableFields))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (displayedFields == null) {
            if (other.displayedFields != null)
                return false;
        } else if (!displayedFields.equals(other.displayedFields))
            return false;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FieldSet [availableFields=" + availableFields + ", description=" + description + ", displayedFields="
                + displayedFields + ", fullName=" + fullName + ", label=" + label + "]";
    }

    public List<AvailableField> getAvailableFields() {
        return availableFields;
    }

    public void setAvailableFields(List<AvailableField> availableFields) {
        this.availableFields = availableFields;
    }
}