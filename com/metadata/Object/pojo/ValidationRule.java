package com.metadata.Object.pojo;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "validationRule")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class ValidationRule {

    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "active")
    private Boolean active;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "errorConditionFormula")
    private String errorConditionFormula;
    @XmlElement(name = "errorDisplayField")
    private String errorDisplayField;
    @XmlElement(name = "errorMessage")
    private String errorMessage;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorConditionFormula() {
        return errorConditionFormula;
    }

    public void setErrorConditionFormula(String errorConditionFormula) {
        this.errorConditionFormula = errorConditionFormula;
    }

    public String getErrorDisplayField() {
        return errorDisplayField;
    }

    public void setErrorDisplayField(String errorDisplayField) {
        this.errorDisplayField = errorDisplayField;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public int hashCode() {
        final Integer prime = 31;
        Integer result = 1;
        result = prime * result + ((active == null) ? 0 : active.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((errorConditionFormula == null) ? 0 : errorConditionFormula.hashCode());
        result = prime * result + ((errorDisplayField == null) ? 0 : errorDisplayField.hashCode());
        result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
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
        ValidationRule other = (ValidationRule) obj;
        if (active == null) {
            if (other.active != null)
                return false;
        } else if (!active.equals(other.active))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (errorConditionFormula == null) {
            if (other.errorConditionFormula != null)
                return false;
        } else if (!errorConditionFormula.equals(other.errorConditionFormula))
            return false;
        if (errorDisplayField == null) {
            if (other.errorDisplayField != null)
                return false;
        } else if (!errorDisplayField.equals(other.errorDisplayField))
            return false;
        if (errorMessage == null) {
            if (other.errorMessage != null)
                return false;
        } else if (!errorMessage.equals(other.errorMessage))
            return false;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ValidationRule [active=" + active + ", description=" + description + ", errorConditionFormula="
                + errorConditionFormula + ", errorDisplayField=" + errorDisplayField + ", errorMessage=" + errorMessage
                + ", fullName=" + fullName + "]";
    }
}
