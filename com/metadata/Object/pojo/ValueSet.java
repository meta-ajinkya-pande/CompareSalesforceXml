package com.metadata.Object.pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "valueSet")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class ValueSet {

    @XmlElement(name = "controllingField")
    private String controllingField;
    @XmlElement(name = "restricted")
    private Boolean restricted;
    @XmlElement(name = "valueSetName")
    private String valueSetName;
    @XmlElement(name = "valueSettings")
    private List<ValueSetting> valueSettings;
    @XmlElement(name = "valueSetDefinition")
    private ValueSetDefinition valueSetDefinition;

    public ValueSetDefinition getValueSetDefinition() {
        return valueSetDefinition;
    }

    public void setValueSetDefinition(ValueSetDefinition valueSetDefinition) {
        this.valueSetDefinition = valueSetDefinition;
    }

    public String getControllingField() {
        return controllingField;
    }

    public void setControllingField(String controllingField) {
        this.controllingField = controllingField;
    }

    public Boolean getRestricted() {
        return restricted;
    }

    public void setRestricted(Boolean restricted) {
        this.restricted = restricted;
    }

    public String getValueSetName() {
        return valueSetName;
    }

    public void setValueSetName(String valueSetName) {
        this.valueSetName = valueSetName;
    }

    public List<ValueSetting> getValueSettings() {
        return valueSettings;
    }

    public void setValueSettings(List<ValueSetting> valueSettings) {
        this.valueSettings = valueSettings;
    }

    @Override
    public int hashCode() {
        final Integer prime = 31;
        Integer result = 1;
        result = prime * result + ((controllingField == null) ? 0 : controllingField.hashCode());
        result = prime * result + ((restricted == null) ? 0 : restricted.hashCode());
        result = prime * result + ((valueSetDefinition == null) ? 0 : valueSetDefinition.hashCode());
        result = prime * result + ((valueSetName == null) ? 0 : valueSetName.hashCode());
        result = prime * result + ((valueSettings == null) ? 0 : valueSettings.hashCode());
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
        ValueSet other = (ValueSet) obj;
        if (controllingField == null) {
            if (other.controllingField != null)
                return false;
        } else if (!controllingField.equals(other.controllingField))
            return false;
        if (restricted == null) {
            if (other.restricted != null)
                return false;
        } else if (!restricted.equals(other.restricted))
            return false;
        if (valueSetDefinition == null) {
            if (other.valueSetDefinition != null)
                return false;
        } else if (!valueSetDefinition.equals(other.valueSetDefinition))
            return false;
        if (valueSetName == null) {
            if (other.valueSetName != null)
                return false;
        } else if (!valueSetName.equals(other.valueSetName))
            return false;
        if (valueSettings == null) {
            if (other.valueSettings != null)
                return false;
        } else if (!valueSettings.equals(other.valueSettings))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ValueSet [controllingField=" + controllingField + ", restricted=" + restricted + ", valueSetDefinition="
                + valueSetDefinition + ", valueSetName=" + valueSetName + ", valueSettings=" + valueSettings + "]";
    }
}
