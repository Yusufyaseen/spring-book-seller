package com.store.springbootbookstore.repository.projections;

import java.time.LocalDateTime;

public interface IPurchaseItem {
    String getUsername();
    String getTitle();
    Double getPrice();
    LocalDateTime getPurchaseTime();
}
