package com.metadata.Object.pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "picklistValue")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class RecordType {

    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "active")
    private Boolean active;
    @XmlElement(name = "compactLayoutAssignment")
    private String compactLayoutAssignment;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "label")
    private String label;
    @XmlElement(name = "picklistValues")
    private List<PicklistValue> picklistValues;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCompactLayoutAssignment() {
        return compactLayoutAssignment;
    }

    public void setCompactLayoutAssignment(String compactLayoutAssignment) {
        this.compactLayoutAssignment = compactLayoutAssignment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<PicklistValue> getPicklistValues() {
        return picklistValues;
    }

    public void setPicklistValues(List<PicklistValue> picklistValues) {
        this.picklistValues = picklistValues;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((active == null) ? 0 : active.hashCode());
        result = prime * result + ((compactLayoutAssignment == null) ? 0 : compactLayoutAssignment.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + ((picklistValues == null) ? 0 : picklistValues.hashCode());
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
        RecordType other = (RecordType) obj;
        if (active == null) {
            if (other.active != null)
                return false;
        } else if (!active.equals(other.active))
            return false;
        if (compactLayoutAssignment == null) {
            if (other.compactLayoutAssignment != null)
                return false;
        } else if (!compactLayoutAssignment.equals(other.compactLayoutAssignment))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
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
        if (picklistValues == null) {
            if (other.picklistValues != null)
                return false;
        } else if (!picklistValues.equals(other.picklistValues))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RecordType [active=" + active + ", compactLayoutAssignment=" + compactLayoutAssignment
                + ", description=" + description + ", fullName=" + fullName + ", label=" + label + ", picklistValues="
                + picklistValues + "]";
    }
}
