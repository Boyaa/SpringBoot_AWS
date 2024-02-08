package com.boya.springboot.web.dto;

import com.boya.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

        private Long id;
        private String title;
        private String content;
        private String author;

        public PostsResponseDto(Posts entity) { // Entity 필드 중 일부만 사용하므로 생성자로 받아서 필드에 값 넣음
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.content = entity.getContent();
            this.author = entity.getAuthor();
        }
}
