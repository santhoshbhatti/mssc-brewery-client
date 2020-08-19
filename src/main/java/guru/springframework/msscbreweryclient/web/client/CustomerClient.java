package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery",ignoreInvalidFields = false)
public class CustomerClient {
    private final RestTemplate restTemplate;
    private String apiHost;
    private static final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    public CustomerClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate=restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost){
        this.apiHost=apiHost;
    }

    public CustomerDto getCustomerById(UUID customerId){
        CustomerDto customerDto = restTemplate.getForObject(apiHost+CUSTOMER_PATH_V1+customerId.toString(),CustomerDto.class);
        return customerDto;
    }

    public URI saveCustomer(CustomerDto customerDto){
        URI uri = restTemplate.postForLocation(apiHost+CUSTOMER_PATH_V1,customerDto);
        return uri;
    }

    public void updateCustomer(UUID uuid,CustomerDto customerDto){
        restTemplate.put(apiHost+CUSTOMER_PATH_V1+uuid.toString(),customerDto);
    }

    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apiHost+CUSTOMER_PATH_V1+customerId.toString());
    }

}
