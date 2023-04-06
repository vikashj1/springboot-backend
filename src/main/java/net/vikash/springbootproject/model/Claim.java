package net.vikash.springbootproject.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "claims")

public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "claim_number")
    private String claimNumber;
    @Column(name = "description")
    private String description;
    @Column(name = "claim_date")
    private LocalDate claimDate;
    @Column(name = "claim_status")
    private String claimStatus;

    public  Claim(){

    }

    public Claim(String claimNumber, String description, LocalDate claimDate, String claimStatus) {
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }
}
