package com.demographql.controllers;

import com.demographql.dtos.UserDTO;
import com.demographql.entities.User;
import com.demographql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class UserController {

    @Autowired
    UserService service;

//    @SchemaMapping(typeName = "Query", value = "findUsersBy")
    @QueryMapping
    public Collection<UserDTO> findUsersBy(@Argument Long id) throws Exception {
        return service.getUser(id);
    }

    @MutationMapping
    public User createUser(@Argument String userName, @Argument String password) throws Exception {
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);

            return service.createUser(user);
    }
}
