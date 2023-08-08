package com.mycollege.majors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycollege.majors.exception.MajorException;
import com.mycollege.majors.model.Major;
import com.mycollege.majors.repository.MajorRepository;


@Service
public class MajorService {

	@Autowired
	MajorRepository majorRepository;
	
	public void addMajor(Major major) {
		//NEED TO ADD VALIDATION AND CHECK TO SEE IF COURSE ALREADY EXISTS
		majorRepository.insert(major);
	}
	
	public void deleteMajor(String majorName) throws MajorException {
		Major major = majorRepository.findById(majorName)
				.orElseThrow(() -> new MajorException("Major "+majorName+" not found"));
		majorRepository.delete(major);
	}
	
	public void updateCourse(Major major) throws MajorException {
		//NEED TO ADD VALIDATION AND CREATION OF DTO OBJECT
		String name = major.getMajorName();
		if(majorRepository.existsById(name)) {
			majorRepository.save(major);
		} else {
			throw new MajorException("Major "+name+" not found");
		}
	}
}
