package org.ada.school.user.service;

import org.ada.school.user.controller.dto.UserDto;
import org.ada.school.user.model.User;
import org.ada.school.user.repository.UserDocument;

import java.util.List;


public interface UserService
{
    User create( UserDto userDto );

    User findById(String id );

    List<UserDocument> all();

    boolean deleteById( String id );

    User update( UserDto userDto, String id );
}
