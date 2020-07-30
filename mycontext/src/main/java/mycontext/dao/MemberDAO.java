package mycontext.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO {
	
	@Autowired
	MemberDAO dao;

	public void insert() {
		System.out.println("insert...");
	}
	public void select() {
		System.out.println("select...");
	}
}
