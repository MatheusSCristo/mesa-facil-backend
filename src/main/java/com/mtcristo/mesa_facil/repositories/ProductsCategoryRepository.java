package com.mtcristo.mesa_facil.repositories;

import com.mtcristo.mesa_facil.models.ProductsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsCategoryRepository extends JpaRepository<ProductsCategory,String> {
}
