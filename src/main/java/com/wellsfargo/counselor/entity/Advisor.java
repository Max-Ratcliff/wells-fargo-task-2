package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
public class Advisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long advisorId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String phoneNumber;

    protected Advisor() {
    }

    public Advisor(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public long getAdvisorId() {
        return advisorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
