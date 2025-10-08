package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "securities")
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long securityId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private BigDecimal purchasePrice;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Date purchaseDate;

    // link to portfolio
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    protected Security() {
    }

    public Security(String name, String category, BigDecimal purchasePrice, Integer quantity, Date purchaseDate, Portfolio portfolio) {
        this.name = name;
        this.category = category;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.portfolio = portfolio;
    }
    public long getSecurityId() {
        return securityId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

}