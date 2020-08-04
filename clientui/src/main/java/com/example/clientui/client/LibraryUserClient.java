package com.example.clientui.client;

import com.example.clientui.beans.UserBean;
import com.example.clientui.beans.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "library-user", url = "http://localhost:9003/")
public interface LibraryUserClient {

    @GetMapping(value = "/account/{id}")
    UserBean selectAccount(@PathVariable int id);

    @GetMapping(value = "/principal/{username}")
    UserBean findUsername(@PathVariable String username);

}
