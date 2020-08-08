package com.example.clientui.client;

import com.example.clientui.beans.UserBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "library-user")
@FeignClient(name = "zuul-server")
@RibbonClient(name = "library-user")
public interface LibraryUserClient {

    @GetMapping(value = "/library-user/account/{id}")
    UserBean selectAccount(@PathVariable int id);

    @GetMapping(value = "/library-user/principal/{username}")
    UserBean findUsername(@PathVariable String username);

}
