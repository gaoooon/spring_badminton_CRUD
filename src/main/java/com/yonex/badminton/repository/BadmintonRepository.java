package com.yonex.badminton.repository;

import com.yonex.badminton.entity.BadmintonEntity;

import org.springframework.data.jpa.repository.JpaRepository;

// 인터페이스에 JPARepository를 상속받으면 스프링에서 자동으로 데이터 접근에 대한 함수들(JPARepositor)을 다 구현해서 클래스르 빈으로 등록해둠
// -> BadmintonRepository이 타입으로 DI 받을 수 있음

public interface BadmintonRepository extends JpaRepository<BadmintonEntity, Long> {
}
