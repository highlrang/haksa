package com.myproject.myweb.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.myproject.myweb.domain.UserVO;

import javax.inject.Inject;

@Service
public class UserDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String SelectUserById = "UserMapper.selectUserById";
	
	public UserVO selectUserById(String user_id) {
		return sqlSession.selectOne(SelectUserById, user_id);
	}
}
