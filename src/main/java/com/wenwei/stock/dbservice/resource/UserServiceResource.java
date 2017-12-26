package com.wenwei.stock.dbservice.resource;


import com.wenwei.stock.dbservice.model.Quote;
import com.wenwei.stock.dbservice.model.Quotes;
import com.wenwei.stock.dbservice.model.UserModel;
import com.wenwei.stock.dbservice.repository.QuotesRepository;
import com.wenwei.stock.dbservice.repository.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * author:zhou_wenwei
 * mail:
 * date:2017/12/18
 * description:
 */
@RestController
@RequestMapping("/rest")
public class UserServiceResource {
//    @Autowired
//    private UserRepository userRepository;
//    @GetMapping("/{userName}")
//    public User getUser(@PathVariable("userName") final String name){
//        return userRepository.findByUserName(name);
//    }
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user")
    public User getUser(@PathVariable final String userName){
       return userRepository.findByUserName(userName);
    }
    @PostMapping("/user")
    public UserModel addUser(@RequestBody final UserModel user){
        if(user.equals(null)){
            return user;
        }
        if(StringUtils.isBlank(user.getId())){
            user.setId(UUID.randomUUID().toString());
        }
        return userRepository.save(user);
    }
}
