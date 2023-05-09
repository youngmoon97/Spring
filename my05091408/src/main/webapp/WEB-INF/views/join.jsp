<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 참고 사이트 -->
<!-- https://github.com/mdbootstrap/bootstrap-login-form -->
<!DOCTYPE html>
<html lang="en" id="joinPage">
  <head>
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />

    <!-- 부트스트랩 링크 -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>

    <!-- Font Awesome -->
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.15.2/css/all.css"
    />

    <title>회원가입</title>
  </head>

  <body>
    <!-- Start your project here-->
    <section style="background-color: #508bfc; min-height: 100vh">
      <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-12 col-md-8 col-lg-6 col-xl-5">
            <div class="card shadow-2-strong" style="border-radius: 1rem">
              <div class="card-body p-5 text-center">
                <h3 class="mb-3">회원가입</h3>
                <div class="input-group mb-3">
                  <span id="idAddOn" class="input-group-text"> *아이디 </span>
                  <input
                    type="text"
                    id="id"
                    class="form-control"
                    aria-describedby="idAddOn"
                    autofocus
                  />
                </div>

                <div class="row">
                  <div class="col">
                    <div class="input-group mb-3">
                      <span id="pwAddOn" class="input-group-text">
                        *비밀번호
                      </span>
                      <input
                        type="password"
                        id="pw"
                        class="form-control"
                        aria-describedby="pwAddOn"
                      />
                    </div>
                  </div>
                  <div class="col">
                    <div class="input-group mb-3">
                      <span id="pw2AddOn" class="input-group-text">
                        *비번확인
                      </span>
                      <input
                        type="password"
                        id="pw2"
                        class="form-control"
                        aria-describedby="pw2AddOn"
                      />
                    </div>
                  </div>
                </div>
                <button
                  class="btn btn-primary"
                  type="button"
                  style="width: 100%"
                  onclick="requestJoin()"
                >
                  회원가입
                </button>
                <hr class="my-4" />

                <a href="/auth/login">아이디가 있으신가요? 로그인</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- End your project here-->
  </body>
  <!-- Custom scripts -->
  <script type="text/javascript">
    // 회원가입 요청
    // 회원가입 버튼을 누르면 실행되는 함수
    const requestJoin = () => {
      // 서버와 통신하기 전에 입력값 검증
      if (!validateFields()) {
        return;
      }

      // 유저 정보가 담긴 태그를 id로 가져옴
      const idElement = document.getElementById("id");
      const pwElement = document.getElementById("pw");
      const simpleDescElement = document.getElementById("simpleDesc");

      // 유저 정보를 객체로 만듬
      const user = {
        id: idElement.value,
        pw: pwElement.value,
      };

      //  rest 통신

    };

    // 유효성 검사 ( 아이디, 비밀번호 등 내용이 비어있는지 확인 )
    const validateFields = () => {
      // id 속성을 이용해서 해당하는 요소를 가져온다.
      const idElement = document.getElementById("id");
      const pwElement = document.getElementById("pw");
      const pw2Element = document.getElementById("pw2");

      // 값들이 비어있는지 확인
      if (idElement.value === "") {
        alert("아이디를 입력해주세요.");
        idElement.focus();
        return false;
      }

      if (pwElement.value === "") {
        alert("비밀번호를 입력해주세요.");
        pwElement.focus();
        return false;
      }

      if (pw2Element.value === "") {
        alert("비밀번호 확인을 입력해주세요.");
        pw2Element.focus();
        return false;
      }

      if (pwElement.value !== pw2Element.value) {
        alert("비밀번호가 일치하지 않습니다.");
        pw2Element.focus();
        return false;
      }

      return true;
    };
  </script>
</html>
