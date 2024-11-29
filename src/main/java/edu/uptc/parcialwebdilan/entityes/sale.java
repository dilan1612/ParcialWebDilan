package edu.uptc.parcialwebdilan.entityes;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sale")
public class sale {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double total;

    // Relación muchos a uno con Customer
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private customer customer;

    public sale() {}

    public sale(Long id, LocalDate date, Double total, customer customer) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.customer = customer;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public customer getCustomer() {
        return customer;
    }

    public void setCustomer(customer customer) {
        this.customer = customer;
    }
}
