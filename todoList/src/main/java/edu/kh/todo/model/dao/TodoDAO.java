package edu.kh.todo.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.todo.model.mapper.TodoMapper;

@Repository // DAO 계층 역할 명시 + Bean 등록
public class TodoDAO {

	// TodoMapper 인터페이스를 상송받은 자식 객체
	// 그 자식 객체가 sqlSessionTemplate 이용
	@Autowired
	private TodoMapper mapper;
		
	
	/** (TSET) todoNo가 1인 할 일 제목 조회
	 * @return title
	 */
	public String testTitle() {
		// TODO Auto-generated method stub
		return mapper.testTitle();
	}

}
