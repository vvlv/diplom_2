public class CreateUserRequest {

private String email;
private String password;
private String name;
private boolean success;
private String message;
private User user;
private String accessToken;
    private String refreshToken;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public CreateUserRequest () {}

    public CreateUserRequest (String email) {
        this.email = email;
    }
    public CreateUserRequest (boolean success,String message) {
        this.success = success;
        this.message = message;
    }
    public CreateUserRequest (String email,String password) {
        this.email = email;
        this.password = password;
    }
    public CreateUserRequest (String email,String password,String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
