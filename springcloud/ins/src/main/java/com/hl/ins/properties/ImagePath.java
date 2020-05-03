package com.hl.ins.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "image-path")
@Data
public class ImagePath {
    private String localPicPath;
}
