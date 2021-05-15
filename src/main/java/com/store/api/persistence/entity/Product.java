package com.store.api.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProduct")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;

    @Column(name = "id_category")
    private Integer idCategory;

    private String name;
    private Float price;
    private Integer stock;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_category", insertable = false, updatable = false)
    private Category category;

    // Avoid bi-directional relationship but keep one-way relationship
    //@OneToMany(mappedBy = "purchase", cascade = {CascadeType.ALL})
    //private List<PurchaseProduct> purchases;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /*public List<PurchaseProduct> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseProduct> purchases) {
        this.purchases = purchases;
    }*/
}
