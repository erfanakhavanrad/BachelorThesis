package com.tarazgroup.tws.model.authentication;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * {@link AuthenticationRequest} Entity
 *
 * @author alireza_bayat
 * @since 2.0.0
 */
public class AuthenticationRequest implements Serializable {

    private String username;
    private String password;

    //need default constructor for JSON Parsing
    public AuthenticationRequest() {

    }

    public AuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    @Schema(
            required = true,
            example = "admin"
    )
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Schema(
            required = true,
            example = "1"
    )
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
