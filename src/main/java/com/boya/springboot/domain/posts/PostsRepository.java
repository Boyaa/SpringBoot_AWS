package com.boya.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PostsRepository extends JpaRepository<Posts, Long> {

    /* 인터페이스 생성 후 JpaRepository<Entity 클래스, PK 타입> 상속하면 기본 CRUD 메소드 자동 생성
       Entity 클래스와 Entity Repository 는 함께 위치해야 한다.
     */
}
