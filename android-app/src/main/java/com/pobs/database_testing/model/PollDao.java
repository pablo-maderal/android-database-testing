package com.pobs.database_testing.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollDao {

    @Autowired
    private PollRepository repository;
    private int a;
    private int b;
    private int c;



    public Poll increment_col_a(){
        Poll poll = repository.findById(1).get();
        a= poll.getCol_a() + 1;
        poll.setCol_a(a);
       return repository.save(poll);
    }

    public Poll increment_col_b(){
        Poll poll = repository.findById(1).get();
        b= poll.getCol_b() + 1;
        poll.setCol_b(b);
        return repository.save(poll);
    }

    public Poll increment_col_c(){
        Poll poll = repository.findById(1).get();
        c= poll.getCol_c() + 1;
        poll.setCol_c(c);
       return repository.save(poll);
    }

    //
    public Poll testConnection(){
        Poll poll = repository.findById(1).get();
        return poll;
    }

}
