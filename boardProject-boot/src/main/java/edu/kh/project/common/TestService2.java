package edu.kh.project.common;

import org.springframework.stereotype.Service;

// 실제 서비스를 가져와서 수행하면됨(여기서는 샘플용으로 만들어봄)
@Service
public class TestService2 {

	public int checkZero() {
		return 0;
	}

	public int divide(int a, int b) {
		
		if(b == 0) throw new IllegalArgumentException("0으로 나눌 수 없음");
		
		return a / b;
	}
}
