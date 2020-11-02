package com.metadata.Object.pojo;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "valueSetting")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class ValueSetting {

    @XmlElement(name = "controllingFieldValue")
    private String controllingFieldValue;
    @XmlElement(name = "valueName")
    private String valueName;

    public String getControllingFieldValue() {
        return controllingFieldValue;
    }

    public void setControllingFieldValue(String controllingFieldValue) {
        this.controllingFieldValue = controllingFieldValue;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    @Override
    public int hashCode() {
        final Integer prime = 31;
        Integer result = 1;
        result = prime * result + ((controllingFieldValue == null) ? 0 : controllingFieldValue.hashCode());
        result = prime * result + ((valueName == null) ? 0 : valueName.hashCode());
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
        ValueSetting other = (ValueSetting) obj;
        if (controllingFieldValue == null) {
            if (other.controllingFieldValue != null)
                return false;
        } else if (!controllingFieldValue.equals(other.controllingFieldValue))
            return false;
        if (valueName == null) {
            if (other.valueName != null)
                return false;
        } else if (!valueName.equals(other.valueName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ValueSetting [controllingFieldValue=" + controllingFieldValue + ", valueName=" + valueName + "]";
    }
}
