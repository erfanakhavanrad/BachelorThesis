package com.tarazgroup.tws.dto.pub;

import com.tarazgroup.tws.model.pub.PubUsers;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class PubUsersDto extends PubUsers {
    private String userPassWordRepeat;

    private String androidPassRepeat;

    public String getUserPassWordRepeat() {
        return userPassWordRepeat;
    }

    public void setUserPassWordRepeat(String userPassWordRepeat) {
        this.userPassWordRepeat = userPassWordRepeat;
    }

    public String getAndroidPassRepeat() {
        return androidPassRepeat;
    }

    public void setAndroidPassRepeat(String androidPassRepeat) {
        this.androidPassRepeat = androidPassRepeat;
    }
}
