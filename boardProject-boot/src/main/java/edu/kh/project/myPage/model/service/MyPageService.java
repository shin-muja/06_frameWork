package edu.kh.project.myPage.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.dto.UploadFile;

public interface MyPageService {

	/** 회원 정보 수정
	 * @param loginMember
	 * @param memberAddress
	 * @return result
	 */
	int updateInfo(Member inputMember, String[] memberAddress);

	/** 현재 비밀번호 확인
	 * @param string
	 * @return result = 1 or 0
	 */
	boolean checkCurrentPw(int memberNo,String currentPw);

	/** 비밀번호 번경
	 * @param memberNo
	 * @param string
	 * @return
	 */
	int changePw(Member changeMember);

	/** 회원 탈퇴
	 * @param memberPw
	 * @param memberNo
	 * @return reuslt
	 */
	int secession(String memberPw, int memberNo);

	/** 파일 업로드 테스트 1
	 * @param uploadFile
	 * @return path
	 */
	String fileUpload1(MultipartFile uploadFile) throws Exception;

	/** 파일 업로드 테스트2 ( +DB)
	 * @param memberNo
	 * @param uploadFile
	 * @return
	 */
	int fileUpload2(int memberNo, MultipartFile uploadFile) throws Exception;

	/** 파일 목록 조회
	 * @param memberNo
	 * @return list
	 */
	List<UploadFile> fileList(int memberNo);

	/** 여러 파일 업로드 서비스
	 * @param aaaList
	 * @param bbbList
	 * @param memberNo
	 * @return
	 */
	int fileUpload3(List<MultipartFile> aaaList, List<MultipartFile> bbbList, int memberNo) throws Exception;

	/** 프로필 이미지 수정 서비스
	 * @param profileImg
	 * @param loginMember
	 * @return
	 */
	int profile(MultipartFile profileImg, Member loginMember) throws Exception;

}
