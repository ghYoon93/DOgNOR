<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/boardList.css" />
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean"
	rel="stylesheet" />
  <link rel="favicon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" type="image/x-icon" />
<link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" type="image/x-icon" />
</head>
<body>
	<div id="headerDiv"></div>
	<div class="page-title">
		<h2>게시판</h2>
		<p>다양한 주제로 다양한 대화를 하세요</p>
	</div>
	<form id="boardListForm">
		<div class="wrap">
			<div class="container">
				<input type="hidden" id="pg" value="${pg }">
				<div class="board-head">자유게시판</div>
				<table id="boardListTable">
					<tr>
						<th class="brd_no">글번호</th>
						<th class="brd_category">글종류</th>
						<th class="brd_title">제목</th>
						<th class="nickName">닉네임</th>
						<th class="brd_date">작성일</th>
					</tr>
				</table>


				<div id="boardPagingDiv"></div>

				<div id="boardOptionDiv">

					<input type="hidden" name="pg" value="1"> <select
						name="searchOption" id="searchOption">
						<option value="brd_title">제목
						<option value="brd_nickname">닉네임
						<option value="brd_category">종류</option>
					</select>


					<!-- 검색어가 사라지지 않게 -->
					<input type="text" name="keyword" id="keyword" value="${keyword }"
						placeholder="검색어 입력"> 
					<input type="button"
						id="boardSearchBtn" value="검색">
					<input type="button"
						id="boardWriteBtn" value="글쓰기"
						onclick="location.href='/dogiver/board/boardWriteForm'">

				</div>
			</div>
		</div>
	</form>
	<div id="footerDiv"></div>
</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/boardList.js"></script>
<script type="text/javascript">
	$('#keyword').keypress(function(event) {
		if (event.which == 13) {
			$('#boardSearchBtn').click();
			return false;
		}
	});
</script>
<script type="text/javascript">
	function boardSearch(pg) {
		//location.href='getBoardSearch?pg='+pg+'&searchOption=${searchOption}'+'&keyword=${keyword}'
		$('input[name=pg]').val(pg);
		$('#boardSearchBtn').trigger('click', 'trigger');
	}
</script>
</html>