package de.htwberlin.wi.codefirst;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                                .info(new Info()
                                                .contact(new Contact()
                                                                .name("Sebastian Koch"))
                                                .title("WI-Bachelor-2026 - Bestandsmanagement API")
                                                .version("1.0.0")
                                                .description(
                                                                "Zentrale API-Spezifikation für den Design-First-Ansatz im Rahmen der Evaluation."))
                                .servers(List.of(
                                                new Server()
                                                                .url("http://localhost:8080")
                                                                .description("Lokaler Entwicklungs-Server")))
                                .extensions(Map.of(
                                                "x-api-id", "369dc1b6-42d2-443b-b5b4-bd173cb6103e",
                                                "x-audience", "component-internal"));
        }
}