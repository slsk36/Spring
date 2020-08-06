package com.naver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.naver.MemberDTO;

public class MemberDAO {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	public MemberDTO selectOne() {
		MemberDTO md = jdbcTemplate.queryForObject("select * from member where email=?", 
				new RowMapper<MemberDTO>() {
			@Override
			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
			MemberDTO memberDTO = new MemberDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			return memberDTO;
			}
		},"madvirus@madvirus.net");
		return md;
	}
	
	public List<MemberDTO> selectAll() {
		return null;
	}
	
	public void insert(MemberDTO md) {
		
	}
	
	public void update(MemberDTO md) {
		
	}
	
	public void delete(MemberDTO md) {}
}
