package com.example.clientui.client;

import com.example.clientui.beans.BookBean;
import com.example.clientui.beans.CopyBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "library-book", url = "http://localhost:9001/")
//@RibbonClient(name = "library-book")
public interface LibraryBookClient {

    @GetMapping(value = "/books")
    @PreAuthorize("hasAuthority('USER')")
    List<BookBean> listBooks();

    @GetMapping(value = "/books/{id}")
    @PreAuthorize("hasAuthority('USER')")
    BookBean displayBook(@PathVariable int id);

    @GetMapping(value = "/copies/{book}")
    @PreAuthorize("hasAuthority('USER')")
    List<CopyBean> listCopies(@PathVariable int book);

    @GetMapping(value = "/copy/{id}")
    @PreAuthorize("hasAuthority('USER')")
    CopyBean selectCopy(@PathVariable int id);


    @GetMapping(value = "/books/search/page/{pageNo}")
    @PreAuthorize("hasAuthority('USER')")
    List<BookBean> getBooks(@PathVariable(value = "pageNo") int pageNo,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
                            @RequestParam(value = "word", required = false, defaultValue = "") String word);

    @GetMapping("/books/page/{pageNo}")
    @PreAuthorize("hasAuthority('USER')")
    List<BookBean> findBooksPaginated(@PathVariable(value = "pageNo") int pageNo,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize);

    @GetMapping("/books/search")
    @PreAuthorize("hasAuthority('USER')")
    List<BookBean> searchBooks(@RequestParam(value = "word", required = false, defaultValue = "") String word);
}
