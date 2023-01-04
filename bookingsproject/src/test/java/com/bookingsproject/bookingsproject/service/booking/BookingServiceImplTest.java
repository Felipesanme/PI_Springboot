package com.bookingsproject.bookingsproject.service.booking;

import com.bookingsproject.bookingsproject.dto.booking.BookingDto;
import com.bookingsproject.bookingsproject.dto.user.UserDto;
import com.bookingsproject.bookingsproject.model.Booking;
import com.bookingsproject.bookingsproject.model.User;
import com.bookingsproject.bookingsproject.repository.booking.BookingRepository;
import com.bookingsproject.bookingsproject.repository.user.UserRepository;
import com.bookingsproject.bookingsproject.service.user.UserServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    @Order(1)
    public void find_all_bookings(){

        List<Booking> bookingListMock = new ArrayList<>();
        bookingListMock.add(new Booking(LocalDate.now(),LocalDate.of(2023,01,30),"felipe@mail.com","felipe123"));
        bookingListMock.add(new Booking(LocalDate.now(),LocalDate.of(2023,01,31),"felipe1@mail.com","felipe1231"));
        bookingListMock.add(new Booking(LocalDate.now(),LocalDate.of(2023,02,01),"felipe2@mail.com","felipe12312"));
        Mockito.when(bookingRepository.findAll()).thenReturn(bookingListMock);

        List<Booking> bookingListResult = bookingService.findAll();

        List<Booking> bookingListExpected = new ArrayList<>();
        bookingListExpected.add(new Booking(LocalDate.now(),LocalDate.of(2023,01,30),"felipe@mail.com","felipe123"));
        bookingListExpected.add(new Booking(LocalDate.now(),LocalDate.of(2023,01,31),"felipe1@mail.com","felipe1231"));
        bookingListExpected.add(new Booking(LocalDate.now(),LocalDate.of(2023,02,01),"felipe2@mail.com","felipe12312"));

        Assertions.assertEquals(bookingListExpected, bookingListResult);

    }

    @Test
    @Order(2)
    public void find_booking_by_id(){
        Booking bookingMock = new Booking(LocalDate.now(),LocalDate.of(2023,01,30),"felipe@mail.com","felipe123");
        Mockito.when(bookingRepository.findById("pagc")).thenReturn(bookingMock);

        Booking bookingResult = bookingService.findById("pagc");

        Booking bookingExpected = new Booking(LocalDate.now(),LocalDate.of(2023,01,30),"felipe@mail.com","felipe123");

        Assertions.assertEquals(bookingExpected.getEmail(), bookingResult.getEmail());
    }

    @Test
    @Order(3)
    public void create_booking(){
        BookingDto bookingInput = new BookingDto(LocalDate.now(),LocalDate.of(2023,01,30),"felipe@mail.com","felipe123");
        Booking bookingMock = new Booking(bookingInput);
        Mockito.when(bookingRepository.createBooking(Mockito.any(BookingDto.class)))
                .thenReturn(bookingMock);

        Booking bookingResult = bookingService.createBooking(bookingInput);


        Assertions.assertEquals(bookingMock,bookingResult);
    }

    @Test
    @Order(4)
    public void update_booking_by_id () {

        BookingDto bookingDtoMock = new BookingDto(LocalDate.now(),LocalDate.of(2023,01,30),"felipe@mail.com","felipe123");
        Booking bookingMock = new Booking(bookingDtoMock);

        Mockito.when(bookingRepository.updateBooking("3_10", bookingDtoMock)).thenReturn(bookingMock);

        Booking bookingResult = bookingService.updateBooking("3_10", bookingDtoMock);

        Assertions.assertEquals(bookingMock, bookingResult);
    }

    @Test
    @Order(5)
    public void  delete_booking_by_id() {
        Mockito.when(bookingRepository.deleteBooking("3_10")).thenReturn(true);

        Boolean bookingResult = bookingService.deleteBooking("3_10");

        Assertions.assertEquals(true, bookingResult);
    }

    @Test
    @Order(6)
    public void  find_booking_by_email( ) {

        Booking bookingEmailMock = new Booking(LocalDate.now(),LocalDate.of(2023,01,30),"felipe@mail.com","felipe123");

        Mockito.when(bookingRepository.findByEmail("felipe@mail.com")).thenReturn(bookingEmailMock);

        Booking bookingByEmailResult = bookingService.findByEmail("felipe@mail.com");
        Booking bookingExpected = new Booking(LocalDate.now(),LocalDate.of(2023,01,30),"felipe@mail.com","felipe123");
        Assertions.assertEquals(bookingExpected, bookingByEmailResult);
    }

}