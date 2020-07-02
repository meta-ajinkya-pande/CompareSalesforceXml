package com.profile;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
  
@XmlRootElement(name = "customPermissions")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CustomPermissions implements Serializable {
     
    private static final long serialVersionUID = 1L;
    
    private String name;
    private Boolean enabled;
	
    public CustomPermissions() {
        super();
    }
 
    public CustomPermissions(String name, Boolean enabled) {
        super();
        this.name = name;
        this.enabled = enabled;
    }
     
    //Setters and Getters
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

    public static Comparator<CustomPermissions> customPermissionComparator = new Comparator<CustomPermissions>() {

        public int compare(CustomPermissions s1, CustomPermissions s2) {
            String name1 = s1.getName();
            String name2 = s2.getName();
            return name1.compareTo(name2);
        }
    };

    @Override
    public String toString() {
        return "CustomPermissions [enabled=" + enabled + ", name=" + name + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        CustomPermissions other = (CustomPermissions) obj;
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
}

