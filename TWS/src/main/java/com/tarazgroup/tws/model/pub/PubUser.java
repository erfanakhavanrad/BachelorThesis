package com.tarazgroup.tws.model.pub;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
@Entity
@Table(name = "PubUsers")
public class PubUser {
    @Id
    @Column(name = "UserID")
    private BigDecimal userID;

    @Column(name = "AndroidUserPass")
    private String androidUserPass;

    @Column(name = "IsActive")
    private boolean isActive;

    @Column(name = "ActiveYearID")
    @Parameter
    private BigDecimal activeYearID;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "IsAdmin")
    @Parameter
    private String isAdmin;

    @Schema(
            required = true,
            example = "false"
    )
    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    @Schema(hidden = true)
    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    @Schema(
            required = false,
            example = "10000018"
    )
    public BigDecimal getActiveYearID() {
        return activeYearID;
    }

    public void setActiveYearID(BigDecimal activeYearID) {
        this.activeYearID = activeYearID;
    }

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
    }

    public String getAndroidUserPass() {
        return androidUserPass;
    }

    public void setAndroidUserPass(String androidUserPass) {
        this.androidUserPass = androidUserPass;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
