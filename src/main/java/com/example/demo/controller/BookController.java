package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    //显示所有数据
    @GetMapping("/index")
    public String showIndex(Model model){
        List<Book> findAll = bookService.findAll();
        model.addAttribute("listall",findAll);
        return "index";
    }

    //跳转到主界面
    @GetMapping("/indexPage")
    public String indexPage(){
        return "index";
    }
    //跳转到添加页面
    @GetMapping("/add")
    public String addPage(){
        return "book/addBook";
    }
    //跳转到修改页面
    @GetMapping("/update")
    public String updatePage(){
        return "book/updateBook";
    }

    @PostMapping
    public String addBook(@RequestBody Book book){
        Book saveBook = bookRepository.save(book);
        return"添加的数据为"+ saveBook.toString();
    }
}
