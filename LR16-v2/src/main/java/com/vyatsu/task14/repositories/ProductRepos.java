package com.vyatsu.task14.repositories;

import com.vyatsu.task14.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepos extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>{

    @Query("select pr from Product pr where pr.title = :title")
    Product findByName(@Param("title") String title);

    @Query("update Product pr set pr.title = :title, pr.price = :price where pr.id = :id")
    void updateById(@Param("title") String title, @Param("price") int price, @Param("id") Long id);

}
