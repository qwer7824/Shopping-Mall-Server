package com.shoppingmallserver.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignResponse {

    private Long id;

    private String account;

    private String name;

    private String phone;

    private String address;

    private List<Authority> roles = new ArrayList<>();

    private String token;

    public SignResponse(Member member) {
        this.id = member.getId();
        this.account = member.getAccount();
        this.name = member.getName();
        this.phone = member.getPhone();
        this.address = member.getAddress();
        this.roles = member.getRoles();
    }
}