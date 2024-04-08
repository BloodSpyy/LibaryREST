package com.bloodspy.spring.libary;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info (
                title = "Libary System Api",
                description = "Libary system",
                version = "1.0.0",
                contact = @Contact(
                        name = "Gleb Reshetov",
                        email = "bloodspyy@yandex.ru"
                )
        )
)
public class OpenApiConfig {
}
