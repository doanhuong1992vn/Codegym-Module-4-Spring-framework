package com.save_email_configs_app.model;

public class EmailConfig {
    private static final EmailConfig emailConfig = new EmailConfig();
    private Languages language = Languages.Vietnamese;
    private int pageSize = 25;
    private boolean isEnableSpamFilter = true;
    private String signature = "Đoàn Hưởng\r\n\r\n\r\n21K Nguyễn Văn Trỗi, Phú Nhuận";
    private EmailConfig(){}
    public static EmailConfig getInstance() {
        return emailConfig;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isEnableSpamFilter() {
        return isEnableSpamFilter;
    }

    public void setEnableSpamFilter(boolean enableSpamFilter) {
        isEnableSpamFilter = enableSpamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}
