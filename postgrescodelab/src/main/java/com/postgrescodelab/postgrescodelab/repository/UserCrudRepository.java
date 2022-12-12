package com.postgrescodelab.postgrescodelab.repository;

import com.postgrescodelab.postgrescodelab.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCrudRepository extends JpaRepository <UserDto,Long>{
}
