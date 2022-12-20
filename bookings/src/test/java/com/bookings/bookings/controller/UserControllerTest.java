package com.bookings.bookings.controller;

import com.bookings.bookings.model.User;
import com.bookings.bookings.model.UserDto;
import com.bookings.bookings.service.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    User userMockito;

    @BeforeEach
    public void setUp(){
        userMockito = new User("user1", "user1@mail.com"
                , "123asd");
    }

    @Test
    @Order(1)
    public void find_all_status_200() {

        List<User> userListMock = new ArrayList<>();
        userListMock.add(new User("user1", "user1@mail.com"
                , "123asd"));
        userListMock.add(new User("user2", "user2@mail.com"
                , "123asd"));
        userListMock.add(new User("user3", "user3@mail.com"
                , "123asd"));

        Mockito.when(userService.getAllUsers()).thenReturn(userListMock);

        ResponseEntity<List<User>> listUserController = userController.getAllUsers();

        Assertions.assertEquals(200, listUserController.getStatusCodeValue());

    }

    @Test
    @Order(2)
    public void find_all_status_404() {

        List<User> userListMock = new ArrayList<>();

        Mockito.when(userService.getAllUsers()).thenReturn(userListMock);
        ResponseEntity<List<User>> listUserController = userController.getAllUsers();
        Assertions.assertEquals(404,listUserController.getStatusCodeValue());
        Assertions.assertEquals("The collection Users is empty", listUserController.getBody());

    }

    @Test
    @Order(3)
    public void find_by_id_200(){

//        User userMockito = new User("user1", "user1@mail.com"
//                , "123asd", LocalDate.now());

        Mockito.when(userService.findUserById(Mockito.anyString())).thenReturn(userMockito);

        ResponseEntity<User> userResult = userController.findUserById("sdf");
        Assertions.assertEquals(200,userResult.getStatusCodeValue());

    }

    @Test
    @Order(4)
    @DisplayName("Update user")
    public void update_user(){

        UserDto userMockito = new UserDto("user1", "user1@mail.com"
                , "123asd");
        User userMockitoUpdated = new User(userMockito);
        Mockito.when(userService.updateUser("1",userMockito)).thenReturn(userMockitoUpdated);

        ResponseEntity<User> userResponseEntity = userController.updateUser("1", userMockito);
        Assertions.assertEquals(200,userResponseEntity.getStatusCodeValue());
        Assertions.assertTrue(userResponseEntity.getBody() != null);
    }
}