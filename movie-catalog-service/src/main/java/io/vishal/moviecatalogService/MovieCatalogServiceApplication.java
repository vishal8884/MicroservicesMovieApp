package io.vishal.moviecatalogService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication//test
public class MovieCatalogServiceApplication {

	@Bean("restT")
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	@Bean("WebClinett")
	public WebClient.Builder getWebClient()
	{
		return  WebClient.builder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
