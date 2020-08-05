package com.metadata.Profile.Pojo;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
  
@XmlRootElement(name = "pageAccesses")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class PageAccesses implements Serializable {
     
    private static final long serialVersionUID = 1L;
    
	private String apexPage;
	private Boolean enabled;
	
    public PageAccesses() {
        super();
    }
 
    public PageAccesses(String apexPage, Boolean enabled) {
        super();
        this.apexPage = apexPage;
        this.enabled = enabled;
    }
    
    //Setters and Getters
    public String getApexPage() {
        return apexPage;
    }

    public void setApexPage(String apexPage) {
        this.apexPage = apexPage;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public static Comparator<PageAccesses> pageAccessesComparator = new Comparator<PageAccesses>() {

        public int compare(PageAccesses s1, PageAccesses s2) {
            String name1 = s1.getApexPage();
            String name2 = s2.getApexPage();
            return name1.compareTo(name2);
        }
    };

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apexPage == null) ? 0 : apexPage.hashCode());
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
        PageAccesses other = (PageAccesses) obj;
        if (apexPage == null) {
            if (other.apexPage != null)
                return false;
        } else if (!apexPage.equals(other.apexPage))
            return false;
        if (enabled == null) {
            if (other.enabled != null)
                return false;
        } else if (!enabled.equals(other.enabled))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PageAccesses [apexPage=" + apexPage + ", enabled=" + enabled + "]";
    }
 
}