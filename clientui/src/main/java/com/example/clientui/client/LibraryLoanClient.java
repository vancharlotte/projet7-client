package com.example.clientui.client;

import com.example.clientui.beans.LoanBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "library-loan", url = "http://localhost:9002/")
//@RibbonClient(name = "library-loan")
public interface LibraryLoanClient {

    @GetMapping(value="/loan/{id}")
   // @PreAuthorize("hasAuthority('USER')")
    LoanBean selectLoan(@PathVariable int id);

    @PostMapping(value = "/loan")
  //  @PreAuthorize("hasAuthority('USER')")
    ResponseEntity<Void> addLoan(@RequestBody LoanBean loan);

    @PutMapping(value = "/loan/renew")
  //  @PreAuthorize("hasAuthority('USER')")
    LoanBean renewLoan(@RequestBody LoanBean loan);

    @GetMapping(value = "/loans/{user}")
   // @PreAuthorize("hasAuthority('USER')")
    List<LoanBean> listLoans(@PathVariable int user);


    @GetMapping(value = "/books/copyAvailable{copy}")
   // @PreAuthorize("hasAuthority('USER')")
    boolean copyAvailable(@PathVariable int copy);

}