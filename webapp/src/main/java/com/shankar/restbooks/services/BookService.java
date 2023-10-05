package com.shankar.restbooks.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.shankar.restbooks.model.Book;

@Component
public class BookService {

    private static List<Book>list=new ArrayList();
    
   static{
           list.add(new Book(12,"python", "xyz"));
           list.add(new Book(36,"Kotlin", "ABC"));
           list.add(new Book(48, "typescript", "LMN"));
    }

    public List<Book> getAllBooks(){
        return list;
    }

    public Book getBookById(int id){
        Book book = null;
        book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;
    }

    public Book addBook(Book b){
        list.add(b);
        return b;
    }

    public void deleteBook(int bid){
        list=list.stream().filter(book ->book.getId()!=bid).collect(Collectors.toList());
    }
    
    public void updateBook(Book book, int bookId)
    {
       list = list.stream().map(b->{

        if(b.getId()==bookId){
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
        }
        return b;
        }).collect(Collectors.toList());
    }

    
    
}
