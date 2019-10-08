package com.graphql;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {

	@Value("classpath:student.graphql")

	private org.springframework.core.io.Resource schemaResource;
	private GraphQL graphql;
	@Autowired
	private StudentDataFetcher studentDataFetcher;
	@Autowired
	private AllStudentDataFetcher allStudentDataFetcher;
	@Autowired
	private StudentDataCreater studentDataCreater;

	@PostConstruct
	public void loadSchema() throws IOException {
		File schemaFile = schemaResource.getFile();
		TypeDefinitionRegistry registry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, wiring);
		graphql = GraphQL.newGraphQL(schema).build();

	}

	private RuntimeWiring buildWiring() {

		return RuntimeWiring
				.newRuntimeWiring().type("Query", typeWiring -> typeWiring
						.dataFetcher("allStudents", allStudentDataFetcher)
						.dataFetcher("student", studentDataFetcher)
						.dataFetcher("storeStudent",studentDataCreater ))
				.build();

	}

	
	public GraphQL getGraphQL()
	{
		return graphql;
	}
}
