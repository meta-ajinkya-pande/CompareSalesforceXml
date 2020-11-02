package com.metadata.Object.pojo;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "webLinks")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class WebLink {
    
    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "availability")
    private String availability;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "displayType")
    private String displayType;
    @XmlElement(name = "encodingKey")
    private String encodingKey;
    @XmlElement(name = "hasMenubar")
    private Boolean hasMenubar;
    @XmlElement(name = "hasScrollbars")
    private Boolean hasScrollbars;
    @XmlElement(name = "hasToolbar")
    private Boolean hasToolbar;
    @XmlElement(name = "height")
    private Integer height;
    @XmlElement(name = "isResizable")
    private Boolean isResizable;
    @XmlElement(name = "linkType")
    private String linkType;
    @XmlElement(name = "masterLabel")
    private String masterLabel;
    @XmlElement(name = "openType")
    private String openType;
    @XmlElement(name = "position")
    private String position;
    @XmlElement(name = "protected")
    private Boolean protecteded;
    @XmlElement(name = "showsLocation")
    private Boolean showsLocation;
    @XmlElement(name = "showsStatus")
    private Boolean showsStatus;
    @XmlElement(name = "url")
    private String url;
    @XmlElement(name = "requireRowSelection")
    private Boolean requireRowSelection;
    @XmlElement(name = "page")
    private String page;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getEncodingKey() {
        return encodingKey;
    }

    public void setEncodingKey(String encodingKey) {
        this.encodingKey = encodingKey;
    }

    public Boolean getHasMenubar() {
        return hasMenubar;
    }

    public void setHasMenubar(Boolean hasMenubar) {
        this.hasMenubar = hasMenubar;
    }

    public Boolean getHasScrollbars() {
        return hasScrollbars;
    }

    public void setHasScrollbars(Boolean hasScrollbars) {
        this.hasScrollbars = hasScrollbars;
    }

    public Boolean getHasToolbar() {
        return hasToolbar;
    }

    public void setHasToolbar(Boolean hasToolbar) {
        this.hasToolbar = hasToolbar;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getIsResizable() {
        return isResizable;
    }

    public void setIsResizable(Boolean isResizable) {
        this.isResizable = isResizable;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getMasterLabel() {
        return masterLabel;
    }

    public void setMasterLabel(String masterLabel) {
        this.masterLabel = masterLabel;
    }

    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getProtecteded() {
        return protecteded;
    }

    public void setProtecteded(Boolean protecteded) {
        this.protecteded = protecteded;
    }

    public Boolean getShowsLocation() {
        return showsLocation;
    }

    public void setShowsLocation(Boolean showsLocation) {
        this.showsLocation = showsLocation;
    }

    public Boolean getShowsStatus() {
        return showsStatus;
    }

    public void setShowsStatus(Boolean showsStatus) {
        this.showsStatus = showsStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getRequireRowSelection() {
        return requireRowSelection;
    }

    public void setRequireRowSelection(Boolean requireRowSelection) {
        this.requireRowSelection = requireRowSelection;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public int hashCode() {
        final Integer prime = 31;
        Integer result = 1;
        result = prime * result + ((availability == null) ? 0 : availability.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((displayType == null) ? 0 : displayType.hashCode());
        result = prime * result + ((encodingKey == null) ? 0 : encodingKey.hashCode());
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((hasMenubar == null) ? 0 : hasMenubar.hashCode());
        result = prime * result + ((hasScrollbars == null) ? 0 : hasScrollbars.hashCode());
        result = prime * result + ((hasToolbar == null) ? 0 : hasToolbar.hashCode());
        result = prime * result + height;
        result = prime * result + ((isResizable == null) ? 0 : isResizable.hashCode());
        result = prime * result + ((linkType == null) ? 0 : linkType.hashCode());
        result = prime * result + ((masterLabel == null) ? 0 : masterLabel.hashCode());
        result = prime * result + ((openType == null) ? 0 : openType.hashCode());
        result = prime * result + ((page == null) ? 0 : page.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + ((protecteded == null) ? 0 : protecteded.hashCode());
        result = prime * result + ((requireRowSelection == null) ? 0 : requireRowSelection.hashCode());
        result = prime * result + ((showsLocation == null) ? 0 : showsLocation.hashCode());
        result = prime * result + ((showsStatus == null) ? 0 : showsStatus.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
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
        WebLink other = (WebLink) obj;
        if (availability == null) {
            if (other.availability != null)
                return false;
        } else if (!availability.equals(other.availability))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (displayType == null) {
            if (other.displayType != null)
                return false;
        } else if (!displayType.equals(other.displayType))
            return false;
        if (encodingKey == null) {
            if (other.encodingKey != null)
                return false;
        } else if (!encodingKey.equals(other.encodingKey))
            return false;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        if (hasMenubar == null) {
            if (other.hasMenubar != null)
                return false;
        } else if (!hasMenubar.equals(other.hasMenubar))
            return false;
        if (hasScrollbars == null) {
            if (other.hasScrollbars != null)
                return false;
        } else if (!hasScrollbars.equals(other.hasScrollbars))
            return false;
        if (hasToolbar == null) {
            if (other.hasToolbar != null)
                return false;
        } else if (!hasToolbar.equals(other.hasToolbar))
            return false;
        if (height != other.height)
            return false;
        if (isResizable == null) {
            if (other.isResizable != null)
                return false;
        } else if (!isResizable.equals(other.isResizable))
            return false;
        if (linkType == null) {
            if (other.linkType != null)
                return false;
        } else if (!linkType.equals(other.linkType))
            return false;
        if (masterLabel == null) {
            if (other.masterLabel != null)
                return false;
        } else if (!masterLabel.equals(other.masterLabel))
            return false;
        if (openType == null) {
            if (other.openType != null)
                return false;
        } else if (!openType.equals(other.openType))
            return false;
        if (page == null) {
            if (other.page != null)
                return false;
        } else if (!page.equals(other.page))
            return false;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        if (protecteded == null) {
            if (other.protecteded != null)
                return false;
        } else if (!protecteded.equals(other.protecteded))
            return false;
        if (requireRowSelection == null) {
            if (other.requireRowSelection != null)
                return false;
        } else if (!requireRowSelection.equals(other.requireRowSelection))
            return false;
        if (showsLocation == null) {
            if (other.showsLocation != null)
                return false;
        } else if (!showsLocation.equals(other.showsLocation))
            return false;
        if (showsStatus == null) {
            if (other.showsStatus != null)
                return false;
        } else if (!showsStatus.equals(other.showsStatus))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "WebLink [availability=" + availability + ", description=" + description + ", displayType=" + displayType
                + ", encodingKey=" + encodingKey + ", fullName=" + fullName + ", hasMenubar=" + hasMenubar
                + ", hasScrollbars=" + hasScrollbars + ", hasToolbar=" + hasToolbar + ", height=" + height
                + ", isResizable=" + isResizable + ", linkType=" + linkType + ", masterLabel=" + masterLabel
                + ", openType=" + openType + ", page=" + page + ", position=" + position + ", protecteded="
                + protecteded + ", requireRowSelection=" + requireRowSelection + ", showsLocation=" + showsLocation
                + ", showsStatus=" + showsStatus + ", url=" + url + "]";
    }
    
}
