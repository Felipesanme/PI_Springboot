package com.bookingsproject.bookingsproject.controller.booking;

import com.bookingsproject.bookingsproject.dto.booking.BookingDto;
import com.bookingsproject.bookingsproject.model.Booking;
import com.bookingsproject.bookingsproject.service.booking.BookingService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingControllerTest {


    @Mock
    private BookingService bookingService;

    @InjectMocks
    private BookingController bookingController;

    @Test
    @Order(1)
    public void find_all_bookings_200() {

        List<Booking> bookingListMock = new ArrayList<>();
        bookingListMock.add(new Booking(LocalDate.now(),LocalDate.of(2023,01,30),"felipe@mail.com","felipe123"));
        bookingListMock.add(new Booking(LocalDate.now(),LocalDate.of(2023,01,31),"dibu@mail.com","dibu123"));

        Mockito.when(bookingService.findAll()).thenReturn(bookingListMock);

        ResponseEntity<List<Booking>> listBookingResultController = bookingController.findAll();
        Assertions.assertEquals(200, listBookingResultController.getStatusCodeValue());
    }

    @Test
    @Order(2)
    public void find_all_bookings_404() {

        List<Booking> bookingListMock = new ArrayList<>();

        Mockito.when(bookingService.findAll()).thenReturn(bookingListMock);

        ResponseEntity<List<Booking>> listBookingsResultController = bookingController.findAll();
        Assertions.assertEquals(404, listBookingsResultController.getStatusCodeValue());
    }

    @Test
    @Order(3)
    public void find_booking_by_id_200() {

        Booking bookingMock = new Booking(LocalDate.now(),LocalDate.of(2023,01,30),"felipe@mail.com","felipe123");

        Mockito.when(bookingService.findById("3_10")).thenReturn(bookingMock);

        ResponseEntity<Booking> bookingsResultController = bookingController.findById("3_10");
        Assertions.assertEquals(200, bookingsResultController.getStatusCodeValue());
    }

    @Test
    @Order(4)
    public void find_booking_by_id_404() {

        Mockito.when(bookingService.findById(Mockito.anyString())).thenReturn(null);

        ResponseEntity<Booking> bookingsResultController = bookingController.findById("3_10");
        Assertions.assertEquals(404, bookingsResultController.getStatusCodeValue());
    }

    @Test
    @Order(5)
    public void create_booking_201() {

        BookingDto bookingDtoMock = new BookingDto(LocalDate.now(),LocalDate.of(2023,01,30),"felipe@mail.com","felipe123");
        Booking bookingMock = new Booking(bookingDtoMock);

        Mockito.when(bookingService.createBooking(bookingDtoMock)).thenReturn(bookingMock);

        ResponseEntity<Booking> bookingResult = bookingController.createBooking(bookingDtoMock);
        Assertions.assertTrue(201 == bookingResult.getStatusCodeValue());
    }

    @Test
    @Order(6)
    public void update_booking_by_id_200() {

        BookingDto bookingDtoMock = new BookingDto(LocalDate.now(),LocalDate.of(2023,01,30),"felipe@mail.com","felipe123");
        Booking bookingMock = new Booking(bookingDtoMock);

        Mockito.when(bookingService.updateBooking("3_10", bookingDtoMock)).thenReturn(bookingMock);

        ResponseEntity<Booking> bookingUpdatedResult = bookingController.updateBooking("3_10", bookingDtoMock);
        Assertions.assertTrue(200 == bookingUpdatedResult.getStatusCodeValue());
        Assertions.assertTrue(bookingUpdatedResult.getBody() != null);
    }

    @Test
    @Order(7)
    public void delete_booking_by_id_200() {

        Mockito.when(bookingService.deleteBooking("3_10")).thenReturn(true);

        ResponseEntity<Boolean> bookingResultController = bookingController.deleteBooking("3_10");
        Assertions.assertEquals(200, bookingResultController.getStatusCodeValue());
    }

    @Test
    @Order(8)
    public void delete_booking_by_id_404() {

        Mockito.when(bookingService.deleteBooking(Mockito.anyString())).thenReturn(false);

        ResponseEntity<Boolean> bookingResultController = bookingController.deleteBooking("3_10");
        Assertions.assertEquals(404, bookingResultController.getStatusCodeValue());
    }



}