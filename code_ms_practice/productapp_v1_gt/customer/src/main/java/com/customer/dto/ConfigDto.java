package com.customer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "info")
@ToString
public class ConfigDto {
    private String message;
    private String name;
}
