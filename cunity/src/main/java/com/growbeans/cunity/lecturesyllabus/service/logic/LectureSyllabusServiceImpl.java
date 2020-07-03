package com.growbeans.cunity.lecturesyllabus.service.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.lecturesyllabus.domain.LectureSyllabus;
import com.growbeans.cunity.lecturesyllabus.service.LectureSyllabusService;
import com.growbeans.cunity.lecturesyllabus.store.LectureSyllabusStore;

@Service("lecSylService")
public class LectureSyllabusServiceImpl implements LectureSyllabusService {
	
	@Autowired
	private LectureSyllabusStore lecSylStore;

	@Override
	public LectureSyllabus selectOneLecSyl(int lCode) {
		return lecSylStore.selectOneLecSyl(lCode);
	}

}
