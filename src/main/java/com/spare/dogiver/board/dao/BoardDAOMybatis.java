package com.spare.dogiver.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spare.dogiver.board.dto.BoardDTO;


@Repository
@Transactional
public class BoardDAOMybatis implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void boardWrite(BoardDTO boardDTO) {
		sqlSession.insert("boardSQL.boardWrite", boardDTO);
	}

	@Override
	public List<BoardDTO> getBoardList(Map<String, Integer> map) {
		return sqlSession.selectList("boardSQL.getBoardList", map);
	}

	@Override
	public int getBoardTotalA() {
		return sqlSession.selectOne("boardSQL.getBoardTotalA");
	}

	@Override
	public BoardDTO getBoard(String brd_seq) {
		return sqlSession.selectOne("boardSQL.getBoard", Integer.parseInt(brd_seq));
	}
	
	@Override
	public List<BoardDTO> getReBoard(String brd_seq) {
		return sqlSession.selectList("boardSQL.getReBoard", Integer.parseInt(brd_seq));
	}

	@Override
	public int getBoardSearchTotalA(Map<String, String> map) {
		return sqlSession.selectOne("boardSQL.getBoardSearchTotalA", map);
	}

	@Override
	public List<BoardDTO> getBoardSearch(Map<String, String> map) {
		return sqlSession.selectList("boardSQL.getBoardSearch", map);
	}

	@Override
	public void boardDelete(int brd_seq) {
		sqlSession.delete("boardSQL.boardDelete", brd_seq);
	}

	@Override
	public BoardDTO getBoardView_before(String brd_seq) {
		return sqlSession.selectOne("boardSQL.getBoardView_before",Integer.parseInt(brd_seq));
	}

	@Override
	public BoardDTO getBoardView_after(String brd_seq) {
		return sqlSession.selectOne("boardSQL.getBoardView_after", Integer.parseInt(brd_seq));
	}


	@Override
	public List<BoardDTO> getReply(int bd_seq) {
		return sqlSession.selectList("boardSQL.getReply", bd_seq);
	}

	@Override
	public void re_write(BoardDTO boardDTO) {
		sqlSession.insert("boardSQL.re_write", boardDTO);
	}

	@Override
	public List<BoardDTO> getReBoard_before(String brd_seq) {
		return sqlSession.selectList("boardSQL.getReBoard_before", Integer.parseInt(brd_seq));
	}

	@Override
	public List<BoardDTO> getReBoard_after(String brd_seq) {
		return sqlSession.selectList("boardSQL.getReBoard_after", Integer.parseInt(brd_seq));
	}

	@Override
	public void reply_delete(String re_seq) {
		sqlSession.delete("boardSQL.reply_delete", Integer.parseInt(re_seq));
		
	}

	@Override
	public BoardDTO getUser(String brd_seq) {
		return sqlSession.selectOne("boardSQL.getUser", Integer.parseInt(brd_seq));
	}
	
	
	@Override
	public void boardModify(BoardDTO boardDTO) {
		sqlSession.update("boardSQL.boardModify", boardDTO);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<BoardDTO> getMyboard(String nickName) {
		return sqlSession.selectList("boardSQL.getMyboard", nickName);
	}
	
	@Override
	public List<BoardDTO> getMyreply(String nickName) {
		return sqlSession.selectList("boardSQL.getMyreply", nickName);
	}

	@Override
	public BoardDTO getMyboardView(String brd_seq) {
		return sqlSession.selectOne("boardSQL.getBoard", Integer.parseInt(brd_seq));
	}

	
}













