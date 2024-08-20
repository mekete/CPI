package edu.uw.cpi.service;

import edu.uw.cpi.model.bls.Bls;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
public class WebClientService {


    public static final String HTTPS_API_BLS_GOV = "https://api.bls.gov";
    public static final String HTTPS_API_SERIES_ID = "LAUCN040010000000005";

    public static final int EXPIRY_IN_MILLIS = 5000;
    private final WebClient webClient;

    public WebClientService() {

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

    public  void main(String[] args) {


        String baseUrl = "https://api.bls.gov/publicAPI/v1/timeseries/data/" + HTTPS_API_SERIES_ID;

        webClient.get()
                .uri(baseUrl)
                .retrieve()
                .bodyToMono(Bls.class)
                .subscribe(response -> {
                    System.out.println(response);
                }, error -> {
                    System.err.println("Error fetching data: " + error.getMessage());
                });
    }

    public Mono<Bls> callBls(String seriesId) {
        String aaa_seriesId = "LAUCN040010000000005";
        return this.webClient.get().uri("/publicAPI/v1/timeseries/data/{seriesId}", seriesId)
                .retrieve().bodyToMono(Bls.class);
    }


}
