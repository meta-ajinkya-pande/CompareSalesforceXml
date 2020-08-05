package com.metadata.Profile.Pojo;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
  
@XmlRootElement(name = "recordTypeVisibilities")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class RecordTypeVisibilities implements Serializable {
     
    private static final long serialVersionUID = 1L;
    
	private String recordType;
    private Boolean visible;
    @XmlElement(name = "default")
	private Boolean defaultTagRTV;
	
    public RecordTypeVisibilities() {
        super();
    }
 
    public RecordTypeVisibilities(Boolean defaultTag, String recordType, Boolean visible) {
        super();
        this.recordType = recordType;
        this.defaultTagRTV = defaultTag;
		this.visible = visible;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getDefaultTagRTV() {
        return defaultTagRTV;
    }

    public void setDefaultTag(Boolean defaultTagRTV) {
        this.defaultTagRTV = defaultTagRTV;
    }

    public static Comparator<RecordTypeVisibilities> recordTypeVisiblitiesComparator = new Comparator<RecordTypeVisibilities>() {

        public int compare(RecordTypeVisibilities s1, RecordTypeVisibilities s2) {
            String name1 = s1.getRecordType();
            String name2 = s2.getRecordType();
            return name1.compareTo(name2);
        }
    };

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((defaultTagRTV == null) ? 0 : defaultTagRTV.hashCode());
        result = prime * result + ((recordType == null) ? 0 : recordType.hashCode());
        result = prime * result + ((visible == null) ? 0 : visible.hashCode());
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
        RecordTypeVisibilities other = (RecordTypeVisibilities) obj;
        if (defaultTagRTV == null) {
            if (other.defaultTagRTV != null)
                return false;
        } else if (!defaultTagRTV.equals(other.defaultTagRTV))
            return false;
        if (recordType == null) {
            if (other.recordType != null)
                return false;
        } else if (!recordType.equals(other.recordType))
            return false;
        if (visible == null) {
            if (other.visible != null)
                return false;
        } else if (!visible.equals(other.visible))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RecordTypeVisibilities [default=" + defaultTagRTV + ", recordType=" + recordType + ", visible="
                + visible + "]";
    }
    
}