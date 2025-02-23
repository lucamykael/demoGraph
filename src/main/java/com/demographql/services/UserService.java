package com.demographql.services;

import com.demographql.dtos.UserDTO;
import com.demographql.entities.User;
import com.demographql.filters.UserFilter;
import com.demographql.repositories.UserRepository;
import graphql.schema.DataFetchingEnvironment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @PersistenceContext
    private EntityManager em;

    public Collection<UserDTO> getUser(Long id) {

//        Pageable pageable = createPageable(environment);
        Example<User> example = createExample(id);

        return repository.findAll(example).stream().map(this::convertToDTO).toList();
    }

    public User createUser(User user){
        return repository.save(user);
    }

    private Example<User> createExample(Long id){

        User users = new User();

        users.setId(id);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        return Example.of(users, matcher);
    }

    private Pageable createPageable(DataFetchingEnvironment env){

        UserFilter filter = env.getArgument("filter");

        int page = Optional.ofNullable(env.getArgument("page"))
                .map(p -> Integer.valueOf(p.toString()))
                .orElse(0);

        int size = Optional.ofNullable(env.getArgument("size"))
                .map(s -> Integer.valueOf(s.toString()))
                .orElse(20);

        return PageRequest.of(page, size, Sort.by("id").ascending());
    }

    private UserDTO convertToDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getUserName()
        );
    }
}
