package com.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graphql.ExecutionResult;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

	@Autowired
	GraphQLService graphQLService;

	@PostMapping
	public ResponseEntity<Object> getStudentAllDetails(@RequestBody String query) {
		ExecutionResult execute = graphQLService.getGraphQL().execute(query);
		return new ResponseEntity<Object>(execute, HttpStatus.OK);
	}

}
