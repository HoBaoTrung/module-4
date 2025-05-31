package com.codegym.mailsettings;

public class MailSettings {
    private String language;
    private int pageSize;
    private boolean spamsFilter;
    private String signature;

    // Getters and Setters
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public int getPageSize() { return pageSize; }
    public void setPageSize(int pageSize) { this.pageSize = pageSize; }

    public boolean isSpamsFilter() { return spamsFilter; }
    public void setSpamsFilter(boolean spamsFilter) { this.spamsFilter = spamsFilter; }

    public String getSignature() { return signature; }
    public void setSignature(String signature) { this.signature = signature; }
}
