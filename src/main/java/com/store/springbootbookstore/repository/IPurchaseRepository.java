package com.store.springbootbookstore.repository;

import com.store.springbootbookstore.model.PurchaseHistory;
import com.store.springbootbookstore.repository.projections.IPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPurchaseRepository extends JpaRepository<PurchaseHistory, Long> {

    @Query("select " +
            "u.username as username, b.title as title, ph.price as price, ph.purchaseTime as purchaseTime " +
    " from PurchaseHistory as ph left join Book b on ph.bookId = b.id left join User u on u.id = ph.bookId " +
    "where ph.userId = :userId")
    List<IPurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);
}
