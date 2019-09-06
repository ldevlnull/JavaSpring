package com.alexcompany.model;

import com.alexcompany.validator.EmailConstraint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Validated
public class User{

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    private Long id;
    @NotEmpty(message = "Username is required!")
    @Length(message = "Username should be longer than 3 symbols", min = 3)
    private String username;
    @EmailConstraint
    private String email;
    @NotEmpty(message = "Password is required!")
    @Length(message = "Password should be longer than 6 symbols", min = 6)
    private String password;
    private int age;
    private String phone;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
