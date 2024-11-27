package com.tarazgroup.tws.model.authentication;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * {@link AuthenticationResponse} Entity
 *
 * @author alireza_bayat
 * @since 2.0.0
 */
public class AuthenticationResponse implements Serializable {

    private final String token;

    private final int expire;

    private final String type = "Bearer";

    public AuthenticationResponse( String token, int expire) {
        this.token = token;
        this.expire = expire;
    }


    @Schema(
            example = "oiNDQyOS4..."
    )
    public String getToken() {
        return token;
    }

    @Schema(
            example = "360000"
    )
    public int getExpire() {
        return expire;
    }

    @Schema(
            example = "Bearer"
    )
    public String getType() {
        return type;
    }
}
