package com.metadata.Object;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.metadata.Object.pojo.ActionOverride;
import com.metadata.Object.pojo.CompactLayout;
import com.metadata.Object.pojo.Field;
import com.metadata.Object.pojo.FieldSet;
import com.metadata.Object.pojo.ListView;
import com.metadata.Object.pojo.RecordType;
import com.metadata.Object.pojo.SearchLayout;
import com.metadata.Object.pojo.ValidationRule;
import com.metadata.Object.pojo.WebLink;

@XmlRootElement(name = "CustomObject")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class CustomObject {
    
    @XmlTransient
    private String objectName;
    @XmlElement(name = "actionOverrides")
    private List<ActionOverride> actionOverrides;
    @XmlElement(name = "compactLayoutAssignment")
    private String compactLayoutAssignment;
    @XmlElement(name = "compactLayouts")
    private List<CompactLayout> compactLayouts;
    @XmlElement(name = "enableEnhancedLookup")
    private Boolean enableEnhancedLookup;
    @XmlElement(name = "enableFeeds")
    private Boolean enableFeeds;
    @XmlElement(name = "enableHistory")
    private Boolean enableHistory;
    @XmlElement(name = "externalSharingModel")
    private String externalSharingModel;
    @XmlElement(name = "fieldSets")
    private List<FieldSet> fieldSets;
    @XmlElement(name = "fields")
    private List<Field> fields;
    @XmlElement(name = "listViews")
    private List<ListView> listViews;
    @XmlElement(name = "recordTypeTrackFeedHistory")
    private Boolean recordTypeTrackFeedHistory;
    @XmlElement(name = "recordTypeTrackHistory")
    private Boolean recordTypeTrackHistory;
    @XmlElement(name = "recordTypes")
    private List<RecordType> recordTypes;
    @XmlElement(name = "searchLayouts")
    private SearchLayout searchLayouts;
    @XmlElement(name = "sharingModel")
    private String sharingModel;
    @XmlElement(name = "validationRules")
    private ValidationRule validationRules;
    @XmlElement(name = "webLinks")
    private WebLink webLinks;

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public List<ActionOverride> getActionOverrides() {
        return actionOverrides;
    }

    public void setActionOverrides(List<ActionOverride> actionOverrides) {
        this.actionOverrides = actionOverrides;
    }

    public String getCompactLayoutAssignment() {
        return compactLayoutAssignment;
    }

    public void setCompactLayoutAssignment(String compactLayoutAssignment) {
        this.compactLayoutAssignment = compactLayoutAssignment;
    }

    public List<CompactLayout> getCompactLayouts() {
        return compactLayouts;
    }

    public void setCompactLayouts(List<CompactLayout> compactLayouts) {
        this.compactLayouts = compactLayouts;
    }

    public Boolean getEnableEnhancedLookup() {
        return enableEnhancedLookup;
    }

    public void setEnableEnhancedLookup(Boolean enableEnhancedLookup) {
        this.enableEnhancedLookup = enableEnhancedLookup;
    }

    public Boolean getEnableFeeds() {
        return enableFeeds;
    }

    public void setEnableFeeds(Boolean enableFeeds) {
        this.enableFeeds = enableFeeds;
    }

    public Boolean getEnableHistory() {
        return enableHistory;
    }

    public void setEnableHistory(Boolean enableHistory) {
        this.enableHistory = enableHistory;
    }

    public String getExternalSharingModel() {
        return externalSharingModel;
    }

    public void setExternalSharingModel(String externalSharingModel) {
        this.externalSharingModel = externalSharingModel;
    }

    public List<FieldSet> getFieldSets() {
        return fieldSets;
    }

    public void setFieldSets(List<FieldSet> fieldSets) {
        this.fieldSets = fieldSets;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<ListView> getListViews() {
        return listViews;
    }

    public void setListViews(List<ListView> listViews) {
        this.listViews = listViews;
    }

    public Boolean getRecordTypeTrackFeedHistory() {
        return recordTypeTrackFeedHistory;
    }

    public void setRecordTypeTrackFeedHistory(Boolean recordTypeTrackFeedHistory) {
        this.recordTypeTrackFeedHistory = recordTypeTrackFeedHistory;
    }

    public Boolean getRecordTypeTrackHistory() {
        return recordTypeTrackHistory;
    }

    public void setRecordTypeTrackHistory(Boolean recordTypeTrackHistory) {
        this.recordTypeTrackHistory = recordTypeTrackHistory;
    }

    public List<RecordType> getRecordTypes() {
        return recordTypes;
    }

    public void setRecordTypes(List<RecordType> recordTypes) {
        this.recordTypes = recordTypes;
    }

    public SearchLayout getSearchLayouts() {
        return searchLayouts;
    }

    public void setSearchLayouts(SearchLayout searchLayouts) {
        this.searchLayouts = searchLayouts;
    }

    public String getSharingModel() {
        return sharingModel;
    }

    public void setSharingModel(String sharingModel) {
        this.sharingModel = sharingModel;
    }

    public ValidationRule getValidationRules() {
        return validationRules;
    }

    public void setValidationRules(ValidationRule validationRules) {
        this.validationRules = validationRules;
    }

    public WebLink getWebLinks() {
        return webLinks;
    }

    public void setWebLinks(WebLink webLinks) {
        this.webLinks = webLinks;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((actionOverrides == null) ? 0 : actionOverrides.hashCode());
        result = prime * result + ((compactLayoutAssignment == null) ? 0 : compactLayoutAssignment.hashCode());
        result = prime * result + ((compactLayouts == null) ? 0 : compactLayouts.hashCode());
        result = prime * result + ((enableEnhancedLookup == null) ? 0 : enableEnhancedLookup.hashCode());
        result = prime * result + ((enableFeeds == null) ? 0 : enableFeeds.hashCode());
        result = prime * result + ((enableHistory == null) ? 0 : enableHistory.hashCode());
        result = prime * result + ((externalSharingModel == null) ? 0 : externalSharingModel.hashCode());
        result = prime * result + ((fieldSets == null) ? 0 : fieldSets.hashCode());
        result = prime * result + ((fields == null) ? 0 : fields.hashCode());
        result = prime * result + ((listViews == null) ? 0 : listViews.hashCode());
        result = prime * result + ((objectName == null) ? 0 : objectName.hashCode());
        result = prime * result + ((recordTypeTrackFeedHistory == null) ? 0 : recordTypeTrackFeedHistory.hashCode());
        result = prime * result + ((recordTypeTrackHistory == null) ? 0 : recordTypeTrackHistory.hashCode());
        result = prime * result + ((recordTypes == null) ? 0 : recordTypes.hashCode());
        result = prime * result + ((searchLayouts == null) ? 0 : searchLayouts.hashCode());
        result = prime * result + ((sharingModel == null) ? 0 : sharingModel.hashCode());
        result = prime * result + ((validationRules == null) ? 0 : validationRules.hashCode());
        result = prime * result + ((webLinks == null) ? 0 : webLinks.hashCode());
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
        CustomObject other = (CustomObject) obj;
        if (actionOverrides == null) {
            if (other.actionOverrides != null)
                return false;
        } else if (!actionOverrides.equals(other.actionOverrides))
            return false;
        if (compactLayoutAssignment == null) {
            if (other.compactLayoutAssignment != null)
                return false;
        } else if (!compactLayoutAssignment.equals(other.compactLayoutAssignment))
            return false;
        if (compactLayouts == null) {
            if (other.compactLayouts != null)
                return false;
        } else if (!compactLayouts.equals(other.compactLayouts))
            return false;
        if (enableEnhancedLookup == null) {
            if (other.enableEnhancedLookup != null)
                return false;
        } else if (!enableEnhancedLookup.equals(other.enableEnhancedLookup))
            return false;
        if (enableFeeds == null) {
            if (other.enableFeeds != null)
                return false;
        } else if (!enableFeeds.equals(other.enableFeeds))
            return false;
        if (enableHistory == null) {
            if (other.enableHistory != null)
                return false;
        } else if (!enableHistory.equals(other.enableHistory))
            return false;
        if (externalSharingModel == null) {
            if (other.externalSharingModel != null)
                return false;
        } else if (!externalSharingModel.equals(other.externalSharingModel))
            return false;
        if (fieldSets == null) {
            if (other.fieldSets != null)
                return false;
        } else if (!fieldSets.equals(other.fieldSets))
            return false;
        if (fields == null) {
            if (other.fields != null)
                return false;
        } else if (!fields.equals(other.fields))
            return false;
        if (listViews == null) {
            if (other.listViews != null)
                return false;
        } else if (!listViews.equals(other.listViews))
            return false;
        if (objectName == null) {
            if (other.objectName != null)
                return false;
        } else if (!objectName.equals(other.objectName))
            return false;
        if (recordTypeTrackFeedHistory == null) {
            if (other.recordTypeTrackFeedHistory != null)
                return false;
        } else if (!recordTypeTrackFeedHistory.equals(other.recordTypeTrackFeedHistory))
            return false;
        if (recordTypeTrackHistory == null) {
            if (other.recordTypeTrackHistory != null)
                return false;
        } else if (!recordTypeTrackHistory.equals(other.recordTypeTrackHistory))
            return false;
        if (recordTypes == null) {
            if (other.recordTypes != null)
                return false;
        } else if (!recordTypes.equals(other.recordTypes))
            return false;
        if (searchLayouts == null) {
            if (other.searchLayouts != null)
                return false;
        } else if (!searchLayouts.equals(other.searchLayouts))
            return false;
        if (sharingModel == null) {
            if (other.sharingModel != null)
                return false;
        } else if (!sharingModel.equals(other.sharingModel))
            return false;
        if (validationRules == null) {
            if (other.validationRules != null)
                return false;
        } else if (!validationRules.equals(other.validationRules))
            return false;
        if (webLinks == null) {
            if (other.webLinks != null)
                return false;
        } else if (!webLinks.equals(other.webLinks))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomObject [actionOverrides=" + actionOverrides + ", compactLayoutAssignment="
                + compactLayoutAssignment + ", compactLayouts=" + compactLayouts + ", enableEnhancedLookup="
                + enableEnhancedLookup + ", enableFeeds=" + enableFeeds + ", enableHistory=" + enableHistory
                + ", externalSharingModel=" + externalSharingModel + ", fieldSets=" + fieldSets + ", fields=" + fields
                + ", listViews=" + listViews + ", objectName=" + objectName + ", recordTypeTrackFeedHistory="
                + recordTypeTrackFeedHistory + ", recordTypeTrackHistory=" + recordTypeTrackHistory + ", recordTypes="
                + recordTypes + ", searchLayouts=" + searchLayouts + ", sharingModel=" + sharingModel
                + ", validationRules=" + validationRules + ", webLinks=" + webLinks + "]";
    }

    public CustomObject(List<ActionOverride> actionOverrides, String compactLayoutAssignment,
            List<CompactLayout> compactLayouts, Boolean enableEnhancedLookup, Boolean enableFeeds,
            Boolean enableHistory, String externalSharingModel, List<FieldSet> fieldSets, List<Field> fields,
            List<ListView> listViews, Boolean recordTypeTrackFeedHistory, Boolean recordTypeTrackHistory,
            List<RecordType> recordTypes, SearchLayout searchLayouts, String sharingModel,
            ValidationRule validationRules, WebLink webLinks) {
        super();
        this.actionOverrides = actionOverrides;
        this.compactLayoutAssignment = compactLayoutAssignment;
        this.compactLayouts = compactLayouts;
        this.enableEnhancedLookup = enableEnhancedLookup;
        this.enableFeeds = enableFeeds;
        this.enableHistory = enableHistory;
        this.externalSharingModel = externalSharingModel;
        this.fieldSets = fieldSets;
        this.fields = fields;
        this.listViews = listViews;
        this.recordTypeTrackFeedHistory = recordTypeTrackFeedHistory;
        this.recordTypeTrackHistory = recordTypeTrackHistory;
        this.recordTypes = recordTypes;
        this.searchLayouts = searchLayouts;
        this.sharingModel = sharingModel;
        this.validationRules = validationRules;
        this.webLinks = webLinks;
    }

    public CustomObject() {
        super();
    }

}