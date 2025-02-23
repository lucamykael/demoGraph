package com.demographql.filters;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserFilter {

    @Schema(description = "Id", example = "1")
    private Long id;

    @Schema(description = "Username", example = "lucas")
    private String userName;

    @Schema
    private String password;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
