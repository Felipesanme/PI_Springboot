package com.bookings.bookings.service;

import com.bookings.bookings.model.User;
import com.bookings.bookings.model.UserDto;
import com.bookings.bookings.repository.UserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepositoryImpl userRepository;

    @InjectMocks
    private UserServiceImpl userService;

//    @BeforeEach
//    public void setUp(){
//        userService = new UserServiceImpl(userRepository);
//    }

    @Test
    public void get_all_users(){

        List<User> userListMock = new ArrayList<>();
        userListMock.add(new User("user1","user1@mail.com","clave123"));
        userListMock.add(new User("user12","user12@mail.com","clave1231"));
        userListMock.add(new User("user123","user123@mail.com","clave12312"));
        Mockito.when(userRepository.getAllUsers()).thenReturn(userListMock);

        List<User> userListResult = userService.getAllUsers();

        List<User> userListExpected = new ArrayList<>();
        userListExpected.add(new User("user1","user1@mail.com","clave123"));
        userListExpected.add(new User("user12","user12@mail.com","clave1231"));
        userListExpected.add(new User("user123","user123@mail.com","clave12312"));

        Assertions.assertEquals(userListExpected,userListMock);

    }

    @Test
    public void find_user_by_id(){
        User userMock = new User("user1","user1@mail.com","clave123");
        Mockito.when(userRepository.findUserById("asdfgh")).thenReturn(userMock);
        User userResult = userService.findUserById("asdfgh");
        User userExpected = new User("user1","user1@mail.com","clave123");
        Assertions.assertEquals(userExpected,userResult);
        Assertions.assertEquals(userExpected.getEmail(),userResult.getEmail());

    }

    @Test
    public void create_user(){
        UserDto userInput = new UserDto("user1","user1@mail.com","clave123");
        User userMock =new User(userInput);
        Mockito.when(userRepository.createUser(Mockito.any(UserDto.class))).thenReturn(userMock);

        UserDto userInput2 = new UserDto("user2", "user2@mail.com"
                , "123asd");

        User userResult = userService.createUser(userInput2);
        User userExpected = new User("user1","user1@mail.com","clave123");

        Assertions.assertTrue(userResult.getEmail().equals("user1@mail.com"));
    }

}