package com.anhnhv.restfulwebservices.project;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.apache.catalina.mapper.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot restAPIs documentation",
				description = "Demo Spring Boot APIs documentation using Swagger UI",
				contact = @Contact(
						name = "AnhNHV",
						email = "nguyenhavietanh2503@gmail.com",
						url = "facebook.com/vietanhkhongconbanvang.net"
				),
				license = @License(
						name = "Apache 8.5",
						url = "https//www.javaguides.net"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot user management documentation",
				url = "https://www.javaguides.net/user_management.html"
		)
)
public class ProjectApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
