package com.nn.simple01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nn.simple01.dto.AADto;
import com.nn.simple01.dao.AADao;

@Service
public class AAService {
	
	@Autowired
	AADao aaDao;
	
	public void join(AADto dto) {
		aaDao.select();
		aaDao.insert(dto);
	}

	public List<AADto> selectAll() {
		return aaDao.select();
	}

	public void update(AADto dto) {
		aaDao.update(dto);
	}
}
