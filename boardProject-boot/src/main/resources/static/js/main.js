// 쿠키에 저장된 이메일 input 창에 뿌려놓기
// 로그인 이 안된 경우에 수행

// 쿠키에서 매게변수로 전달받은 key가 일치하는 value 얻어오기 함수
const getCookie = key => {
  
  const cookies = document.cookie; // "k=v; k=v; k=v;.....; k=v"
  
  // saveId=member01@kh.or.kr; testId=test01@test.com

  const cookieList = cookies.split("; ") // ['saveId', 'member01@kh.or.kr'] ['testId', 'test01@test.com']
                    .map( el => el.split("="));

  // 배열.map(함수) : 배열의 각 요소를 이용해 함수 수행 후
  //                  결과 값으로 새로운 배열을 만들어서 반환
  // 배열 -> 객체로 변환(그래야 다루기 쉽다)
  
  // console.log(cookieList); // ['saveId', 'member01@kh.or.kr'] ['testId', 'test01@test.com']

  const obj = {}; // 비어있는 객체 선언

  for(let i = 0 ; i < cookieList.length ; i++ ) {
    const k = cookieList[i][0]; // key 값
    const v = cookieList[i][1]; // value 값
    obj[k] = v; // 객체에 추가
    // obj["saveId"] = "member01@kh.or.kr";
    // obj["testId"] = "test01@test.com";
  }
  
  // console.log(obj); {saveId: 'member01@kh.or.kr', testId: 'test01@test.com'}
  return obj[key]; // 매개변수로 전달받은 key와
                   // obj 객체에 저장된 key가 일치하는 요소의 value값 반환
};

// 이메일 작성 input 태그 요소
const loginEmail = document.querySelector("#loginForm input[name='memberEmail']");  // 이메일 input 태그

if(loginEmail != null ) { // 로그인 창의 이메일 input 태그가 화면에 존재할 때
  
  // 쿠키 중 key 값이 "saveId"인 요소의 value 얻어오기
  const saveId = getCookie("saveId"); // 이메일 또는 indefined

  // saveId 값이 있을 경우
  if( saveId != undefined) {
    loginEmail.value = saveId; // 쿠키에서 얻어온 input 값을 input 요소의 value에 세팅
    // 아이디 저장 테크박스에 체크해두기
    document.querySelector("input[name='saveId']").checked=true;
  }

}






// 이메일, 비밀번호 미작성 시 로그인 막기
const loginForm = document.querySelector("#loginForm");                             // form태그
const loginPw = document.querySelector("#loginForm input[name='memberPw']");        // 비밀번호 input 태그

// #loginForm 이 화면에 존재할 때 (== 로그인 상태 아닐 때)
// -> 타임리프에 의해 로그인 되었다면 #loginFrom 요소는 화면에 노출되지 않음
// -> 로그인 상태일 때 loginForm을 이용한 코드가 수행된다면
// -> 콘솔창에 error 발생

if(loginForm != null ) {

  // 제출 이벤트 발생 시
  loginForm.addEventListener("submit", e=> {
    
    // 이메일 미작성
    if( loginEmail.value.trim().length === 0 ) {
      alert("이메일을 작성해주세요");
      e.preventDefault(); // 기본 이벤트 (제출) 막기
      loginEmail.focus(); // 초점 이동
      return;
    }

    // 비밀번호 미작성
    if( loginPw.value.trim().length === 0 ) {
      alert("비밀번호를 작성해주세요");
      e.preventDefault(); // 기본 이벤트 (제출) 막기
      loginEmail.focus(); // 초점 이동
      return;
    }
  });

}




// ---------------------------------------------------------------------

const selectMemberList =document.querySelector("#selectMemberList");  // 회원 목록 조회 버튼
const resetPw = document.querySelector("#resetPw");                   // 비밀번호 초기화버튼
const restorationBtn = document.querySelector("#restorationBtn");     // 회원탈퇴 복구하기

// 조회 후 보여줄 테이블 tbody ID
const memberListTbody = document.querySelector("#memberList");
// 비밀번호 리셋 회원번호 입력창
const resetMemberNo = document.querySelector("#resetMemberNo");
// 탈퇴 복구하기 회원번호 입력창
const restorationMemberNo = document.querySelector("#restorationMemberNo");


// 조회 클릭 시 회원정보 출력
selectMemberList.addEventListener("click", () => {

  fetch("/member/memberSelect")
  .then(resp => resp.json())
  .then(memberList1 => {

    memberList1.innerHTML = "";


    for( let member of memberList1) {
      // tr 태그 생성
      const tr = document.createElement("tr");
      const arr = ['memberNo', 'memberEmail', 'memberNickname', 'memberDelFl']

      for (let i of arr ) {
        // td 태그 생성
        const td = document.createElement("td");

        td.innerText = member[i];
        tr.append(td);
      }
      memberListTbody.append(tr);
    }


  });
});

// 비밀번호 초기화
resetPw.addEventListener("click", () => {

  // 빈칸 확인
  if(resetMemberNo.value.trim().length ==  0) {
    alert("회원번호를 입력해주세요");
    return;
  }

  // 숫자인지 확인
  if(isNaN(resetMemberNo.value)) {
    alert("회원번호는 숫자입니다.");
    resetMemberNo.value == "";
    return;
  }

  fetch("/member/pwReset", {
    method : "POST",
    headers : {"Content-Type" : "application/json"},
    body : resetMemberNo.value
  }).then(resp => resp.text())
  .then(result => {

    if( result == 1 ) {
      alert("비밀번호 초기화 성공");
    } else {
      alert("비밀번호 초기화 실패");
    }
  })
});

restorationBtn.addEventListener("click", () => {

  // 빈칸 확인
  if(restorationMemberNo.value.trim().length ==  0) {
    alert("회원번호를 입력해주세요");
    return;
  }

  // 숫자인지 확인
  if(isNaN(restorationMemberNo.value)) {
    alert("회원번호는 숫자입니다.");
    restorationMemberNo.value == "";
    return;
  }

  fetch("/member/delReset", {
    method : "POST",
    headers : {"Content-Type" : "application/json"},
    body : restorationMemberNo.value
  }).then(resp => resp.text() )
  .then(result => {

    if( result == 100) {
      alert("회원 탈퇴를 신청하지 않는 유저입니다");
    } else if( result == 1 ) {
      alert("회원 탈퇴 복구 성공");
    } else {
      alert("회원 탈퇴 복구 실패");
    }
  });
});