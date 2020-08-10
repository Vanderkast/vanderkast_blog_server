package com.vanderkast.blog_server.user_service;

public interface User {
    enum Role {
        USER,
        ADMIN;

        static Role fromInt(int pos) {
            Role[] arr = Role.values();
            if(pos < 0 || pos > arr.length - 1)
                return null;
            return arr[pos];
        }
    }
}
