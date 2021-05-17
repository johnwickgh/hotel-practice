package com.hotelapp.repository;

import com.hotelapp.models.Address;
import com.hotelapp.models.Delivery;
import com.hotelapp.models.Hotel;
import com.hotelapp.models.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class HotelRepositoryTest {

    @Autowired
    HotelRepository underTest;

    @BeforeEach
    void setUp() {
        Address address = new Address("NTexasBlvd", "Denton", 76201, "TX");
        Menu menu1 = new Menu("Idly", 20);
        Menu menu2 = new Menu("Dosa", 30);
        Set<Menu> menus = new HashSet<>(Arrays.asList(menu1, menu2));
        Delivery delivery1 = new Delivery("Swiggy", 5);
        Delivery delivery2= new Delivery("UberEats", 5);
        Set<Delivery> deliveries = new HashSet<>(Arrays.asList(delivery1,delivery2));
        Hotel hotel = new Hotel("AppleBees", address, menus, deliveries);
        underTest.save(hotel);
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }


    @Test
    void itShouldFindHotelsByAddressCity() {
        List<Hotel> result = underTest.findByAddressCity("Denton");
        Hotel hotel1 = result.get(0);
        assertThat(hotel1.getHotelName()).isEqualTo("AppleBees");
    }

    @Test
    void itShouldReturnNullOnFindHotelsByAddressCity() {
        List<Hotel> result = underTest.findByAddressCity("Issaquah");
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void itShouldFindHotelsByAddressStreetName() {
        List<Hotel> result = underTest.findByAddressStreetName("NTexasBlvd");
        Hotel hotel1 = result.get(0);
        assertThat(hotel1.getHotelName()).isEqualTo("AppleBees");
    }

    @Test
    void itShouldReturnNullFindHotelsByAddressStreetName() {
        List<Hotel> result = underTest.findByAddressStreetName("NWMullridgePl");
        assertThat(result.size()).isEqualTo(0);
    }


    @Test
    void itShouldGetHotelsByMenu() {
        List<Hotel> result = underTest.getHotelsByMenu("Idly");
        Hotel hotel1 = result.get(0);
        assertThat(hotel1.getHotelName()).isEqualTo("AppleBees");
    }

    @Test
    void itShouldReturnNullGetHotelsByMenu() {
        List<Hotel> result = underTest.getHotelsByMenu("Poori");
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void itShouldGetHotelsByDelivery() {
        List<Hotel> result = underTest.getHotelsByDelivery("Swiggy");
        Hotel hotel1 = result.get(0);
        assertThat(hotel1.getHotelName()).isEqualTo("AppleBees");
    }

    @Test
    void itShouldReturnNullGetHotelsByDelivery() {
        List<Hotel> result = underTest.getHotelsByDelivery("DoorDash");
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void itShouldGetHotelsByLocationAndMenu() {
        List<Hotel> result = underTest.getHotelsByLocationAndMenu("NTexasBlvd", "Idly");
        Hotel hotel1 = result.get(0);
        assertThat(hotel1.getHotelName()).isEqualTo("AppleBees");
    }

    @Test
    void itShouldReturnNullOnGetHotelsByLocationAndMenu() {
        List<Hotel> result = underTest.getHotelsByLocationAndMenu("NWMullridgePl", "Poori");
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    @Disabled
    void myTest(){

    }
}