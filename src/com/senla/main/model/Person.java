package com.senla.main.model;

import com.senla.main.util.Role;

public class Person {

    private Integer id;
    private String username;
    private String password;
    private Role role;

    public Person(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = Role.USER;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role.toString();
    }
}
