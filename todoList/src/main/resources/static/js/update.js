document.querySelector("#updateForm").addEventListener("submit", e => {

  // todoTitle의 길이 가져오기
  let todoTitleLength = document.querySelector("#todoTitle").value.trim().length;

  // todoTitle의 길이가 0 일시 제목을 입력하라는 알림창과 함께 submit 이벤트 막기
  if( todoTitleLength === 0 ) {
    alert("제목을 입력해주세요(공백제외)");
    e.preventDefault();
  }

});