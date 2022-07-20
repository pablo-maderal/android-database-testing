package com.pobs.database_testing.controller;


import com.pobs.database_testing.model.Poll;
import com.pobs.database_testing.model.PollDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollController {

    @Autowired
    private PollDao pollDao;




    @PostMapping("/poll/increment_a")
    public Poll increment_a(){
       return pollDao.increment_col_a();
    }

    @PostMapping("/poll/increment_b")
    public Poll increment_b(){
        return pollDao.increment_col_b();
    }

    @PostMapping("/poll/increment_c")
    public Poll increment_c(){
        return pollDao.increment_col_c();
    }

    @GetMapping("/poll/testDB")
    public Poll testConnection(){return pollDao.testConnection();}
}
