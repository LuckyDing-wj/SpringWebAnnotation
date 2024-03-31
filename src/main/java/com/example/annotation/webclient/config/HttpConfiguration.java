package com.example.annotation.webclient.config;

import com.example.annotation.webclient.service.AlbumsService;
import com.example.annotation.webclient.service.TodoService;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Configuration(proxyBeanMethods = false)
public class HttpConfiguration {

    @Bean
    public TodoService todoService(){
        WebClient webClient = WebClient.builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .build();
        return HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(webClient))
                .build()
                .createClient(TodoService.class);
    }

    /*
    @Bean
    public AlbumsService albumsService(){
        WebClient webClient = WebClient.create();
        return HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(webClient))
                .build()
                .createClient(AlbumsService.class);
    }*/

    @Bean
    public AlbumsService albumsService(){
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .doOnConnected(conn -> {
                    conn.addHandlerFirst(new ReadTimeoutHandler(10));
                    conn.addHandlerFirst(new WriteTimeoutHandler(10));
                });
        WebClient webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultStatusHandler(HttpStatusCode::isError, response -> {
                    System.out.println("******* WebClient Exception Handler *******");
                    return Mono.error(new RuntimeException("WebClient Exception " + response.statusCode().value()));
                })
                .build();
        return HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(webClient))
                .build()
                .createClient(AlbumsService.class);
    }
}
