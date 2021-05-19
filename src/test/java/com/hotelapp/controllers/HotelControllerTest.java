package com.hotelapp.controllers;

import com.hotelapp.service.HotelService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class HotelControllerTest {

    HotelService hotelService = Mockito.mock(HotelService.class);

    @Test
    void shouldReturnTrue(){
        assertThat(1).isEqualTo(1);
    }

    @Test
    void shouldUseMockito(){
        HotelController hotelController = new HotelController();
    }



}