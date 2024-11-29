package edu.uptc.parcialwebdilan.entityes;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_venta")
public class detailSale {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double subtotal;

    // Relación muchos a uno con Sale
    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private sale sale;

    // Relación muchos a uno con Product
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private product product;

    // Constructores
    public detailSale() {}

    public detailSale(Long id, Integer quantity, Double subtotal, sale sale, product product) {
        this.id = id;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.sale = sale;
        this.product = product;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public sale getSale() {
        return sale;
    }

    public void setSale(sale sale) {
        this.sale = sale;
    }

    public product getProduct() {
        return product;
    }

    public void setProduct(product product) {
        this.product = product;
    }
}
