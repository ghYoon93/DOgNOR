// 데이터 뿌려주기
$(document).ready(function() {
	$.ajax({
		type : 'post',
		url : '/dogiver/board/getBoardView',
		data : 'brd_seq=' + $('#brd_seq').val(),
		dataType : 'json',
		success : function(data) {
			alert('보드뷰실행');
		
			$('#seqSpan').text(data.boardDTO.brd_seq);
			$('#categorySpan').text(data.boardDTO.brd_category);
			$('#titleSpan').text(data.boardDTO.brd_title);
			$('#idSpan').text(data.boardDTO.brd_nickname);
			$('#dateSpan').text(data.boardDTO.brd_logtime);
			$('#contentSpan').html(data.boardDTO.brd_content);
			$('#brd_seq').val(data.boardDTO.brd_seq);
			$('#re_seq').val(data.boardDTO.re_seq);
			
			let tag='';
			$.each(data.list,function(index, items) {
				tag += '<table class="replyContent" border="1" style="width: 1080px;">'
					+ '<tr><td height= "45" width="75" align="center">작성자</td>'
					+ '<td width="70" align="center"><span id="writerSapn">'
					+ items.re_writer
					+ '</span></td>'
					+ '<td width="70" align="center">작성일</td>'
					+ '<td width="100" align="center"><span id="timeSapn">'
					+ items.re_logtime
					+ '</span></td>'
					+ '<td width="480" align="right" style="padding-right: 20px;">'
					+'<a href="#" id='+items.re_seq+' class='+items.re_writer+'>삭제</a></td>'
					+ '</tr><tr><td colspan="6" height="65" style="padding: 10px;"><span id="timeSapn">'
					+ items.re_content
					+ '</span></td></tr>'
					+ '</table>';
			
			});
			$('#contentDiv').append(tag);
			
			$.each(data.list,function(index, items) {
				if(data.memNickName!=items.re_writer){
					$('a').remove();
				}
				
			});
			//글 수정 삭제 보여주기
			if (data.memEmail == data.boardDTO.br_email)
				$('#board_member_addBtn').show();
			else (data.memEmail != data.boardDTO.brd_email)
				$('#board_member_addBtn').hide();
		}
	});
});


// 글쓰기 버튼
$('#writeBtn').click(function() {
	location.href = 'http://localhost:8080/dogiver/board/boardWriteForm';
});

// 이전 버튼
$('#beforeBtn').click(function() {
	$('.replyContent').remove();
	$.ajax({
		type : 'post',
		url : '/dogiver/board/getBoardView_before',
		data : 'brd_seq=' + $('#brd_seq').val(),
		dataType : 'json',
		success : function(data) {
			alert('이전버튼실행');
			$('#seqSpan').text(data.boardDTO.brd_seq);
			$('#categorySpan').text(data.boardDTO.brd_category);
			$('#titleSpan').text(data.boardDTO.brd_title);
			$('#idSpan').text(data.boardDTO.brd_nickname);
			$('#dateSpan').text(data.boardDTO.brd_logtime);7
			$('#contentSpan').html(data.boardDTO.brd_content);
			$('#brd_seq').val(data.boardDTO.brd_seq);
			$('#re_seq').val(data.boardDTO.re_seq);
			
			let tag='';
			$.each(data.list,function(index, items) {
				tag += '<table class="replyContent" border="1" style="width: 1080px;">'
					+ '<tr><td height= "45" width="75" align="center">작성자</td>'
					+ '<td width="70" align="center"><span id="writerSapn">'
					+ items.re_writer
					+ '</span></td>'
					+ '<td width="70" align="center">작성일</td>'
					+ '<td width="100" align="center"><span id="timeSapn">'
					+ items.re_logtime
					+ '</span></td>'
					+ '<td width="480" align="right" style="padding-right: 20px;"><a href="#" id='+items.re_seq+'>삭제</a></td>'
					+ '</tr><tr><td colspan="6" height="65" style="padding: 10px;"><span id="timeSapn">'
					+ items.re_content
					+ '</span></td></tr>'
					+ '</table>';
			});
			$('#contentDiv').append(tag);
			
			if (data.memEmail == data.boardDTO.brd_email)
			$('#board_member_addBtn').show();
			else
			$('#board_member_addBtn').hide();
			
		}
	});
});
// 다음 버튼 버튼
$('#afterBtn').click(function() {
	$('.replyContent').remove();
	$.ajax({
		type : 'post',
		url : '/dogiver/board/getBoardView_after',
		data : 'brd_seq=' + $('#brd_seq').val(),
		dataType : 'json',
		success : function(data) {
			alert('다음버튼실행');

			$('#seqSpan').text(data.boardDTO.brd_seq);
			$('#categorySpan').text(data.boardDTO.brd_category);
			$('#titleSpan').text(data.boardDTO.brd_title);
			$('#idSpan').text(data.boardDTO.brd_nickname);
			$('#dateSpan').text(data.boardDTO.brd_logtime);
			$('#contentSpan').html(data.boardDTO.brd_content);
			$('#brd_seq').val(data.boardDTO.brd_seq);
			$('#re_seq').val(data.boardDTO.re_seq);
			
			let tag='';
			$.each(data.list,function(index, items) {
				tag += '<table class="replyContent" border="1" style="width: 1080px;">'
					+ '<tr><td height= "45" width="75" align="center">작성자</td>'
					+ '<td width="70" align="center"><span id="writerSapn">'
					+ items.re_writer
					+ '</span></td>'
					+ '<td width="70" align="center">작성일</td>'
					+ '<td width="510" align="center"><span id="timeSapn">'
					+ items.re_logtime
					+ '</span></td>'
					+ '<td width="75" align="center" style="padding-right: 20px;"><a href="#" id='+items.re_seq+'>삭제</a></td>'
					+ '</tr><tr><td colspan="6" height="65" style="padding: 10px;"><span id="timeSapn">'
					+ items.re_content
					+ '</span></td></tr>'
					+ '</table>';
			});
			$('#contentDiv').append(tag);
			
			if (data.memEmail == data.boardDTO.brd_email)
			$('#board_member_addBtn').show();
			else
			$('#board_member_addBtn').hide();
			
		}
	});
});
// 글쓰기 버튼 삭제 버튼
$('#deletBtn').click(function() {
	document.boardViewForm.method = 'POST';
	document.boardViewForm.action = 'boardDelete';
	document.boardViewForm.submit();
	alert("글이 삭제되었습니다.")
	location.href = 'boardList';
});

$('#listBtn').click(function() {
	location.href = 'boardList?pg=' + $('#pg').val();
});

// 목록 버튼
$('#listBtn').click(function() {
	location.href = 'boardList?pg=' + $('#pg').val();
});

$('#modifyBtn').click(function(){
	location.href='boardModifyForm?brd_seq='+$('#brd_seq').val();
});

