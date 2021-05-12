package com.store.api.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "purchase_product")
public class PurchaseProduct {

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
}
