package edu.kh.project.member.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MemberMapper {

	/** 로그인 SQL 실행
	 * @param memberEmail
	 * @return loginMember
	 */
	Member login(String memberEmail);

	/** 이메일 중복 검사
	 * @param memberEmail
	 * @return count
	 */
	int checkEmail(String memberEmail);

	/** memberNickname 중복검사
	 * @param memberNickname
	 * @return
	 */
	int checkNickname(String memberNickname);

	/** 회원 가입 SQL 실행
	 * @param inputMember
	 * @return result
	 */
	int signup(Member inputMember);

	/** 회원 전체 정보 조회
	 * @return
	 */
	List<Member> memberSelect();

	/** 회원 비밀번호 리셋
	 * @param encPw
	 * @return 1 or 2
	 */
	int pwReset(Member member);

	/** 회원 탈퇴 여부 확인하기
	 * @param memberNo
	 * @return
	 */
	int memberCheckDelN(int memberNo);

	/** 회원 탈퇴 신청 취소하기
	 * @param memberNo
	 * @return
	 */
	int delReset(int memberNo);
}
