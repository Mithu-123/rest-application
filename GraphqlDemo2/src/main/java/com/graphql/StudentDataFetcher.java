package com.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class StudentDataFetcher implements DataFetcher<Student> {

	@Autowired
	StudentRepository repository;

	@Override
	public Student get(DataFetchingEnvironment environment) {
		Long id = environment.getArgument("studentId");
		return repository.findOne(id);
	}

}
