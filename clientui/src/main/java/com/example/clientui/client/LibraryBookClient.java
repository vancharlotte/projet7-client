package com.example.clientui.client;

import com.example.clientui.beans.BookBean;
import com.example.clientui.beans.CopyBean;
import feign.Headers;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "library-book", url = "http://localhost:9001/")
//@RibbonClient(name = "library-book")
public interface LibraryBookClient {

    @GetMapping(value = "/books")
    List<BookBean> listBooks();

    @GetMapping(value = "/books/{id}")
    BookBean displayBook(@PathVariable int id);

    @GetMapping(value = "/copies/{book}")
    List<CopyBean> listCopies(@PathVariable int book);

    @GetMapping(value = "/copy/{id}")
    CopyBean selectCopy(@PathVariable int id);

   /* @GetMapping(value="/library-book/books/search/{word}")
    List<BookBean> searchBooks(@PathVariable("word") String word);*/

    @GetMapping(value = "/books/search")
    List<BookBean> getBooks(@RequestParam(value = "title", required = false, defaultValue = "") String title);

}
