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

    @Column(name = "nip")
    @JsonField(key = "nip")
    private int nip;

    @Column(name = "name")
    @JsonField(key = "name")
    private String name;

    @Column(name = "password")
    @JsonField(key = "password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
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
}
