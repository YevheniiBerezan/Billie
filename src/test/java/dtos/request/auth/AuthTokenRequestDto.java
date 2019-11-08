package dtos.request.auth;

public class AuthTokenRequestDto {

    public AuthTokenRequestDto(){
        username = "admin";
        password = "password123";
    }

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
