package edu.kh.project.member.model.sevice;

import java.util.List;

import edu.kh.project.member.model.dto.Member;

public interface MemberService {

	/** 로그인 서비스
	 * 
	 * @param inputMember
	 * @return loginMember
	 */
	Member login(Member inputMember) throws Exception;

	/** 이메일 중복검사 서브스
	 * @param memberEmail
	 * @return
	 * @author 신동국
	 */
	int checkEmail(String memberEmail);
	
	/** memberNickname 중복 검사
	 * @param memberNickname
	 * @return
	 */
	int checkNickname(String memberNickname);

	/** 회원 가입 서비스
	 * @param inputMember
	 * @param memberAddress
	 * @return
	 */
	int signup(Member inputMember, String[] memberAddress);

	/** 회원 정보 가져오기
	 * @return
	 */
	List<Member> memberSelect();

	/** 회원 비밀번호 리셋
	 * @param memberNo
	 * @return 1 or 0
	 */
	int pwReset(int memberNo);

	/** 회원 가입 초기화
	 * @param memberNo
	 * @return 100 or 1 or 0
	 */
	int delReset(int memberNo);

}
