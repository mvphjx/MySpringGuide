package com.demo.webflux.flux;

import com.demo.webflux.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * •RequestPredicate：声明要处理的请求类型。
 * •RouterFunction：声明如何将请求路由到处理器代码中。
 * •ServerRequest：代表一个HTTP请求，包括对请求头和请求体的访问。
 * •ServerResponse：代表一个HTTP响应，包括响应头和响应体信息。
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/20 0:19
 */
@Configuration
public class RouterUserCtrl
{
    @Bean
    public RouterFunction helloRouter()
    {
        return RouterFunctions.route(RequestPredicates.GET("/hello"),
                request -> ServerResponse.ok().body(Flux.just("Hello World"), String.class))
                .andRoute(RequestPredicates.GET("/bye"),
                        request -> ServerResponse.ok().body(Flux.just("See ya"), String.class));

    }

    @Bean
    public RouterFunction routerFunction()
    {
        return RouterFunctions.route(RequestPredicates.GET("/router/user/list"), this::list);
    }

    public Mono<ServerResponse> list(ServerRequest request)
    {
        List<User> list = new ArrayList<>();
        list.add(new User());
        return ServerResponse.ok().body(list, List.class);
    }

}
