/**
 *
 */
package com.example.mapper;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @Min(0)
    @Max(10)
    @NotNull
    public Integer id;
    @Min(0)
    @Max(10)
    @NotNull
    public Integer age;
    @Size(min = 1, max = 20)
    @NotEmpty
    private String name;
    @NotEmpty
    @Size(min = 1, max = 20)
    private String address;
    @NotEmpty
    @Size(min = 1, max = 20)
    private String tell;
    @NotEmpty
    @Size(min = 1, max = 20)
    private String mail;

    public Integer getId() {
        return id;
    }
    public Integer getAge() {
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

    public void setId(Integer id) {
        this.id = id;
    }
    public void setAge(Integer age) {
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
