package com.demographql.dtos;

public class UserDTO {
    private Long id;
    private String userName;
    private String password;

    public UserDTO(Long id,String userName){
        this.id = id;
        this.userName = userName;
    }

    public UserDTO() {

    }

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
