package io.mateusrosecode.model;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DataBaseInit {

    @PostConstruct
    @Transactional
    public void loadData(){

    }
}
