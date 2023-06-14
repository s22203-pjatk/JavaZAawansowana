package pl.pjatk.TOMFID.MovieService;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("MovieServiceApplication")
                        .description("zjadl bym sobie pizzunie")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("tomcio")
                                .email("tomekfidurski@gmail.com")));
    }
}