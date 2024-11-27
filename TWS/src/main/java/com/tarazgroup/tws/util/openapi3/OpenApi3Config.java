package com.tarazgroup.tws.util.openapi3;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "TWS Documentation",
        version = "1.0",
        description = "<h3>Taraz Restful Webservice Documentation</h3>" +
                "<br/>"+
        "```Caution !!```"+
                "<br/>"+
        "<blockquote>Be sure you selected <code>WAN</code> option from below servers combobox .</blockquote>",
        contact = @Contact(
                name = "Webgostar Taraz Samaneh",
                url = "http://www.tarazgroup.com",
                email = "taraz.webgostar@gmail.com"
        ),
        termsOfService = "http://www.tarazgroup.com"

))
public class OpenApi3Config {

    @Bean
    public GroupedOpenApi authenticationOpenApi() {
        String paths[] = {"/authenticate/**"};
        return GroupedOpenApi.builder()
                .group("authentication")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi accOpenApi() {
        String paths[] = {"/acc/**"};
        return GroupedOpenApi
                .builder()
                .group("acc")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi invOpenApi() {
        String paths[] = {"/inv/**"};
        return GroupedOpenApi
                .builder()
                .group("inv")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi saleOpenApi() {
        String paths[] = {"/sale/**"};
        return GroupedOpenApi
                .builder()
                .group("sale")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi pubOpenApi() {
        String paths[] = {"/pub/**"};
        return GroupedOpenApi
                .builder()
                .group("pub")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi applicationInfoOpenApi() {
        String paths[] = {"/applicationinfo/**"};
        return GroupedOpenApi
                .builder()
                .group("applicationinfo")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi bdgOpenApi() {
        String paths[] = {"/bdg/**"};
        return GroupedOpenApi
                .builder()
                .group("bdg")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi buyOpenApi() {
        String paths[] = {"/buy/**"};
        return GroupedOpenApi
                .builder()
                .group("buy")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi crmOpenApi() {
        String paths[] = {"/crm/**"};
        return GroupedOpenApi
                .builder()
                .group("crm")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi tktOpenApi() {
        String paths[] = {"/tkt/**"};
        return GroupedOpenApi
                .builder()
                .group("tkt")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi excOpenApi() {
        String paths[] = {"/exc/**"};
        return GroupedOpenApi
                .builder()
                .group("exc")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi trsOpenApi() {
        String paths[] = {"/trs/**"};
        return GroupedOpenApi
                .builder()
                .group("trs")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi prcOpenApi() {
        String paths[] = {"/prc/**"};
        return GroupedOpenApi
                .builder()
                .group("prc")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi scrOpenApi() {
        String paths[] = {"/scr/**"};
        return GroupedOpenApi
                .builder()
                .group("scr")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi logOpenApi() {
        String paths[] = {"/log/**"};
        return GroupedOpenApi
                .builder()
                .group("log")
                .pathsToMatch(paths)
                .build();
    }

    @Value("${DEV.ip}")
    private String dev_ip;

    @Value("${DEV.port}")
    private String dev_port;

    @Value("${LAN.ip}")
    private String lan_ip;

    @Value("${LAN.port}")
    private String lan_port;

    @Value("${WAN.ip}")
    private String wan_ip;

    @Value("${WAN.port}")
    private String wan_port;

    @Value("${server.servlet.context-path}")
    private String context;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("http://"+dev_ip+":"+dev_port+context).description("DEV"))
                .addServersItem(new Server().url("http://"+lan_ip+":"+lan_port+context).description("LAN"))
                .addServersItem(new Server().url("http://"+wan_ip+":"+wan_port+context).description("WAN"))
                .components(new Components()
                        .addSecuritySchemes(
                                "bearerAuth",
                                new SecurityScheme()
                                        .name("bearerAuth")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")

                        ));
    }
}

