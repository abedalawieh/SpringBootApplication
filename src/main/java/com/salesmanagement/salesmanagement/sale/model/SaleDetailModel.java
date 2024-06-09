package com.salesmanagement.salesmanagement.sale.model;

import com.salesmanagement.salesmanagement.product.model.ProductModel;
import jakarta.persistence.*;

@Entity
@Table(name = "sale_details")
public class SaleDetailModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private SaleModel sale;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductModel product;
    @Column(nullable = false)

    private Integer quantity;
    @Column(nullable = false)

    private Double price;



    public SaleDetailModel(SaleModel sale, ProductModel product, Integer quantity, Double price) {
        this.sale = sale;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public SaleDetailModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SaleModel getSale() {
        return sale;
    }

    public void setSale(SaleModel sale) {
        this.sale = sale;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
