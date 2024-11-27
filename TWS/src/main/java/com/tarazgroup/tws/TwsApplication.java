package com.tarazgroup.tws;

import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.TimeoutException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;

import java.io.IOException;


/**
 * @author alireza_bayat
 * @since 2.0.0
 */

@SpringBootApplication
//@ServletComponentScan
public class TwsApplication extends SpringBootServletInitializer {

    public TwsApplication() throws IOException {
    }

    public static void main(String[] args) throws IOException, AuthenticationFailedException, InterruptedException, TimeoutException {
        SpringApplication.run(TwsApplication.class, args);
//        Logger logger = new Logger();
//        logger.run();

    }
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws IOException, AuthenticationFailedException, InterruptedException, TimeoutException {
//        Logger logger = new Logger();
//        logger.run();
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TwsApplication.class);
    }
}
