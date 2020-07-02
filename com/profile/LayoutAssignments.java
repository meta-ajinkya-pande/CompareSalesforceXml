package com.profile;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
  
@XmlRootElement(name = "layoutAssignments")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class LayoutAssignments implements Serializable {
     
    private static final long serialVersionUID = 1L;
     
    private String layout;
    private String recordType;
	
    public LayoutAssignments() {
        super();
    }
 
    public LayoutAssignments(String layout, String recordType) {
        super();
        this.layout = layout;
        this.recordType = recordType;
    }
     
    //Setters and Getters
 
    @Override
    public String toString() {
        return "LayoutAssignments [layout=" + layout + ", recordType=" + recordType + "]";
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public static Comparator<LayoutAssignments> layoutAssignmentComparator = new Comparator<LayoutAssignments>() {

        public int compare(LayoutAssignments s1, LayoutAssignments s2) {
            String name1 = s1.getLayout() + (s1.getRecordType() == null? "" : s1.getRecordType());
            String name2 = s2.getLayout() + (s2.getRecordType() == null? "" : s2.getRecordType());
            return name1.compareTo(name2);
        }
    };

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((layout == null) ? 0 : layout.hashCode());
        result = prime * result + ((recordType == null) ? 0 : recordType.hashCode());
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
        LayoutAssignments other = (LayoutAssignments) obj;
        if (layout == null) {
            if (other.layout != null)
                return false;
        } else if (!layout.equals(other.layout))
            return false;
        if (recordType == null) {
            if (other.recordType != null)
                return false;
        } else if (!recordType.equals(other.recordType))
            return false;
        return true;
    }
}
