package main.java.com.ingsf.abarroteria.dto.request;
public class LoginDTORequest {
    //atributos
    private String email;
    private String password;
    // constructor
    public LoginDTORequest(String email, String password) {
        this.email = email;
        this.password = password;   
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}