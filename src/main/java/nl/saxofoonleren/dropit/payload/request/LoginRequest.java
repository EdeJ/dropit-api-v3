package nl.saxofoonleren.dropit.payload.request;

public class LoginRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        username = username.toLowerCase();
        username = username.replaceAll(" ", "");
        System.out.println();
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
