package com.shoppingmallserver.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignRequest {

    private Long id;

    private String account;

    private String password;

    private String name;

    private String phone;

    private String address;

}