package com.spring.db.springdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.db.bean.Person;

@Repository
public interface PersonSpringDataRepository 
extends JpaRepository<Person, Integer>{
}
