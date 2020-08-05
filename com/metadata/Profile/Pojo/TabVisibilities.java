package com.metadata.Profile.Pojo;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
  
@XmlRootElement(name = "tabVisibilities")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class TabVisibilities implements Serializable {
     
    private static final long serialVersionUID = 1L;
    
	private String tab;
	private String visibility;
	
    public TabVisibilities() {
        super();
    }
 
    public TabVisibilities(String tab, String visibility) {
        super();
        this.tab = tab;
        this.visibility = visibility;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public static Comparator<TabVisibilities> tabVisibilitiesComparator = new Comparator<TabVisibilities>() {

        public int compare(TabVisibilities s1, TabVisibilities s2) {
            String name1 = s1.getTab();
            String name2 = s2.getTab();
            return name1.compareTo(name2);
        }
    };

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tab == null) ? 0 : tab.hashCode());
        result = prime * result + ((visibility == null) ? 0 : visibility.hashCode());
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
        TabVisibilities other = (TabVisibilities) obj;
        if (tab == null) {
            if (other.tab != null)
                return false;
        } else if (!tab.equals(other.tab))
            return false;
        if (visibility == null) {
            if (other.visibility != null)
                return false;
        } else if (!visibility.equals(other.visibility))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TabVisibilities [tab=" + tab + ", visibility=" + visibility + "]";
    }
    
}