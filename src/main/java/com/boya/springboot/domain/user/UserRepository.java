package com.boya.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); //  Optional은 값이 없는 경우를 표현하기 위한 클래스
                                              //email 통해 신규 가입 여부 판단
}
