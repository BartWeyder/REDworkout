package xyz.redworkout.model;

/**
 * Created by Eugenij Kizim on 04-Jun-17.
 */

import java.io.Serializable;

public enum UserRoleType implements Serializable{
    USER("USER"),
    ADMIN("ADMIN");

    String userRoleType;

    private UserRoleType(String userRoleType) {this.userRoleType = userRoleType;}

    public String getUserRoleType() {return userRoleType;}
}
