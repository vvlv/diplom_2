public class LoginUserRequest {
   private boolean success;
    private    String accessToken;
    private   String refreshToken;
    private User user;
    private String email;
    private String password;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public LoginUserRequest() {}
    public LoginUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
