package one.digital.web.stdercorretora;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class StdercorretoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(StdercorretoraApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${application.description}")String description){
		return new OpenAPI().info(new Info()
				.title(description)
				.version("1.0")
				.termsOfService("http://swagger.io/terms")
				.license(new License().name("Apache 2.0")
				.url("http://springdoc.org")));
	}

}
