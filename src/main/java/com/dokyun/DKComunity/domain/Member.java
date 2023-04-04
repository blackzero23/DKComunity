package com.dokyun.DKComunity.domain;

import com.dokyun.DKComunity.util.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Members")
@Getter @Setter
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 100)
    private String nickName;
    @Column(nullable = false, length = 100)
    private String email;

    public static Member createMember(String password, String nickName, String email){
        Member member = new Member();
        member.setPassword(password);
        member.setNickName(nickName);
        member.setEmail(email);
        return member;
    }

    public static Member toEntity(Long id, String password, String nickName, String email){
        Member member = new Member();
        member.setId(id);
        member.setPassword(password);
        member.setNickName(nickName);
        member.setEmail(email);
        return member;
    }

}
