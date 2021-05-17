package com.hotelapp.service;

import com.hotelapp.models.Hotel;
import com.hotelapp.repository.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class HotelServiceTest {

    @Mock private HotelRepository hotelRepository;
    private HotelService underTest;

    @BeforeEach
    void setUp() {
         underTest = new HotelServiceImpl(hotelRepository);
    }

    @Test
    void shouldAddHotel() {
        Hotel hotel = new Hotel();
        underTest.addHotel(hotel);
        verify(hotelRepository).save(hotel);
    }

    @Test
    void shouldUpdateHotel() {
        Hotel hotel = new Hotel();
        underTest.updateHotel(hotel);
        verify(hotelRepository).save(hotel);
    }

    @Test
    @Disabled
    void getHotelById() {
        int id = 1;
        underTest.getHotelById(1);
        verify(hotelRepository).findById(1);
    }

    @Test
    void deleteHotel() {
        underTest.deleteHotel(1);
        verify(hotelRepository).deleteById(1);
    }

    @Test
    @Disabled
    void shouldGetHotelsByCity() {
        underTest.getHotelsByCity("Hyderabad");
        verify(hotelRepository).findByAddressCity("Hyderabad");
    }

    @Test
    void getHotelsByMenu() {
    }

    @Test
    void getHotelsByDelivery() {
    }

    @Test
    void getHotelsByLocation() {
    }

    @Test
    void getHotelsByLocationAndMenu() {
    }
}