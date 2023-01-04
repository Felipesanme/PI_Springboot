package com.bookingsproject.bookingsproject.service.user;

import com.bookingsproject.bookingsproject.dto.user.UserDto;
import com.bookingsproject.bookingsproject.model.User;
import com.bookingsproject.bookingsproject.repository.user.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @Order(1)
    public void find_all_users(){

        List<User> userListMock = new ArrayList<>();
        userListMock.add(new User("felipex", "felipex@mail.com"
                , "felipex123"));
        userListMock.add(new User("dianax", "dianax@mail.com"
                , "dianax123"));
        userListMock.add(new User("miguelx", "miguelx@mail.com"
                , "miguelx123"));
        Mockito.when(userRepository.findAll()).thenReturn(userListMock);

        List<User> userListResult = userService.findAll();

        List<User> userListExpected = new ArrayList<>();
        userListExpected.add(new User("felipex", "felipex@mail.com"
                , "felipex123"));
        userListExpected.add(new User("dianax", "dianax@mail.com"
                , "dianax123"));
        userListExpected.add(new User("miguelx", "miguelx@mail.com"
                , "miguelx123"));

        Assertions.assertEquals(userListExpected, userListResult);

    }

    @Test
    @Order(2)
    public void find_user_by_id(){
        User userMock = new User("pablox", "pablox@mail.com"
                , "pablox123");
        Mockito.when(userRepository.findById("pagc")).thenReturn(userMock);

        User userResult = userService.findById("pagc");

        User userExpected = new User("pablox", "pablox@mail.com"
                , "pablox123");

        Assertions.assertEquals(userExpected.getEmail(), userResult.getEmail());
    }

    @Test
    @Order(3)
    public void create_user(){
        UserDto userInput = new UserDto("lio", "lio@mail.com"
                , "lio123");
        User userMock = new User(userInput);
        Mockito.when(userRepository.createUser(Mockito.any(UserDto.class)))
                .thenReturn(userMock);

        UserDto userInput2 = new UserDto("lio2", "lio2@mail.com"
                , "lio1231");

        User userResult = userService.createUser(userInput2);
        User userExpected = new User("lio3", "lio3@mail.com"
                , "lio12312");

        Assertions.assertTrue(userResult.getEmail().equals("lio@mail.com"));
    }

    @Test
    @Order(4)
    public void update_user_by_id () {

        UserDto userDtoMock = new UserDto("Dibu","Dibu@mail.com","Dibu23");
        User userMock = new User(userDtoMock);

        Mockito.when(userRepository.updateUser("1", userDtoMock)).thenReturn(userMock);

        User userResult = userService.updateUser("1", userDtoMock);

        Assertions.assertEquals(userMock, userResult);
    }

    @Test
    @Order(5)
    public void  delete_user_by_id() {
        Mockito.when(userRepository.deleteUser("1")).thenReturn(true);

        Boolean userResult = userService.deleteUser("1");

        Assertions.assertEquals(true, userResult);
    }

    @Test
    @Order(6)
    public void  find_user_by_email( ) {

        User userEmailMock = new User("Enzo","enzo@mail","enzo24@mail.com");

        Mockito.when(userRepository.findByEmail("enzo24@mail.com")).thenReturn(userEmailMock);

        User userByEmailResult = userService.findByEmail("enzo24@mail.com");
        User userExpected = new User("Enzo","enzo@mail","enzo24@mail.com");
        Assertions.assertEquals(userExpected, userByEmailResult);
    }

}