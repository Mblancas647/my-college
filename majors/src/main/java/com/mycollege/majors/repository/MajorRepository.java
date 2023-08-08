package com.mycollege.majors.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mycollege.majors.model.Major;

public interface MajorRepository extends MongoRepository<Major, String>{

}
