package com.easyrent;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;


@OpenAPIDefinition(
	    security = @SecurityRequirement(name = "bearerAuth")
	)
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT"
)
@SpringBootApplication
public class EasyRentApplication {
	public static void main(String[] args) {
		SpringApplication.run(EasyRentApplication.class, args);
	}
	
	@Bean
	public OpenAPI myOpenAPI() {
		Contact contact = new Contact();
		contact.setEmail("test@gmail.com");
		contact.setName("EasyRent backend app");
		//contact.setUrl("https://my-awesome-api.com");

		Server localServer = new Server();
		localServer.setUrl("http://localhost:8080/");
		localServer.setDescription("Server URL in Local environment");

		Info info = new Info()
				.title("EasyRent Role Based Access Application API")
				.contact(contact)
				.version("1.0")
				.description("This API exposes endpoints for users.");

		return new OpenAPI()
				.info(info)
				.servers(List.of(localServer));
	}
}