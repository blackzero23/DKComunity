package com.dokyun.DKComunity.dto.post;

import com.dokyun.DKComunity.domain.PostComments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class PostCommentInfoDto {
    private Long postId;
    private Long postCommentId;
    private Long memberId;
    private String content;
    private String nickName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostCommentInfoDto(PostComments savedPostComments) {
        this.postId = savedPostComments.getPosts().getId();
        this.postCommentId = savedPostComments.getId();
        this.memberId = savedPostComments.getMember().getId();
        this.content = savedPostComments.getContent();
        this.nickName = savedPostComments.getMember().getNickName();
        this.createdAt = savedPostComments.getCreateAt();
        this.modifiedAt = savedPostComments.getModifiedAt();
    }
}
