package com.hanyun.tms.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UpdateInvoiceModel implements Serializable {
    @SerializedName("InvoiceId")
    private Long invoiceId;
    @SerializedName("NormalStatusId")
    private Integer normalStatusId;
    @SerializedName("ExceptionStatusId")
    private Integer exceptionStatusId;
    @SerializedName("ExternalStatus")
    private Integer externalStatus;
    @SerializedName("ExternalDescription")
    private String externalDescription;
    @SerializedName("Description")
    private String description;
    // must format as "yyyy-MM-dd"
    @SerializedName("ReceivedDate")
    private String receivedDate;
    @SerializedName("ImageArray")
    private List<ImageModel> imageArray;

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getNormalStatusId() {
        return normalStatusId;
    }

    public void setNormalStatusId(Integer normalStatusId) {
        this.normalStatusId = normalStatusId;
    }

    public Integer getExceptionStatusId() {
        return exceptionStatusId;
    }

    public void setExceptionStatusId(Integer exceptionStatusId) {
        this.exceptionStatusId = exceptionStatusId;
    }

    public Integer getExternalStatus() {
        return externalStatus;
    }

    public void setExternalStatus(Integer externalStatus) {
        this.externalStatus = externalStatus;
    }

    public String getExternalDescription() {
        return externalDescription;
    }

    public void setExternalDescription(String externalDescription) {
        this.externalDescription = externalDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public List<ImageModel> getImageArray() {
        return imageArray;
    }

    public void setImageArray(List<ImageModel> imageArray) {
        this.imageArray = imageArray;
    }
}
