package com.save_email_configs_app.service.impl;

import com.save_email_configs_app.model.EmailConfig;
import com.save_email_configs_app.service.EmailConfigsService;

public class EmailConfigsServiceImpl implements EmailConfigsService {
    @Override
    public void saveConfigs(EmailConfig emailConfig) {
        EmailConfig instance = EmailConfig.getInstance();
        instance.setLanguage(emailConfig.getLanguage());
        instance.setSignature(emailConfig.getSignature());
        instance.setPageSize(emailConfig.getPageSize());
        instance.setEnableSpamFilter(emailConfig.isEnableSpamFilter());
    }
}
