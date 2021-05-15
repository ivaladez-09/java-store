package com.store.api.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "purchase_product")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PurchaseProduct implements Serializable {

    @EmbeddedId
    private PurchaseProductPk id;

    private Integer quantity;
    private Float total;
    private Boolean status;

    @ManyToOne
    @MapsId("idPurchase")
    @JoinColumn(name = "id_purchase", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;

    public PurchaseProductPk getId() {
        return id;
    }

    public void setId(PurchaseProductPk id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
