package com.wenwei.stock.dbservice.repository;


import com.wenwei.stock.dbservice.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author:zhou_wenwei
 * mail:
 * date:2017/12/18
 * description:
 */
public interface QuotesRepository extends JpaRepository<Quote,Integer>{
    List<Quote> findByUserName(String name);
}
