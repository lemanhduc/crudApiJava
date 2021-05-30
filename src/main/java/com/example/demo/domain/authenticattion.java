package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

public class authenticattion {
    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    private boolean authenticated = false;

    public User getMyUser() {
        return myUser;
    }

    public void setMyUser(User myUser) {
        this.myUser = myUser;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User myUser;




    public  authenticattion() {

        if (this.isAuthenticated()) {
            myUser = new User();
            myUser.setEmail("");
            myUser.setPassword("");
        }
    }
}
