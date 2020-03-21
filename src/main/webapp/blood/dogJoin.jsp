<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="../css/dogJoin.css">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>

<body>
<form name="dogJoinForm" method="post">
  <div class="dogjoinframe">
    <h3>헌혈견 정보 입력</h3>
    <ul>
      <li>
        <label>반려견 이름</label>
        <input type="text" placeholder="반려견 이름" id="dogName">
        <div id="dogNameDiv"></div>
      </li>
      <li>
        <label>반려견 나이</label>
        <input type="text" placeholder="숫자만 입력" id="dogAge">
        <div id="dogAgeDiv"></div>
      </li>
      <li>
        <label>반려견 종</label>
        <input type="text" placeholder="한글로 입력" id="dogBreed">
        <div id="dogBreedDiv"></div>
      </li>
      <li>
        <label>반려견 몸무게(kg)</label>
        <input type="text" placeholder="숫자만 입력" id="dogWeight">
        <div id="dogWeightDiv"></div>
      </li>
      <li>
        <label>반려견 혈액형</label><br />
        <select placeholder="숫자만 입력" id="dogbloodType">
          <option value="1.1" id="dogbloodType">1.1</option>
          <option value="1.2" id="dogbloodType">1.2</option>
          <option value="1.3" id="dogbloodType">1.3</option>
          <option value="3" id="dogbloodType">3</option>
          <option value="4" id="dogbloodType">4</option>
          <option value="5" id="dogbloodType">5</option>
          <option value="7" id="dogbloodType">7</option>
        </select>
      </li>
    </ul>
    <div class="btn_center"><button type="button" class="dogJoinBtn" return="false">등록신청</button></div>
  </div>
</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="../js/dogJoin.js"></script>
</html>
