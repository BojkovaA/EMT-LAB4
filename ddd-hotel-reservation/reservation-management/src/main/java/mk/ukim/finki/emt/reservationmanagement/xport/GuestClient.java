package mk.ukim.finki.emt.reservationmanagement.xport;
import mk.ukim.finki.emt.reservationmanagement.domain.models.Guest;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class GuestClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public GuestClient(@Value("${app.reservation-management.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Guest> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/guest").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Guest>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
