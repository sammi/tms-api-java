package com.hanyun.tms.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImageModel implements Serializable {
    @SerializedName("FileName")
    private String fileName;
    @SerializedName("Content")
    private String content;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
