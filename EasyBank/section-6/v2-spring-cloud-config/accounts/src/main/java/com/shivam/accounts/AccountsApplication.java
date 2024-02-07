package com.shivam.accounts;

import com.shivam.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts Microservice REST API docs"
				,description = "EazyBank Account Microservice REST API Docs"
				,version = "v1"
				,contact = @Contact(
						name = "Shivam Sharma"
						,email = "shivam007mrt@gmail.com"
				        ,url="https://shivam.com"
				),
				license = @License(
						name ="Apache 2.0",
						url = "https://shivam.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "EazyBank Account RestAPI docs",
				url ="https://shivam/swagger-ui/inex.html"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
