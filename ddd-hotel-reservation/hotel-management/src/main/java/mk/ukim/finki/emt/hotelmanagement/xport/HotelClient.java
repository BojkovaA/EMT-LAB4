package mk.ukim.finki.emt.hotelmanagement.xport;

import org.springframework.beans.factory.annotation.Value;
import mk.ukim.finki.emt.hotelmanagement.domain.models.Hotel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class HotelClient {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public HotelClient(@Value("${app.hotel-management.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Hotel> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/hotel").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Hotel>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }


}

