package com.bookingsproject.bookingsproject.controller.user;

import com.bookingsproject.bookingsproject.dto.user.UserDto;
import com.bookingsproject.bookingsproject.model.User;
import com.bookingsproject.bookingsproject.service.user.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    @Order(1)
    public void find_all_users_200() {

        List<User> userListMock = new ArrayList<>();
        userListMock.add(new User("Lio ", "lio@mail.com", "lio10"));
        userListMock.add(new User( "Dibu", "Dibu@mail", "dibu23"));

        Mockito.when(userService.findAll()).thenReturn(userListMock);

        ResponseEntity<List<User>> listUsersResultController = userController.findAll();
        Assertions.assertEquals(200, listUsersResultController.getStatusCodeValue());
    }

    @Test
    @Order(2)
    public void find_all_users_404() {

        List<User> userListMock = new ArrayList<>();

        Mockito.when(userService.findAll()).thenReturn(userListMock);

        ResponseEntity<List<User>> listUsersResultController = userController.findAll();
        Assertions.assertEquals(404, listUsersResultController.getStatusCodeValue());
    }

    @Test
    @Order(3)
    public void find_user_by_id_200() {

        User userMock = new User("Lio ", "lio@mail.com", "lio10" );

        Mockito.when(userService.findById("3_10")).thenReturn(userMock);

        ResponseEntity<User> usersResultController = userController.findById("3_10");
        Assertions.assertEquals(200, usersResultController.getStatusCodeValue());
    }

    @Test
    @Order(4)
    public void find_user_by_id_404() {

        Mockito.when(userService.findById(Mockito.anyString())).thenReturn(null);

        ResponseEntity<User> usersResultController = userController.findById("3_10");
        Assertions.assertEquals(404, usersResultController.getStatusCodeValue());
    }

    @Test
    @Order(5)
    public void create_user_201() {

        UserDto userDtoMock = new UserDto("Lio ", "lio@mail.com", "lio10");
        User userMock = new User(userDtoMock);

        Mockito.when(userService.createUser(userDtoMock)).thenReturn(userMock);

        ResponseEntity<User> userResult = userController.createUser(userDtoMock);
        Assertions.assertTrue(201 == userResult.getStatusCodeValue());
    }

    @Test
    @Order(6)
    public void update_user_by_id_200() {

        UserDto userDtoMock = new UserDto("Lio ", "lio@mail.com", "lio10");
        User userMock = new User(userDtoMock);

        Mockito.when(userService.updateUser("3_10", userDtoMock)).thenReturn(userMock);

        ResponseEntity<User> userUpdatedResult = userController.updateUser("3_10", userDtoMock);
        Assertions.assertTrue(200 == userUpdatedResult.getStatusCodeValue());
        Assertions.assertTrue(userUpdatedResult.getBody() != null);
    }

    @Test
    @Order(7)
    public void delete_user_by_id_200() {

        Mockito.when(userService.deleteUser("3_10")).thenReturn(true);

        ResponseEntity<Boolean> userResultController = userController.deleteUser("3_10");
        Assertions.assertEquals(200, userResultController.getStatusCodeValue());
    }

    @Test
    @Order(8)
    public void delete_user_by_id_404() {

        Mockito.when(userService.deleteUser(Mockito.anyString())).thenReturn(false);

        ResponseEntity<Boolean> userResultController = userController.deleteUser("3_10");
        Assertions.assertEquals(404, userResultController.getStatusCodeValue());
    }


}