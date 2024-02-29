package models;

public class User {
    private Long id;
    private String email;
    private String password;
    private String fullName;

    public User(Long id, String email, String password, String fullName){
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public boolean chekPasssword(String password){
        return this.password.equals(password);
    }

    public String getFullName(){
        return fullName;
    }
}
