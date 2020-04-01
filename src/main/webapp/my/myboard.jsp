<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <link rel="favicon" href="../image/favicon.ico" />
    <link rel="shortcut icon" href="../image/favicon.ico" type="image/x-icon" />
    <link rel="icon" href="../image/favicon.ico" type="image/x-icon" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>my page</title>
    <link rel="stylesheet" href="../css/reset.css" />
    <link rel="stylesheet" href="../css/style.css" />
    <link rel="stylesheet" href="../css/mypage.css" />
    <link rel="stylesheet" href="../css/myboard.css" />
    <link
      href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean"
      rel="stylesheet"
    />
    <script
      type="text/javascript"
      src="https://code.jquery.com/jquery-3.4.1.min.js"
    ></script>
    <script
      type="text/javascript"
      src="/data/201101/IJ12941530138912/jquery-contained-sticky-scroll.js"
    ></script>
    <script type="text/javascript" src="../js/myboard.js"></script>
    <script src="../js/main.js"></script>
  </head>
  <body>
    <div id="headerDiv"></div>
    <div class="page-title">
      <h2>my page</h2>
      <p>나의 정보들</p>
    </div>
    <div id="wrap">
      <div class="mypage">
        <div class="my-nav">
          <ol>
            <li><a href="../my/mypage">내 정보</a></li>
            <li><a href="../blood/myblood">헌혈견</a></li>
            <li><a href="">상품 </a></li>
            <li class="on"><a href="../board/myboard">내 게시글 </a></li>
            <li><a href="">내 문의 </a></li>
          </ol>
        </div>
        <div class="article">
        <div id="myboardDiv">
        	<div class="myboardList">
        	<label>내가 쓴 글</label>
        		<table id="myboardTable">
	        		<tr>
		        		<th width="350px">제목</th>
		        		<th width="150px">날짜</th>
	        		</tr>
        		</table>
        	</div>
        	<div class="myboardList">
        	<label>내가 쓴 댓글</label>
        		<table id="myreplyTable">
        			<tr>
        				<th width="350px">코멘트</th>
        				<th width="150px">날짜</th>
        			</tr>
        		</table>
        	</div>
        	<div id="myboardView">
        		<table>
        			<tr>
        				<td width="150" height="150">글번호 : <span id="brd_seq"></span></td>
        				<td width="200">글종류 : <span id="brd_category"></span></td>
        				<td width="500">제목 : <span id="brd_title"></span></td>
        				<td width="200">날짜 : <span id="brd_logtime"></span></td>
        			</tr>
        			<tr>
        				<td colspan="4" id="brd_content" height="350"></td>
        			</tr>
        		</table>
        	</div>
        </div>
        </div>
      </div>
    </div>
    <div id="footerDiv"></div>
  </body>
</html>
