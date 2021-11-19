package com.callor.jc.config.beans;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
// @Configuration
@Component
public class EncConfig {
    // 환경변수에서 비밀번호를 가져와서 암호화시키는 코드
    private EnvironmentStringPBEConfig envConfig() {
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();

        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPasswordEnvName("callor.com");

        log.debug("ENV : " + config.getPasswordEnvName() + config.getPassword());

        return config;
    }

    // 비밀번호를 복구화시키는 코드
    @Bean("encryptor")
    public StandardPBEStringEncryptor encryptor() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

        encryptor.setConfig(this.envConfig());

        return encryptor;
    }
}
