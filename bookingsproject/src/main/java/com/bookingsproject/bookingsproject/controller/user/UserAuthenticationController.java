package com.bookingsproject.bookingsproject.controller.user;

import com.bookingsproject.bookingsproject.dto.user.UserLoginDto;
import com.bookingsproject.bookingsproject.dto.user.UserTokenDto;
import com.bookingsproject.bookingsproject.model.User;
import com.bookingsproject.bookingsproject.security.user.jwt.UserOperationJwt;
import com.bookingsproject.bookingsproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;


@RestController
@RequestMapping("/v0/user_auth")
public class UserAuthenticationController {

    private final UserOperationJwt userOperationJwt;
    private final UserService userService;

    @Autowired
    public UserAuthenticationController(UserOperationJwt userOperationJwt, UserService userService) {
        this.userOperationJwt = userOperationJwt;
        this.userService = userService;
    }
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<UserTokenDto> generateJwt(@RequestBody UserLoginDto userLogintDto){
        User userFound = userService.findByEmail(userLogintDto.getEmail());
        if (userFound != null){
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogintDto.getEmail(), userLogintDto.getPassword()));
            Calendar dateExpiration = Calendar.getInstance();
            dateExpiration.add(Calendar.MINUTE, 20);
            String jwt = userOperationJwt.generateJwt(userFound, dateExpiration);
            UserTokenDto userTokenDto = new UserTokenDto(jwt, dateExpiration.getTime());
            return new ResponseEntity<>(userTokenDto, HttpStatus.OK);
        }else {
            return new ResponseEntity("email " + userLogintDto.getEmail()
                    + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
