package com.metadata.Object.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lookupFilter")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class LookupFilter {

    @XmlElement(name = "active")
    private String active;
    @XmlElement(name = "filterItems")
    private List<FilterItem> filterItems;
    @XmlElement(name = "infoMessage")
    private String infoMessage;
    @XmlElement(name = "isOptional")
    private Boolean isOptional;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
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

    public Boolean getIsOptional() {
        return isOptional;
    }

    public void setIsOptional(Boolean isOptional) {
        this.isOptional = isOptional;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((active == null) ? 0 : active.hashCode());
        result = prime * result + ((filterItems == null) ? 0 : filterItems.hashCode());
        result = prime * result + ((infoMessage == null) ? 0 : infoMessage.hashCode());
        result = prime * result + ((isOptional == null) ? 0 : isOptional.hashCode());
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
        LookupFilter other = (LookupFilter) obj;
        if (active == null) {
            if (other.active != null)
                return false;
        } else if (!active.equals(other.active))
            return false;
        if (filterItems == null) {
            if (other.filterItems != null)
                return false;
        } else if (!filterItems.equals(other.filterItems))
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
        return true;
    }

    @Override
    public String toString() {
        return "LookupFilter [active=" + active + ", filterItems=" + filterItems + ", infoMessage=" + infoMessage
                + ", isOptional=" + isOptional + "]";
    }
}
