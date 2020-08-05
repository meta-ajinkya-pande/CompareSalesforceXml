package com.metadata.Object.pojo;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sharedTo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class SharedTo {
    
    @XmlElement(name = "roleAndSubordinatesInternal")
    private String roleAndSubordinatesInternal;

    public String getRoleAndSubordinatesInternal() {
        return roleAndSubordinatesInternal;
    }

    public void setRoleAndSubordinatesInternal(String roleAndSubordinatesInternal) {
        this.roleAndSubordinatesInternal = roleAndSubordinatesInternal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((roleAndSubordinatesInternal == null) ? 0 : roleAndSubordinatesInternal.hashCode());
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
        SharedTo other = (SharedTo) obj;
        if (roleAndSubordinatesInternal == null) {
            if (other.roleAndSubordinatesInternal != null)
                return false;
        } else if (!roleAndSubordinatesInternal.equals(other.roleAndSubordinatesInternal))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SharedTo [roleAndSubordinatesInternal=" + roleAndSubordinatesInternal + "]";
    }
}
