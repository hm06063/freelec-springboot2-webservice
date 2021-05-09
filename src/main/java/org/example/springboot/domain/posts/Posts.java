package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //클래스 내 모든 필드의 Getter 메소드 자동 생성
@NoArgsConstructor //기본 생성자 자동 추가 -> public Posts(){}와 같은 효과
@Entity //테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {//실제 DB 테이블과 매칭될 클래스
    @Id //해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙을 나타냄. Generatn~ 저거해야 auto_increment 됨
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 컬럼을 나타냄. 기본값 외 추가로 변경 필요하면 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 크래스의 빌더 패턴 클래스 생성 -> 어느 필드에 어떤 값 채울지 명확히 인지 가능
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
    // @Entity는 JPA의 어노테이션, @Getter와 @NoArgsConstructor 롬복의 어노테이션.
    // Entity 클래스에는 절대 Setter 메소드를 만들지 않음.
    // -> 대신 필드값 변경 필요시 명확히 목적과 의도를 나타낼 수 있는 메소드를 추가
}
