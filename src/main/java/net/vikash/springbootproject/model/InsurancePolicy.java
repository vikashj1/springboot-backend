package net.vikash.springbootproject.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "insurancePolicies")
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "policy_number")
    private String policyNumber;
    @Column(name = "policy_type")
    private String policyType;
    @Column(name = "coverage_amount")
    private String coverageAmount;
    @Column(name = "premium")
    private String premium;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_claim_id")
    private Claim claim;

    public InsurancePolicy(){

    }

    public InsurancePolicy(String policyNumber, String policyType, String coverageAmount, String premium, LocalDate startDate, LocalDate endDate) {
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(String coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
