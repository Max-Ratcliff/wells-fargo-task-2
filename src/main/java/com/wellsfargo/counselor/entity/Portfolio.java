package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioId;

    @Column(nullable = false)
    private String portfolioName;

    @Column(nullable = false)
    private Date creationDate;

    // link to client
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    // link to securities
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities = new ArrayList<>();

    protected Portfolio() {
    }

    public Portfolio(String portfolioName, Date creationDate, Client client) {
        this.portfolioName = portfolioName;
        this.creationDate = creationDate;
        this.client = client;
    }
    public long getPortfolioId() {
        return portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}