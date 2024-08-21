package edu.uw.cpi.client;

import edu.uw.cpi.model.BlsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class BLSFacade {

    @Value("${url}")
    private String url;

    private RestTemplate restTemplate = new RestTemplate();


    @Cacheable(value = "BLSResponse")
    public BlsResponse callUrlAndProcessResponse() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        ResponseEntity<BlsResponse> responseEntity = restTemplate.getForEntity(builder.toUriString(), BlsResponse.class);
        BlsResponse blsResponse = responseEntity.getBody();
        return blsResponse;
    }
}
