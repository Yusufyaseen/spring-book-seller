package com.store.springbootbookstore.service;

import com.store.springbootbookstore.model.PurchaseHistory;
import com.store.springbootbookstore.repository.IPurchaseRepository;
import com.store.springbootbookstore.repository.projections.IPurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService {
    @Autowired
    private IPurchaseRepository purchaseRepository;

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory ph){
        ph.setPurchaseTime(LocalDateTime.now());
        return purchaseRepository.save(ph);
    }

    @Override
    public List<IPurchaseItem> findAllPurchasesOfUser(Long id){
        return purchaseRepository.findAllPurchasesOfUser(id);
    }

}
