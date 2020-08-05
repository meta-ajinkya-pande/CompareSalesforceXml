package com.metadata.Object.pojo;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fields")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class Field {

    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "deprecated")
    private Boolean deprecated;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "externalId")
    private Boolean externalId;
    @XmlElement(name = "inlineHelpText")
    private String inlineHelpText;
    @XmlElement(name = "label")
    private String label;
    @XmlElement(name = "required")
    private Boolean required;
    @XmlElement(name = "trackFeedHistory")
    private Boolean trackFeedHistory;
    @XmlElement(name = "trackHistory")
    private Boolean trackHistory;
    @XmlElement(name = "type")
    private String type;
    @XmlElement(name = "valueSet")
    private ValueSet valueSet;
    @XmlElement(name = "unique")
    private Boolean unique;
    @XmlElement(name = "formulaTreatBlanksAs")
    private String formulaTreatBlanksAs;
    @XmlElement(name = "formula")
    private String formula;
    @XmlElement(name = "precision")
    private int precision;
    @XmlElement(name = "scale")
    private int scale;
    @XmlElement(name = "length")
    private int length;
    @XmlElement(name = "visibleLines")
    private int visibleLines;
    @XmlElement(name = "deleteConstraint")
    private String deleteConstraint;
    @XmlElement(name = "lookupFilter")
    private LookupFilter lookupFilter;
    @XmlElement(name = "referenceTo")
    private String referenceTo;
    @XmlElement(name = "relationshipLabel")
    private String relationshipLabel;
    @XmlElement(name = "relationshipName")
    private String relationshipName;
    

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getExternalId() {
        return externalId;
    }

    public void setExternalId(Boolean externalId) {
        this.externalId = externalId;
    }

    public String getInlineHelpText() {
        return inlineHelpText;
    }

    public void setInlineHelpText(String inlineHelpText) {
        this.inlineHelpText = inlineHelpText;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean getTrackFeedHistory() {
        return trackFeedHistory;
    }

    public void setTrackFeedHistory(Boolean trackFeedHistory) {
        this.trackFeedHistory = trackFeedHistory;
    }

    public Boolean getTrackHistory() {
        return trackHistory;
    }

    public void setTrackHistory(Boolean trackHistory) {
        this.trackHistory = trackHistory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ValueSet getValueSet() {
        return valueSet;
    }

    public void setValueSet(ValueSet valueSet) {
        this.valueSet = valueSet;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((deleteConstraint == null) ? 0 : deleteConstraint.hashCode());
        result = prime * result + ((deprecated == null) ? 0 : deprecated.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((externalId == null) ? 0 : externalId.hashCode());
        result = prime * result + ((formula == null) ? 0 : formula.hashCode());
        result = prime * result + ((formulaTreatBlanksAs == null) ? 0 : formulaTreatBlanksAs.hashCode());
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((inlineHelpText == null) ? 0 : inlineHelpText.hashCode());
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + length;
        result = prime * result + ((lookupFilter == null) ? 0 : lookupFilter.hashCode());
        result = prime * result + precision;
        result = prime * result + ((referenceTo == null) ? 0 : referenceTo.hashCode());
        result = prime * result + ((relationshipLabel == null) ? 0 : relationshipLabel.hashCode());
        result = prime * result + ((relationshipName == null) ? 0 : relationshipName.hashCode());
        result = prime * result + ((required == null) ? 0 : required.hashCode());
        result = prime * result + scale;
        result = prime * result + ((trackFeedHistory == null) ? 0 : trackFeedHistory.hashCode());
        result = prime * result + ((trackHistory == null) ? 0 : trackHistory.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((unique == null) ? 0 : unique.hashCode());
        result = prime * result + ((valueSet == null) ? 0 : valueSet.hashCode());
        result = prime * result + visibleLines;
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
        Field other = (Field) obj;
        if (deleteConstraint == null) {
            if (other.deleteConstraint != null)
                return false;
        } else if (!deleteConstraint.equals(other.deleteConstraint))
            return false;
        if (deprecated == null) {
            if (other.deprecated != null)
                return false;
        } else if (!deprecated.equals(other.deprecated))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (externalId == null) {
            if (other.externalId != null)
                return false;
        } else if (!externalId.equals(other.externalId))
            return false;
        if (formula == null) {
            if (other.formula != null)
                return false;
        } else if (!formula.equals(other.formula))
            return false;
        if (formulaTreatBlanksAs == null) {
            if (other.formulaTreatBlanksAs != null)
                return false;
        } else if (!formulaTreatBlanksAs.equals(other.formulaTreatBlanksAs))
            return false;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        if (inlineHelpText == null) {
            if (other.inlineHelpText != null)
                return false;
        } else if (!inlineHelpText.equals(other.inlineHelpText))
            return false;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (length != other.length)
            return false;
        if (lookupFilter == null) {
            if (other.lookupFilter != null)
                return false;
        } else if (!lookupFilter.equals(other.lookupFilter))
            return false;
        if (precision != other.precision)
            return false;
        if (referenceTo == null) {
            if (other.referenceTo != null)
                return false;
        } else if (!referenceTo.equals(other.referenceTo))
            return false;
        if (relationshipLabel == null) {
            if (other.relationshipLabel != null)
                return false;
        } else if (!relationshipLabel.equals(other.relationshipLabel))
            return false;
        if (relationshipName == null) {
            if (other.relationshipName != null)
                return false;
        } else if (!relationshipName.equals(other.relationshipName))
            return false;
        if (required == null) {
            if (other.required != null)
                return false;
        } else if (!required.equals(other.required))
            return false;
        if (scale != other.scale)
            return false;
        if (trackFeedHistory == null) {
            if (other.trackFeedHistory != null)
                return false;
        } else if (!trackFeedHistory.equals(other.trackFeedHistory))
            return false;
        if (trackHistory == null) {
            if (other.trackHistory != null)
                return false;
        } else if (!trackHistory.equals(other.trackHistory))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (unique == null) {
            if (other.unique != null)
                return false;
        } else if (!unique.equals(other.unique))
            return false;
        if (valueSet == null) {
            if (other.valueSet != null)
                return false;
        } else if (!valueSet.equals(other.valueSet))
            return false;
        if (visibleLines != other.visibleLines)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Field [deleteConstraint=" + deleteConstraint + ", deprecated=" + deprecated + ", description="
                + description + ", externalId=" + externalId + ", formula=" + formula + ", formulaTreatBlanksAs="
                + formulaTreatBlanksAs + ", fullName=" + fullName + ", inlineHelpText=" + inlineHelpText + ", label="
                + label + ", length=" + length + ", lookupFilter=" + lookupFilter + ", precision=" + precision
                + ", referenceTo=" + referenceTo + ", relationshipLabel=" + relationshipLabel + ", relationshipName="
                + relationshipName + ", required=" + required + ", scale=" + scale + ", trackFeedHistory="
                + trackFeedHistory + ", trackHistory=" + trackHistory + ", type=" + type + ", unique=" + unique
                + ", valueSet=" + valueSet + ", visibleLines=" + visibleLines + "]";
    }

    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public String getFormulaTreatBlanksAs() {
        return formulaTreatBlanksAs;
    }

    public void setFormulaTreatBlanksAs(String formulaTreatBlanksAs) {
        this.formulaTreatBlanksAs = formulaTreatBlanksAs;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getVisibleLines() {
        return visibleLines;
    }

    public void setVisibleLines(int visibleLines) {
        this.visibleLines = visibleLines;
    }

    public String getDeleteConstraint() {
        return deleteConstraint;
    }

    public void setDeleteConstraint(String deleteConstraint) {
        this.deleteConstraint = deleteConstraint;
    }

    public LookupFilter getLookupFilter() {
        return lookupFilter;
    }

    public void setLookupFilter(LookupFilter lookupFilter) {
        this.lookupFilter = lookupFilter;
    }

    public String getReferenceTo() {
        return referenceTo;
    }

    public void setReferenceTo(String referenceTo) {
        this.referenceTo = referenceTo;
    }

    public String getRelationshipLabel() {
        return relationshipLabel;
    }

    public void setRelationshipLabel(String relationshipLabel) {
        this.relationshipLabel = relationshipLabel;
    }

    public String getRelationshipName() {
        return relationshipName;
    }

    public void setRelationshipName(String relationshipName) {
        this.relationshipName = relationshipName;
    }
}
