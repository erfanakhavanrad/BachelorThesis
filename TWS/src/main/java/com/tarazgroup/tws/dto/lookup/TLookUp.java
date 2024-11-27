package com.tarazgroup.tws.dto.lookup;

public class TLookUp {
    // for get url of resource Data
    private String resourceData;
    // for get url of resource Meta
    private String resourceMeta;
    private int value;

    public TLookUp(String resourceData, String resourceMeta) {
        this.resourceData = resourceData;
        this.resourceMeta = resourceMeta;
    }

    public TLookUp(String resourceData, String resourceMeta, int value) {
        this.resourceData = resourceData;
        this.resourceMeta = resourceMeta;
        this.value = value;
    }

    public String getResourceData() {
        return resourceData;
    }

    public void setResourceData(String resourceData) {
        this.resourceData = resourceData;
    }

    public String getResourceMeta() {
        return resourceMeta;
    }

    public void setResourceMeta(String resourceMeta) {
        this.resourceMeta = resourceMeta;
    }
}
