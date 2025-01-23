package edu.kh.project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Spring Boot 테스트를 실행하기 위한 어노테이션
// 스프링 애플리케이션 컨텍스트를 로드하고, 애플리케이션의 전체 환경을 테스트할 수 있게 해줌
// 컨텍스트 : 스프링 어플래케이션이 실행될 때 모든 모듈이나 객체들의 모음
@SpringBootTest
class BoardProjectBootApplicationTests2 {

	@Test
	void contextLoads() {
		// 애플리케이션 컨텍스트가 제대로 로드되는 지 확인하는 기본 테스트를 수행하는 메서드
		// BoardProjectBootApplicationTests 우클릭 후 run as - junit test
		System.out.println("어플리케이션 컨텍스트 로드 완료");
	}

}
