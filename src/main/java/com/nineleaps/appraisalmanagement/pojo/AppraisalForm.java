package com.nineleaps.appraisalmanagement.pojo;


import javax.persistence.*;

@Entity
@Table(name = "appraisal_table")
public class AppraisalForm {

    @Column(name = "inclusion")
    private String inclusion;

    @Column(name = "metal")
    private String metal;

    @Column(name = "pioneering")
    private String pioneering;

    @Column(name = "accountable")
    private String accountable;

    @Column(name = "collabrative")
    private String collabrative;

    @Column(name = "trust")
    private String trust;

    @Column(name = "impact")
    private String impact;

    @Column(name = "roles_understand")
    private String rolesUnderstand;

    @Column(name = "contribution")
    private String contribution;

    @Column(name = "missed_opportunity")
    private String missedOpportunity;

    @Column(name = "appreciation")
    private String appreciation;

    @Column(name = "help_anyone")
    private String helpAnyone;

    @Column(name = "traning")
    private String traning;

    @Column(name = "other")
    private String others;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appriasal_id")
    private int appriasalId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Employee employee;

    public String getInclusion() {
        return inclusion;
    }

    public void setInclusion(String inclusion) {
        this.inclusion = inclusion;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public String getPioneering() {
        return pioneering;
    }

    public void setPioneering(String pioneering) {
        this.pioneering = pioneering;
    }

    public String getAccountable() {
        return accountable;
    }

    public void setAccountable(String accountable) {
        this.accountable = accountable;
    }

    public String getCollabrative() {
        return collabrative;
    }

    public void setCollabrative(String collabrative) {
        this.collabrative = collabrative;
    }

    public String getTrust() {
        return trust;
    }

    public void setTrust(String trust) {
        this.trust = trust;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getRolesUnderstand() {
        return rolesUnderstand;
    }

    public void setRolesUnderstand(String rolesUnderstand) {
        this.rolesUnderstand = rolesUnderstand;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public String getMissedOpportunity() {
        return missedOpportunity;
    }

    public void setMissedOpportunity(String missedOpportunity) {
        this.missedOpportunity = missedOpportunity;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public String getHelpAnyone() {
        return helpAnyone;
    }

    public void setHelpAnyone(String helpAnyone) {
        this.helpAnyone = helpAnyone;
    }

    public String getTraning() {
        return traning;
    }

    public void setTraning(String traning) {
        this.traning = traning;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public int getAppriasalId() {
        return appriasalId;
    }

    public void setAppriasalId(int appriasalId) {
        this.appriasalId = appriasalId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
