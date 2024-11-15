package edu.kh.project.myPage.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.dto.UploadFile;

@Mapper
public interface MyPageMapper {

	/** 회원 정보 수정
	 * @param inputMember
	 * @return 1 or 0
	 */
	int updateInfo(Member inputMember);

	/** 현재 비밀번호 꺼내오기
	 * @param memberPw
	 * @return
	 */
	String checkCurrentPw(int memberNo);

	/** 비밀번호 변경
	 * @param memberNo
	 * @param newPw
	 * @return
	 */
	int changePw(Member changeMember);

	/** 회원 탈퇴
	 * @param memberNo
	 * @return
	 */
	int secession(int memberNo);

	/** 파일 정보를 DB에 삽입
	 * @param uf
	 * @return
	 */
	int insertUploadFile(UploadFile uf);

	/** 파일 목록 조회
	 * @param memberNo
	 * @return list
	 */
	List<UploadFile> fileList(int memberNo);

	/** 프로필 이미지 변경
	 * @param mem
	 * @return
	 */
	int profile(Member mem);

}
