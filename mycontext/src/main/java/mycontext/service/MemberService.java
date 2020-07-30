package mycontext.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mycontext.dao.MemberDAO;

@Component
public class MemberService {

		@Autowired
		MemberDAO dao;
		
		public void join() {
			dao.select();
			dao.insert();
		}
	}
