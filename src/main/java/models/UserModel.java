package models;

public class UserModel {
    private String name;
    private String email;

    public String getEmail() {
        return email;
    }

    public UserModel() {
    }

    public UserModel(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
