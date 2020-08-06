package com.naver.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements InitializingBean,DisposableBean {

	@Override
	public void destroy() throws Exception {
		System.out.println("��ü ������ �����̳ʿ��� �Ҹ�");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("��ü ������ �����̳ʿ��� ����");
	}
	
}
