package com.spare.dogiver.blood.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spare.dogiver.blood.dto.DogJoinDTO;
import com.spare.dogiver.blood.dto.DogiverDTO;

@Repository("BloodDAO")
@Transactional
public class BloodDAOMybatis implements BloodDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int dogInsert(DogJoinDTO dogJoinDTO) {
		return sqlSession.insert("bloodSQL.dogInsert", dogJoinDTO);
	}

	@Override
	public List<DogiverDTO> getDogiver() {
		
		return sqlSession.selectList("bloodSQL.getDogiver");
	}

	@Override
	public DogJoinDTO getMyblood(String email) {
		return sqlSession.selectOne("bloodSQL.getMyblood", email);
	}

	@Override
	public void mybloodModify(DogJoinDTO dogJoinDTO) {
		sqlSession.update("bloodSQL.mybloodModify", dogJoinDTO);
		
	}

}
