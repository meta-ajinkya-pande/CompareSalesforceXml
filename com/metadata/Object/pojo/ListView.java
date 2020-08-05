package com.metadata.Object.pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "listView")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class ListView {
    
    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "columns")
    private List<String> columns;
    @XmlElement(name = "filterScope")
    private String filterScope;
    @XmlElement(name = "filters")
    private List<Filter> filters;
    @XmlElement(name = "label")
    private String label;
    @XmlElement(name = "language")
    private String language;
    @XmlElement(name = "sharedTo")
    private SharedTo sharedTo;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public String getFilterScope() {
        return filterScope;
    }

    public void setFilterScope(String filterScope) {
        this.filterScope = filterScope;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public SharedTo getSharedTo() {
        return sharedTo;
    }

    public void setSharedTo(SharedTo sharedTo) {
        this.sharedTo = sharedTo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((columns == null) ? 0 : columns.hashCode());
        result = prime * result + ((filterScope == null) ? 0 : filterScope.hashCode());
        result = prime * result + ((filters == null) ? 0 : filters.hashCode());
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + ((language == null) ? 0 : language.hashCode());
        result = prime * result + ((sharedTo == null) ? 0 : sharedTo.hashCode());
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
        ListView other = (ListView) obj;
        if (columns == null) {
            if (other.columns != null)
                return false;
        } else if (!columns.equals(other.columns))
            return false;
        if (filterScope == null) {
            if (other.filterScope != null)
                return false;
        } else if (!filterScope.equals(other.filterScope))
            return false;
        if (filters == null) {
            if (other.filters != null)
                return false;
        } else if (!filters.equals(other.filters))
            return false;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (language == null) {
            if (other.language != null)
                return false;
        } else if (!language.equals(other.language))
            return false;
        if (sharedTo == null) {
            if (other.sharedTo != null)
                return false;
        } else if (!sharedTo.equals(other.sharedTo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ListView [columns=" + columns + ", filterScope=" + filterScope + ", filters=" + filters + ", fullName="
                + fullName + ", label=" + label + ", language=" + language + ", sharedTo=" + sharedTo + "]";
    }
}
