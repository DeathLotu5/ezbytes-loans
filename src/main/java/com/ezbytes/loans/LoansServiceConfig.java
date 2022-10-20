package com.ezbytes.loans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "loans") //Để tải xuống tất cả các property file property với prefix
// là account trong config server xuống để map vào các thuộc tính bên trong class này
@Getter
@Setter
@ToString
public class LoansServiceConfig {

    private String msg;

    private String buildVersion;

    private Map<String, String> mailDetails;

    private List<String> activeBranches;

}