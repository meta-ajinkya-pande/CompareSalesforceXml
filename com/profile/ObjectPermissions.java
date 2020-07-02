package com.profile;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
  
@XmlRootElement(name = "objectPermissions")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ObjectPermissions implements Serializable {
     
    private static final long serialVersionUID = 1L;
     
    private Boolean allowCreate;
    private Boolean allowDelete;
	private Boolean allowEdit;
	private Boolean allowRead;
	private Boolean modifyAllRecords;
	private String object;
	private Boolean viewAllRecords;
	
    public ObjectPermissions() {
        super();
    }
 
    public ObjectPermissions(Boolean allowCreate, Boolean allowDelete, Boolean allowEdit, Boolean allowRead, Boolean modifyAllRecords, String object, Boolean viewAllRecords) {
        super();
        this.allowCreate = allowCreate;
        this.allowDelete = allowDelete;
		this.allowEdit = allowEdit;
		this.allowRead = allowRead;
		this.modifyAllRecords = modifyAllRecords;
		this.object = object;
		this.viewAllRecords = viewAllRecords;
    }

    //Setters and Getters
    public Boolean getAllowCreate() {
        return allowCreate;
    }

    public void setAllowCreate(Boolean allowCreate) {
        this.allowCreate = allowCreate;
    }

    public Boolean getAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(Boolean allowDelete) {
        this.allowDelete = allowDelete;
    }

    public Boolean getAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(Boolean allowEdit) {
        this.allowEdit = allowEdit;
    }

    public Boolean getAllowRead() {
        return allowRead;
    }

    public void setAllowRead(Boolean allowRead) {
        this.allowRead = allowRead;
    }

    public Boolean getModifyAllRecords() {
        return modifyAllRecords;
    }

    public void setModifyAllRecords(Boolean modifyAllRecords) {
        this.modifyAllRecords = modifyAllRecords;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Boolean getViewAllRecords() {
        return viewAllRecords;
    }

    public void setViewAllRecords(Boolean viewAllRecords) {
        this.viewAllRecords = viewAllRecords;
    }

    public static Comparator<ObjectPermissions> objectPermissionComparator = new Comparator<ObjectPermissions>() {

        public int compare(ObjectPermissions s1, ObjectPermissions s2) {
            String name1 = s1.getObject();
            String name2 = s2.getObject();
            return name1.compareTo(name2);
        }
    };

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((allowCreate == null) ? 0 : allowCreate.hashCode());
        result = prime * result + ((allowDelete == null) ? 0 : allowDelete.hashCode());
        result = prime * result + ((allowEdit == null) ? 0 : allowEdit.hashCode());
        result = prime * result + ((allowRead == null) ? 0 : allowRead.hashCode());
        result = prime * result + ((modifyAllRecords == null) ? 0 : modifyAllRecords.hashCode());
        result = prime * result + ((object == null) ? 0 : object.hashCode());
        result = prime * result + ((viewAllRecords == null) ? 0 : viewAllRecords.hashCode());
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
        ObjectPermissions other = (ObjectPermissions) obj;
        if (allowCreate == null) {
            if (other.allowCreate != null)
                return false;
        } else if (!allowCreate.equals(other.allowCreate))
            return false;
        if (allowDelete == null) {
            if (other.allowDelete != null)
                return false;
        } else if (!allowDelete.equals(other.allowDelete))
            return false;
        if (allowEdit == null) {
            if (other.allowEdit != null)
                return false;
        } else if (!allowEdit.equals(other.allowEdit))
            return false;
        if (allowRead == null) {
            if (other.allowRead != null)
                return false;
        } else if (!allowRead.equals(other.allowRead))
            return false;
        if (modifyAllRecords == null) {
            if (other.modifyAllRecords != null)
                return false;
        } else if (!modifyAllRecords.equals(other.modifyAllRecords))
            return false;
        if (object == null) {
            if (other.object != null)
                return false;
        } else if (!object.equals(other.object))
            return false;
        if (viewAllRecords == null) {
            if (other.viewAllRecords != null)
                return false;
        } else if (!viewAllRecords.equals(other.viewAllRecords))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ObjectPermissions [allowCreate=" + allowCreate + ", allowDelete=" + allowDelete + ", allowEdit="
                + allowEdit + ", allowRead=" + allowRead + ", modifyAllRecords=" + modifyAllRecords + ", object="
                + object + ", viewAllRecords=" + viewAllRecords + "]";
    }

}