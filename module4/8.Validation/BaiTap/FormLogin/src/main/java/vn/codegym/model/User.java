package vn.codegym.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    @NotEmpty
    @Size(min = 5 , max = 20)
    private String user;
    @NotEmpty
    @Size(min = 7 , max = 100)
    private String password;
    @Min(18)
    private int age;
    @Email
    private String email;

    public User() {
    }

    public User(@NotEmpty @Size(min = 5, max = 20) String user, @NotEmpty @Size(min = 7, max = 100) String password,
                @Min(18) int age, @Email String email) {
        this.user = user;
        this.password = password;
        this.age = age;
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
