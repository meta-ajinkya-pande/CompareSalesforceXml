package com.metadata.Profile.Pojo;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
  
@XmlRootElement(name = "userPermissions")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class UserPermissions implements Serializable {
     
    private static final long serialVersionUID = 1L;
    
	private String name;
	private Boolean enabled;
	
    public UserPermissions() {
        super();
    }
 
    public UserPermissions(String name, Boolean enabled) {
        super();
        this.name = name;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public static Comparator<UserPermissions> userPermissionsComparator = new Comparator<UserPermissions>() {

        public int compare(UserPermissions s1, UserPermissions s2) {
            String name1 = s1.getName();
            String name2 = s2.getName();
            return name1.compareTo(name2);
        }
    };

    @Override
    public int hashCode() {
        final Integer prime = 31;
        Integer result = 1;
        result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        UserPermissions other = (UserPermissions) obj;
        if (enabled == null) {
            if (other.enabled != null)
                return false;
        } else if (!enabled.equals(other.enabled))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserPermissions [enabled=" + enabled + ", name=" + name + "]";
    }
    
}