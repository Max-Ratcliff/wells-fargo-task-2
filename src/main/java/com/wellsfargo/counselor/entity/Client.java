package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = false)
    private Date signupDate;

    // link to advisor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id", nullable = false)
    private Advisor advisor;

    // link to portfolio
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Portfolio portfolio;

    protected Client() {
    }

    public Client(String name, String email, String phoneNumber, Date signupDate, Advisor advisor) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.signupDate = signupDate;
        this.advisor = advisor;
    }

    public long getClientId() {
        return clientId;
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

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}