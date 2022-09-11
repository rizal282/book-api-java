package com.book.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    
    @Id // initial kolom id primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // buat auto increments
    private Long id;

    @NotEmpty(message = "Nama is required") // validasi
    @Column(name="book_name", length=100) // definisi nama kolom di table
    private String nama;

    @NotEmpty(message = "Description is required")
    @Column(name="book_description", length=500)
    private String description;

    private double price;

    // merelasikan entity table ke category
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    // merelasikan entity table ke supplier
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "book_supplier",
        joinColumns = @JoinColumn(columnDefinition = "book_id"),
        inverseJoinColumns = @JoinColumn(columnDefinition = "supplier_id")
    )
    private Set<Supplier> suppliers;

    public Book() {
    }

    public Book(Long id, String nama, String description, double price) {
        this.id = id;
        this.nama = nama;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    
}
