package edu.uptc.parcialwebdilan.entityes;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="customer")
public class customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 40)
    private String name;
    @Column(nullable = false, length = 30)
    private String mail;
    @Column
    private Long phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<sale> sales;

    public customer() {
    }

    public customer(Long id, String name, String mail, Long phone) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public List<sale> getSales() {
        return sales;
    }

    public void setSales(List<sale> sales) {
        this.sales = sales;
    }
}
