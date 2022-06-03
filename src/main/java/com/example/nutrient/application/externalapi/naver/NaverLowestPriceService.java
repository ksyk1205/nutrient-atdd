package com.example.nutrient.application.externalapi.naver;

import com.example.nutrient.application.LowestPriceService;
import com.example.nutrient.application.dto.supplement.LowestPriceResponse;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverLowestPriceService implements LowestPriceService {

    @Value("${naver.client.id}")
    private String naverClientId;

    @Value("${naver.client.secret}")
    private String naverClientSecret;

    @Value("${naver.url.search.shopping}")
    private String naverSearchShoppingUrl;


    @Override
    public List<LowestPriceResponse> getLowestPrices(String name) {
        NaverLowestPriceRequest request = NaverLowestPriceRequest.of(name);
        URI uri = UriComponentsBuilder
            .fromUriString(naverSearchShoppingUrl)
            .queryParams(request.toMultiValueMap())
            .build()
            .encode()
            .toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<NaverLowestPriceResponse> response = new RestTemplate().exchange(
            uri, HttpMethod.GET, httpEntity,
            new ParameterizedTypeReference<NaverLowestPriceResponse>() {
            }
        );

        return response.getBody().getItems().stream()
            .map(o -> new LowestPriceResponse(o.getTitle(), o.getLink(), o.getLprice())).collect(
                Collectors.toList());
    }
}
