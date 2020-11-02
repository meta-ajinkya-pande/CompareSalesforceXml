package com.metadata.Object.pojo;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "historyRetentionPolicy")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class HistoryRetentionPolicy {
    @XmlElement(name = "archiveAfterMonths")
    private Integer archiveAfterMonths;
    @XmlElement(name = "archiveRetentionYears")
    private Integer archiveRetentionYears;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "gracePeriodDays")
    private Integer gracePeriodDays;

    public Integer getArchiveAfterMonths() {
        return archiveAfterMonths;
    }

    public void setArchiveAfterMonths(Integer archiveAfterMonths) {
        this.archiveAfterMonths = archiveAfterMonths;
    }

    public Integer getArchiveRetentionYears() {
        return archiveRetentionYears;
    }

    public void setArchiveRetentionYears(Integer archiveRetentionYears) {
        this.archiveRetentionYears = archiveRetentionYears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getGracePeriodDays() {
        return gracePeriodDays;
    }

    public void setGracePeriodDays(Integer gracePeriodDays) {
        this.gracePeriodDays = gracePeriodDays;
    }

    @Override
    public int hashCode() {
        final Integer prime = 31;
        Integer result = 1;
        result = prime * result + archiveAfterMonths;
        result = prime * result + archiveRetentionYears;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + gracePeriodDays;
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
        HistoryRetentionPolicy other = (HistoryRetentionPolicy) obj;
        if (archiveAfterMonths != other.archiveAfterMonths)
            return false;
        if (archiveRetentionYears != other.archiveRetentionYears)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (gracePeriodDays != other.gracePeriodDays)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "HistoryRetentionPolicy [archiveAfterMonths=" + archiveAfterMonths + ", archiveRetentionYears="
                + archiveRetentionYears + ", description=" + description + ", gracePeriodDays=" + gracePeriodDays + "]";
    }
}
