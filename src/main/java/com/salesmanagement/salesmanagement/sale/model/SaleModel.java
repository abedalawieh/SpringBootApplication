package com.salesmanagement.salesmanagement.sale.model;

import com.salesmanagement.salesmanagement.client.model.ClientModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name ="sales")
public class SaleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "creation_date", nullable = false)

    private LocalDateTime creationDate;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientModel client;
    @Column(nullable = false)

    private String seller;
    @Column(nullable = false)

    private Double total;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)

    private Set<SaleDetailModel> saleDetails = new HashSet<>();



    public SaleModel(LocalDateTime creationDate, ClientModel client, String seller, Double total) {
        this.creationDate = creationDate;
        this.client = client;
        this.seller = seller;
        this.total = total;
    }

    public SaleModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<SaleDetailModel> getSaleDetails() {
        return saleDetails;
    }

    public void setSaleDetails(Set<SaleDetailModel> saleDetails) {
        this.saleDetails = saleDetails;
    }

    public void addSaleDetail(SaleDetailModel saleDetail) {
        saleDetails.add(saleDetail);
        saleDetail.setSale(this);
    }

    public void removeSaleDetail(SaleDetailModel saleDetail) {
        saleDetails.remove(saleDetail);
        saleDetail.setSale(null);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", client=" + client +
                ", seller='" + seller + '\'' +
                ", total=" + total +
                '}';
    }

}
