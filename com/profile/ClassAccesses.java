package com.profile;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
  
@XmlRootElement(name = "classAccesses")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ClassAccesses implements Serializable {
     
    private static final long serialVersionUID = 1L;
    
    private String apexClass;
    private Boolean enabled;
	
    public ClassAccesses() {
        super();
    }
 
    public ClassAccesses(String apexClass, Boolean enabled) {
        super();
        this.apexClass = apexClass;
        this.enabled = enabled;
    }
     
    //Setters and Getters

    public String getApexClass() {
        return apexClass;
    }

    public void setApexClass(String apexClass) {
        this.apexClass = apexClass;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public static Comparator<ClassAccesses> apexClassComparator = new Comparator<ClassAccesses>() {

        public int compare(ClassAccesses s1, ClassAccesses s2) {
            String name1 = s1.getApexClass();
            String name2 = s2.getApexClass();
            return name1.compareTo(name2);
        }
    };

    @Override
    public String toString() {
        return "ClassAccesses [apexClass=" + apexClass + ", enabled=" + enabled + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apexClass == null) ? 0 : apexClass.hashCode());
        result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
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
        ClassAccesses other = (ClassAccesses) obj;
        if (apexClass == null) {
            if (other.apexClass != null)
                return false;
        } else if (!apexClass.equals(other.apexClass))
            return false;
        if (enabled == null) {
            if (other.enabled != null)
                return false;
        } else if (!enabled.equals(other.enabled))
            return false;
        return true;
    }
}
