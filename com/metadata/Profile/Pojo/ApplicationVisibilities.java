package com.metadata.Profile.Pojo;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "applicationVisibilities")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class ApplicationVisibilities implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "application")
    private String application;
    @XmlElement(name = "default")
    private Boolean defaultTag;
    @XmlElement(name = "visible")
    private Boolean visible;

    public ApplicationVisibilities() {
        super();
    }

    public ApplicationVisibilities(String application, Boolean defaultTag, Boolean visible) {
        super();
        this.application = application;
        this.defaultTag = defaultTag;
        this.visible = visible;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public Boolean getDefaultTag() {
        return defaultTag;
    }

    public void setDefaultTag(Boolean defaultTag) {
        this.defaultTag = defaultTag;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public static Comparator<ApplicationVisibilities> applicationComparator = new Comparator<ApplicationVisibilities>() {

        public int compare(ApplicationVisibilities s1, ApplicationVisibilities s2) {
            String applicationName1 = s1.getApplication();
            String applicationName2 = s2.getApplication();
            return applicationName1.compareTo(applicationName2);
        }
    };

    @Override
    public String toString() {
        return "ApplicationVisibilities [application=" + application + ", default=" + defaultTag + ", visible="
                + visible + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((application == null) ? 0 : application.hashCode());
        result = prime * result + ((defaultTag == null) ? 0 : defaultTag.hashCode());
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
        ApplicationVisibilities other = (ApplicationVisibilities) obj;
        if (application == null) {
            if (other.application != null)
                return false;
        } else if (!application.equals(other.application))
            return false;
        if (defaultTag == null) {
            if (other.defaultTag != null)
                return false;
        } else if (!defaultTag.equals(other.defaultTag))
            return false;
        if (visible == null) {
            if (other.visible != null)
                return false;
        } else if (!visible.equals(other.visible))
            return false;
        return true;
    }
}