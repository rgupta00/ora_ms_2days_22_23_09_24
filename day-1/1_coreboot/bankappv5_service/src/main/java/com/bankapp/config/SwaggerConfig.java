package com.bankapp.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

//@OpenAPIDefinition(info = @Info(title = "Bank API", version = "2.0", 
//			description = "Oracle BankApi API"))
@OpenAPIDefinition(
		info = @Info(
				title = "Oracle BankApi API",
				description = "Oracle BankApi API",
				version = "v1",
				contact = @Contact(
						name = "Anil",
						email = "anil@oracle.com",
						url = "https://www.ora.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.cbre.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "",
				url = "https://www.ora.com/swagger-ui.html"
		)
)
@Configuration
public class SwaggerConfig {

}
