package com.metadata.Object.pojo;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "displayedField")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class DisplayedField {

    @XmlElement(name = "field")
    private String field;
    @XmlElement(name = "isFieldManaged")
    private Boolean isFieldManaged;
    @XmlElement(name = "isRequired")
    private Boolean isRequired;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Boolean getIsFieldManaged() {
        return isFieldManaged;
    }

    public void setIsFieldManaged(Boolean isFieldManaged) {
        this.isFieldManaged = isFieldManaged;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((field == null) ? 0 : field.hashCode());
        result = prime * result + ((isFieldManaged == null) ? 0 : isFieldManaged.hashCode());
        result = prime * result + ((isRequired == null) ? 0 : isRequired.hashCode());
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
        DisplayedField other = (DisplayedField) obj;
        if (field == null) {
            if (other.field != null)
                return false;
        } else if (!field.equals(other.field))
            return false;
        if (isFieldManaged == null) {
            if (other.isFieldManaged != null)
                return false;
        } else if (!isFieldManaged.equals(other.isFieldManaged))
            return false;
        if (isRequired == null) {
            if (other.isRequired != null)
                return false;
        } else if (!isRequired.equals(other.isRequired))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DisplayedField [field=" + field + ", isFieldManaged=" + isFieldManaged + ", isRequired=" + isRequired
                + "]";
    }

}
