package com.metadata.Profile.Pojo;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
  
@XmlRootElement(name = "fieldPermissions")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class FieldPermissions implements Serializable {
     
    private static final long serialVersionUID = 1L;
     
    private String field;
    private Boolean editable;
	private Boolean readable;
	
    public FieldPermissions() {
        super();
    }
 
    public FieldPermissions(String field, Boolean editable, Boolean readable) {
        super();
        this.field = field;
        this.editable = editable;
		this.readable = readable;
    }
     
    //Setters and Getters

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean getReadable() {
        return readable;
    }

    public void setReadable(Boolean readable) {
        this.readable = readable;
    }

    public static Comparator<FieldPermissions> fieldPermissionComparator = new Comparator<FieldPermissions>() {

        public int compare(FieldPermissions s1, FieldPermissions s2) {
            String name1 = s1.getField();
            String name2 = s2.getField();
            return name1.compareTo(name2);
        }
    };

    @Override
    public int hashCode() {
        final Integer prime = 31;
        Integer result = 1;
        result = prime * result + ((editable == null) ? 0 : editable.hashCode());
        result = prime * result + ((field == null) ? 0 : field.hashCode());
        result = prime * result + ((readable == null) ? 0 : readable.hashCode());
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
        FieldPermissions other = (FieldPermissions) obj;
        if (editable == null) {
            if (other.editable != null)
                return false;
        } else if (!editable.equals(other.editable))
            return false;
        if (field == null) {
            if (other.field != null)
                return false;
        } else if (!field.equals(other.field))
            return false;
        if (readable == null) {
            if (other.readable != null)
                return false;
        } else if (!readable.equals(other.readable))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FieldPermissions [editable=" + editable + ", field=" + field + ", readable=" + readable + "]";
    }
}

