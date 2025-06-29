package com.pan.controller;

import cn.dev33.satoken.util.SaResult;
import com.pan.service.BookServiceImpl;
import com.pan.uitils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin
@RestController
public class BookController {


    @Autowired    //按名字精确指定注入哪个Bean	（必须配合 @Autowired）
    //    @Qualifier	按类型注入Bean	（可以独立使用）
    BookServiceImpl bookService;

    @RequestMapping(value = "/bookAdd", method = RequestMethod.POST)
    public String bookAdd(@RequestParam String bookName, @RequestParam String bookIsbn, @RequestParam BigDecimal bookPrice, @RequestParam String bookWriter) {
        try {
            bookService.adddBooks(bookName, bookIsbn, bookPrice, bookWriter);
            return Result.getMassage(Result.OK, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.getMassage(Result.SERVRERROR, "服务器异常");
        }

    }

    @RequestMapping(value = "/bookDel/{id}", method = RequestMethod.DELETE)
    public String bookDel(@PathVariable String bookId) {
        try {
            bookService.deleteBook(bookId);
            return Result.getMassage(Result.OK, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.getMassage(Result.SERVRERROR, "服务器异常");
        }

    }


}
