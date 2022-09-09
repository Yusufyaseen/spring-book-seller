package com.store.springbootbookstore.controllers;
import com.store.springbootbookstore.Security.UserPrinciples;
import com.store.springbootbookstore.model.PurchaseHistory;
import com.store.springbootbookstore.service.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase-history")
public class PurchaseHistoryController {

    @Autowired
    private IPurchaseHistoryService purchaseHistoryService;

    @PostMapping()
    public ResponseEntity<?> savePurchase(@RequestBody PurchaseHistory purchaseHistory) throws Exception{
        try {
            return new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory), HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllPurchasesOfAUser(@AuthenticationPrincipal UserPrinciples userPrinciples) throws Exception{
        try {
return new ResponseEntity<>(purchaseHistoryService.findAllPurchasesOfUser(userPrinciples.getId()),HttpStatus.OK);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
