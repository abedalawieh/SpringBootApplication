package com.salesmanagement.salesmanagement.sale.repository;

import com.salesmanagement.salesmanagement.sale.model.SaleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<SaleModel, Long> {
}
