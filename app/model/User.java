package model;

import mapper.annotation.Column;
import mapper.annotation.JsonField;

/**
 * @author AKBAR <akbar.attijani@gmail.com>
 */
public class User {
    @Column(name = "id")
    @JsonField(key = "id")
    private int id;

    @Column(name = "name")
    @JsonField(key = "name")
    private String name;

    @Column(name = "password")
    @JsonField(key = "password")
    private String password;

    @Column(name = "email")
    @JsonField(key = "email")
    private String email;

    @Column(name = "address")
    @JsonField(key = "address")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
