package edu.kh.project.myPage.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Transactional(rollbackFor=Exception.class) // 모든 예외 발생 시 롤백 / 아니면 커밋
@Service
@RequiredArgsConstructor
@Slf4j
public class MyPageServiceImpl implements MyPageService{
	
	private final MyPageMapper mapper;
	
	@Override
	public int updateInfo(Member inputMember, String[] memberAddress) {
		
		// 입력된 주소가 있을 경우
		// memberAddress를 A^^^B^^^C 형태로 가공
		
		
		 if(inputMember.getMemberAddress().equals(",,")) {
		 	inputMember.setMemberAddress(null);
		 } else {
		 	String address = String.join("^^^", memberAddress);
		 	inputMember.setMemberAddress(address);
		 }
		 /*
		// 주소 구분자 처리 후 셋팅
		String address = String.join("^^^", memberAddress);
		if( address.replace("^^^", "").equals("")) address = null;
		inputMember.setMemberAddress(address);
		*/
		
		return mapper.updateInfo(inputMember);
	}
}
