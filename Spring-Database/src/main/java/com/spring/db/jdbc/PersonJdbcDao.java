package com.spring.db.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.db.bean.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
	}
	
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[] { id });
	}
	
	public int insert(Person person) {
		return jdbcTemplate.update("insert into person (id, name, location, birth_date) " + "values(?,  ?, ?, ?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						person.getBirthDate()});
	}

	public int update(Person person) {
		return jdbcTemplate.update("update person " + " set name = ?, location = ?, birth_date = ? " + " where id = ?",
				new Object[] { person.getName(), person.getLocation(), person.getBirthDate(),
						person.getId() });
	}
}
