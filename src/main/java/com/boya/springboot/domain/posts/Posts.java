package com.boya.springboot.domain.posts;

import com.boya.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter // Lombok annotation
@NoArgsConstructor // Lombok annotation , 기본 생성자 자동 추가
@Entity // JPA annotation , 테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {

    /* Posts 클래스는 DB 테이블과 매칭될 클래스로 Entity 클래스라고도 함
       JPA 사용 시 DB 데이터에 작업할 경우 쿼리를 사용하지 않고 Entity 클래스의 수정을 통해 작업함
       여기서 Setter 메소드는 절대 만들지 않음  */

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성규칙
    private Long id;

    @Column(length = 500, nullable = false) // 컬럼을 뜻하며 굳이 선언하지 않아도 됨. 컬럼 기본값 변경이 필요한 경우에 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;


    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
