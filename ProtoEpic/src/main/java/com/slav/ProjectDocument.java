package com.slav;

import java.util.Date;

public class ProjectDocument {

    private long documentIndexNumber;

    private String documentName;
    private String documentType;
    private String documentSubType;
    private String responsiblePerson;
    private String documentDescription;
    private String documentStatus;

    private Date statusDate;
    private Date receivedDate;
    private Date forecastIssuedDate;
    private Date issuedDate;

    public ProjectDocument() { }

    public ProjectDocument(String documentName) {
        this.documentName = documentName;
    }

    public long getDocumentIndexNumber() {
        return documentIndexNumber;
    }

    public void setDocumentIndexNumber(long documentIndexNumber) {
        this.documentIndexNumber = documentIndexNumber;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentSubType() {
        return documentSubType;
    }

    public void setDocumentSubType(String documentSubType) {
        this.documentSubType = documentSubType;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getForecastIssuedDate() {
        return forecastIssuedDate;
    }

    public void setForecastIssuedDate(Date prognosedIssuedDate) {
        this.forecastIssuedDate = forecastIssuedDate;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }
}
