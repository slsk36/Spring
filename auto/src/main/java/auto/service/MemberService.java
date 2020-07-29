package auto.service;

import org.springframework.beans.factory.annotation.Autowired;

import auto.dao.MemberDao;

public class MemberService {

	@Autowired
	MemberDao memberDao;
	
	public MemberService() {}
	
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}


	public MemberService(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}


	public void join() {
		memberDao.select();
		memberDao.insert();
	}
}

