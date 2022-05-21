package user;

import models.UserModel;

public class ChangeUser {
    private boolean success;
    private UserModel user;

    public ChangeUser() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }


}
