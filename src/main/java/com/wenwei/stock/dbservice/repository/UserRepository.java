package com.wenwei.stock.dbservice.repository;


import com.wenwei.stock.dbservice.model.Quote;
import com.wenwei.stock.dbservice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author:zhou_wenwei
 * mail:
 * date:2017/12/18
 * description:
 */
public interface UserRepository extends JpaRepository<UserModel,Integer>{
    UserModel findByUserName(String name);
}
