package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/book")
public class BookController {
    //注入相应注解
    @Autowired
    BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    //显示所有数据
    @GetMapping("/index")
    public String showIndex(@PageableDefault(page = 1,size = 2) Pageable pageable, Model model){
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber()-1, pageable.getPageSize());
        Page<Book> findAll = bookService.findAll(pageRequest);
        model.addAttribute("listall",findAll);
        return "/book/index";
    }

    //跳转到主界面
    @GetMapping("/indexPage")
    public String indexPage(){
        return "/book/index";
    }
    //跳转到添加页面

    @GetMapping("/add")
    public String addPage(){
        return "/book/addBook";
    }
    //跳转到修改页面,并将数据传给修改页面
    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") Integer id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        return "book/updateBook";
    }
    @PostMapping("/update")
    public String updateBook(Book book){
        bookService.addAndUpdateBook(book);
        return "redirect:/book/index";
    }

    //添加成功后重定向回主页面
    @PostMapping("/add")
    public String addBook(Book book){
        bookService.addAndUpdateBook(book);
        return "redirect:/book/index";
    }

    //删除后重定向回主页面
    @ResponseBody
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable String id){
        bookService.delete(id);
        return "success";
    }


}
