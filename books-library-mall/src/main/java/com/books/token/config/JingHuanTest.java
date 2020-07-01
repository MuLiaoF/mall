package com.books.token.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@Slf4j
public class JingHuanTest extends ApplicationObjectSupport implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("========================================applicationContext=/////////////");

        ApplicationContext applicationContext = getApplicationContext();

        log.info("========================================applicationContext="+applicationContext);
        log.info("========================================applicationContext="+applicationContext);
        log.info("========================================applicationContext="+applicationContext);
        log.info("========================================applicationContext="+applicationContext);
    }
}
