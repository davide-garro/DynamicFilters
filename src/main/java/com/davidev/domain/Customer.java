package com.davidev.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Access(AccessType.FIELD)
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Subscription subscription;

    private Long etag;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Status status, Subscription subscription) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.subscription = subscription;
    }

    @PrePersist
    public void createdAtAndEtagPrePersist(){
        this.createdAt = LocalDateTime.now();
        this.etag = 1L;
    }

    @PreUpdate
    public void updatedAtPreUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Status getStatus() {
        return status;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public Long getEtag() {
        return etag;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public void setEtag(Long etag) {
        this.etag = etag;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
