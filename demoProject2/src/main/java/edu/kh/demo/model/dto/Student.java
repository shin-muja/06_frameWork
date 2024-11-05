package edu.kh.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Spring EL 같은 경우 DTO 객체 출력할 때 getter가 필수 작성 되어야 함
// -> ${Student.getName()} == ${Student.name}
// getter 대신 필드면 호출하는 형식으로 EL에 작성을 하게 되는데
// 자동으로 getter 메서드를 호출하기 때문

@Getter
@Setter
@ToString
@NoArgsConstructor	// 기본생성자
@AllArgsConstructor	// 모든 필드 초기화용 매개변수 생성자
public class Student {
	private String studentNo; 	// 학생번호
	private String name;		// 이름
	private int age;			// 나이
}
