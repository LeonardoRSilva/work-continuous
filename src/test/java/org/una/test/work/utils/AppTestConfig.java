package org.una.test.work.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.una.work.utils.AppConfig;

@Configuration
@Import(AppConfig.class)
public class AppTestConfig {
}
