package com.example.clientui.client;

import com.example.clientui.beans.AccountBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "auth-server", url = "http://localhost:9191/")
//@RibbonClient(name = "auth-server")
public interface LibraryAccountClient {

    @GetMapping(value = "/account/{id}")
    AccountBean selectAccount(@PathVariable int id);

    @GetMapping(value = "/principal/{username}")
    AccountBean findUsername(@PathVariable String username);


}
