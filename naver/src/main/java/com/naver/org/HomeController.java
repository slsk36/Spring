package com.naver.org;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.MemberDTO;

@Controller
public class HomeController {

	@RequestMapping(value = "/main.ws", method = RequestMethod.GET)
	public String main(Locale locale, Model model, HttpSession session) {
//		UserVO userVO = (UserVO)session.getAttribute("login");
//		if (userVO == null) {
//			model.addAttribute("log", "濡쒓렇�씤 �븞�맖");
//		} else {
//			model.addAttribute("log", "濡쒓렇�씤 �꽦怨�!!");
//			model.addAttribute("logininfo", "濡쒓렇�씤 �븳 �젙蹂� : ");
//			model.addAttribute("loginemail", userVO);
//		}

		return "site/main";
	}
	
	@Autowired
	@Qualifier(value = "ds")
	DataSource dataSource;
	
	@RequestMapping(value = "/dstest", method = RequestMethod.GET)
	public String dstest(Locale locale, Model model) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return "dstest";
	}
	
	@RequestMapping(value = "/dstest2", method = RequestMethod.GET)
	public String dstest2(Locale locale, Model model) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<MemberDTO> list = jdbcTemplate.query("select * from member", new RowMapper<MemberDTO>() {
			@Override
			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
			MemberDTO memberDTO = new MemberDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			return memberDTO;
			}
		});
		
		for (MemberDTO md : list) {
			System.out.println("md= "+md);
		}
		
		int rowCnt = jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
		System.out.println("행 갯수= "+rowCnt);
		
		jdbcTemplate.update("update member set password='aaa'");
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("insert into member "+
						"(EMAIL,PASSWORD,NAME,REGDATE) "+
						"valus "+
						"('abcd@madvirus.com','12345','madvirus3',now())",new String[] {"ID"});
				return pstmt;
			}
		},keyholder);
		
		Number keyValue = keyholder.getKey();
		System.out.println("keyValue = "+keyValue);
		
		return "dstest";
	}

	@RequestMapping(value = "/Kids.ws", method = RequestMethod.GET)
	public String Kids(Locale locale, Model model, HttpSession session) {

		return "Kids/Kids";
	}
	
	@RequestMapping(value = "/man2.ws", method = RequestMethod.GET)
	public String man2(Locale locale, Model model, HttpSession session) {
		
		return "man/man2";
	}

	@RequestMapping(value = "/off.ws", method = RequestMethod.GET)
	public String off(Locale locale, Model model, HttpSession session) {

		return "off_season/off";
	}

	@RequestMapping(value = "/포퍼먼스.ws", method = RequestMethod.GET)
	public String 포퍼먼스(Locale locale, Model model, HttpSession session) {

		return "performance/포퍼먼스";
	}

	@RequestMapping(value = "/women.ws", method = RequestMethod.GET)
	public String women(Locale locale, Model model, HttpSession session) {

		return "women/women";
	}
	
	@RequestMapping(value = "/login.ws", method = RequestMethod.GET)
	public String login(Locale locale, Model model, HttpSession session) {
		
		return "login/login";
	}
	
	
}
