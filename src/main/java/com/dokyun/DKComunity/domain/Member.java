package com.dokyun.DKComunity.domain;

import com.dokyun.DKComunity.util.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Members")
@Getter @Setter
@NoArgsConstructor
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

    @Builder
    public Member (String nickName, String password, String email){
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }

}
