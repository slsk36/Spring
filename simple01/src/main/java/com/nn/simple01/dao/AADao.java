package com.nn.simple01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.activation.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.nn.simple01.dto.AADto;

@Repository
public class AADao {

	@Autowired
	BasicDataSource dataSource;
	
	@Autowired
	SqlSession sqlSession;
	
	public List<AADto> select() {
		System.out.println("select...");
		List<AADto> list = sqlSession.selectList("aa.getaa");
		for(AADto aaDto : list) {
			System.out.println("aaDto= "+aaDto.toString());
		}
		return list;
		
		
	}
	
	public void insert() {
		System.out.println("insert...");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection(); //dataSource �ڷ����� Ŀ�ؼ� ��������
			pstmt = conn.prepareStatement("insert into aa (bb) values ('this12')");
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null)pstmt.close();
				conn.close(); //dataSource �ڷ����� Ŀ�ؼ� �����ֱ�
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
