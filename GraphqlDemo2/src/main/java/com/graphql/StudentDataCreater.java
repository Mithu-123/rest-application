package com.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class StudentDataCreater implements DataFetcher<Student> {
	@Autowired
	StudentRepository repository;

	@Override
	public Student get(DataFetchingEnvironment environment) {
		String name, rollNumber, std, address;
		name = environment.getArgument("name");
		rollNumber = environment.getArgument("rollNumber");
		std = environment.getArgument("std");
		address = environment.getArgument("address");

		Student student = new Student();
		student.setAddress(address);
		student.setName(name);
		student.setRollNumber(rollNumber);
		student.setStd(std);
		System.out.print(student.toString());
		repository.save(student);
		return student;
	}

}
