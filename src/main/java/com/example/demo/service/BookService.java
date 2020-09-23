package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    //获取数据库中的所有数据
    public Page<Book> findAll(@PageableDefault(page = 1,size = 2) Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
    //获取数据库中的对应数据
    public Book findById(Integer id){
        Optional<Book> optional = bookRepository.findById(id);
        Book book = optional.get();
        return new Book(book.getId(),book.getWorker(),book.getWorkName());
    }
    //添加、修改书籍信息
    public void addAndUpdateBook(Book book) {
        bookRepository.save(book);
    }
    public void delete(String id) {
        bookRepository.deleteById(Integer.valueOf(id));
    }
}
