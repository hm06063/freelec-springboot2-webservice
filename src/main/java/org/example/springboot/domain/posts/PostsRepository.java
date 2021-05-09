package org.example.springboot.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// MyBatis에선 Dao라ㄴ고 불리는 DB layer 접근자를 사용하는데 JPA에선 Repository라고 부르며 인터페이스로 생성
// -> 인터페이스 생성 후 JpaRepository<Entity클래스, PK타입>을 상속하면 기본 CRUD 메소드가 자동으로 생성됨
// ** Entity 클래스와 기본 ENtity Repository는 함께 위치해야 함.
public interface PostsRepository extends JpaRepository<Posts,Long>{
    @Query(value = "SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
