<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
textarea:focus {
	outline: none;
}
#contentDiv{
width: 100%; 
box-sizing: border-box;
padding: 10px;
border:none; !important
} 
</style>
<link rel="favicon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" type="image/x-icon" />
<link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" type="image/x-icon" />
<div style="font-size:15px; font-weight:500; text-indent:20px;">댓글달기</div>
<form name="boardReplyForm" >
	<input type="hidden" name="brd_seq" value="${brd_seq}"> 
	<input type="hidden" name="pg" value="${pg }">
	<%-- <input type="hidden" name="re_seq" value="${re_seq }"> --%>
		

	<div id="replyFormDiv" style="width: 1100px; min-height: 140px; box-sizing: border-box; background-color: #f1eaea; padding-left: 200px; padding-top: 33px;">
		<table>
			<tr>
				<td><textarea id="re_content" name="re_content" maxlength="55" 
						style="width: 750px; resize: none; border-color: darkred;"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<div id="confirmDiv"></div>
				<input type="button" value="댓글달기" id="boardFormBtn">
			</tr>
		</table>
	</div>
	</form>
	<div id="contentDiv"></div>


<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
