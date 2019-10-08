package com.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllStudentDataFetcher implements DataFetcher<List<Student>> {

	@Autowired
	StudentRepository repository;

	@Override
	public List<Student> get(DataFetchingEnvironment environment) {

		return repository.findAll();
	}

}
