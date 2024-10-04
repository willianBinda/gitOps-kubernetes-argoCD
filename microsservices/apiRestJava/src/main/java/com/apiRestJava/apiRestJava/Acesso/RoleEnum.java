package com.apiRestJava.apiRestJava.Acesso;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum RoleEnum {

    ADMIN("admin"),
    USER("user");

    public final String role;

    RoleEnum(String role) {
        this.role = role;
    }
}
