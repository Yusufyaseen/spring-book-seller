package com.store.springbootbookstore.service;

import com.store.springbootbookstore.model.PurchaseHistory;
import com.store.springbootbookstore.repository.projections.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory ph);

    List<IPurchaseItem> findAllPurchasesOfUser(Long id);

}
