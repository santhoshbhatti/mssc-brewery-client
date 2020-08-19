package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;
    @Test
    public void getCustomerById(){
        CustomerDto customer=customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customer);
    }

    @Test
    void saveCustomer() {
        URI uri = customerClient.saveCustomer(CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("john cena").build());
        assertNotNull(uri);
    }

    @Test
    void updateCustomer(){
        CustomerDto customerDto = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("john cena").build();
        customerClient.updateCustomer(customerDto.getId(),customerDto);
    }

    @Test
    void deleteCustomer(){
        customerClient.deleteCustomer(UUID.randomUUID());
    }


}