package com.stefan.automation.context;

import com.stefan.automation.models.User;

public class TestContext {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
