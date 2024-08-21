package edu.uw.cpi.controller;

import edu.uw.cpi.model.Cpi;
import edu.uw.cpi.model.bls.Bls;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class ApiController {

    public static final String HTTPS_API_BLS_GOV = "https://api.bls.gov";
    public static final String HTTPS_API_SERIES_ID = "LAUCN040010000000005";

    public static final int EXPIRY_IN_MILLIS = 5000;
    private final WebClient webClient;


    @Autowired
    public ApiController() {

        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, EXPIRY_IN_MILLIS)
                .responseTimeout(Duration.ofMillis(EXPIRY_IN_MILLIS))
                .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(EXPIRY_IN_MILLIS, TimeUnit.MILLISECONDS))
                        .addHandlerLast(new WriteTimeoutHandler(EXPIRY_IN_MILLIS, TimeUnit.MILLISECONDS)));

        this.webClient = WebClient.builder()
                .baseUrl(HTTPS_API_BLS_GOV)

                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

    }


//    @GetMapping("/external")
//    public Mono<Cpi> callBlsApi(String seriesId) {
//        return this.webClient.get()
//                .uri("/publicAPI/v1/timeseries/data/{seriesId}", seriesId)
//                .retrieve()
//                .bodyToMono(Bls.class)  // Get the BLS response
//                .flatMap(bls -> {
//                    List<Cpi> dataList = bls.getResults().getSeries().get(0).getCpis();
//
//                    if (dataList != null && !dataList.isEmpty()) {
//                        return Mono.just(dataList.get(0));
//                    } else {
//                        return Mono.empty();
//                    }
//                });
//    }


    @GetMapping("/external")
    public List<Cpi> callBlsApi(String seriesId) {
        return this.webClient.get()
                .uri("/publicAPI/v1/timeseries/data/{seriesId}", seriesId)
                .retrieve()
                .bodyToMono(Bls.class)  // Get the BLS response
                .map(bls -> bls.getResults().getSeries().get(0).getCpis())
                .block();
    }


}
