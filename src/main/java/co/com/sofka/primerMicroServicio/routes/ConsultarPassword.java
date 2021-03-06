package co.com.sofka.primerMicroServicio.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.sofka.primerMicroServicio.dtos.PasswordDTO;
import co.com.sofka.primerMicroServicio.useCases.Impl.ConsultarDatoImpl;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarPassword {
    @Bean
    public RouterFunction<ServerResponse> recomendarRecurso(ConsultarDatoImpl x){

        return route(
            GET("/consultar").and(accept(MediaType.APPLICATION_JSON)),
            request -> ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromPublisher(x.get(), PasswordDTO.class))
    );
    }
}
