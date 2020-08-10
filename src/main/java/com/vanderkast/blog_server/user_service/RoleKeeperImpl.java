package com.vanderkast.blog_server.user_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RoleKeeperImpl implements RoleKeeper {
    @Value("${role.name.admin}")
    private String roleAdmin;

    @Value("${role.name.user}")
    private String roleUser;

    @Override
    public String getRoleAdmin() {
        return roleAdmin;
    }

    @Override
    public String getRoleUser() {
        return roleUser;
    }
}
