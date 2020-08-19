package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BreweryClientTest {
    @Autowired
    BreweryClient breweryClient;
    @Test
    void getBeerById() {
        BeerDto beerDto=breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }
    @Test
    void saveBeer(){
       BeerDto beerDto = BeerDto.builder().beerName("kingfisher")
               .id(UUID.randomUUID())
               .upc(324324L).beerStyle("draught").build();
       URI uri=breweryClient.saveBeer(beerDto);
       assertNotNull(uri);
    }

    @Test
    void updateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("kingfisher")
                .id(UUID.randomUUID())
                .upc(324324L).beerStyle("draught").build();
        breweryClient.updateBeer(beerDto.getId(),beerDto);
    }

    @Test
    void deleteBeer(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}