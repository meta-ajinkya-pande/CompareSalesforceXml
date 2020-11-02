package com.metadata.Object.pojo;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "actionOverrides")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class ActionOverride {
    
    @XmlElement(name = "actionName")
    private String actionName;
    @XmlElement(name = "type")
    private String type;
    @XmlElement(name = "formFactor")
    private String formFactor;

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    @Override
    public String toString() {
        return "ActionOverride [actionName=" + actionName + ", formFactor=" + formFactor + ", type=" + type + "]";
    }

    @Override
    public int hashCode() {
        final Integer prime = 31;
        Integer result = 1;
        result = prime * result + ((actionName == null) ? 0 : actionName.hashCode());
        result = prime * result + ((formFactor == null) ? 0 : formFactor.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        ActionOverride other = (ActionOverride) obj;
        if (actionName == null) {
            if (other.actionName != null)
                return false;
        } else if (!actionName.equals(other.actionName))
            return false;
        if (formFactor == null) {
            if (other.formFactor != null)
                return false;
        } else if (!formFactor.equals(other.formFactor))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
}