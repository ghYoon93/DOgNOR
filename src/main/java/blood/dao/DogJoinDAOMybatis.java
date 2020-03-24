package blood.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import blood.bean.DogJoinDTO;

@Repository("DogJoinDAO")
@Transactional
public class DogJoinDAOMybatis implements DogJoinDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int dogInsert(DogJoinDTO dogJoinDTO) {
		return sqlSession.insert("bloodSQL.dogInsert", dogJoinDTO);
	}

}
