/**
 *
 */
package com.example.mapper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @NotNull
    @Size(min = 1)
    private int id;
    @Size(max = 100)
    private int age;
    @Size(max = 30)
    private String name;
    @Size(max = 100)
    private String address;
    @Size(max = 100)
    private String tell;
    @Size(max = 100)
    private String mail;

    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getTell() {
        return tell;
    }
    public String getMail() {
        return mail;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setTell(String tell) {
        this.tell = tell;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
}
