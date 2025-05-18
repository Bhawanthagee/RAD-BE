package com.rad.radbe.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExternalApiClient {

    @Autowired
    private RestTemplate restTemplate;

    public String sendFileToExternalAPI(MultipartFile file) throws Exception {
        // Wrap file in ByteArrayResource with proper filename
        ByteArrayResource fileAsResource = new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }
        };

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Create the request body
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("document", fileAsResource); // "document" is the expected param name by the external API

        // Combine headers and body
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        // Define the external API URL
        String externalApiUrl = "http://bgkprathibha-001-site9.atempurl.com/VerifyByAI";

        // Make the POST call
        ResponseEntity<String> response = restTemplate.postForEntity(externalApiUrl, requestEntity, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(String.valueOf(response.getBody()));
        boolean isValid = rootNode.path("isDocumentValid").asBoolean(false); // default to false if not present

        return String.valueOf(isValid);
    }
}




