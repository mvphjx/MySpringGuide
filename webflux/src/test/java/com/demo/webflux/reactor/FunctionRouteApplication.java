package com.demo.webflux.reactor;

import com.demo.webflux.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * 函数式编程-路由
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/19 23:46
 */
public class FunctionRouteApplication
{
    public static void main(String[] args) throws IOException
    {

        HttpHandler httpHandler = toHttpHandler(
                route(RequestPredicates.GET("/userlist").and(accept(MediaType.APPLICATION_JSON)), UserHandler::list));
        ReactorHttpHandlerAdapter httpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer.create().host("localhost").port(8000).handle(httpHandlerAdapter).bind().block();
        System.in.read();
    }

    /**
     * userlist的具体实现
     */
    static class UserHandler
    {
        public static Mono<ServerResponse> list(ServerRequest request)
        {
            User userBody = new User();
            request.bodyToFlux(User.class).subscribe(user -> BeanUtils.copyProperties(user, userBody));
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(userBody));
        }
    }
}
