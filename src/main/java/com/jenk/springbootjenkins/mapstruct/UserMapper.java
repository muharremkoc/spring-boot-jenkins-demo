package com.jenk.springbootjenkins.mapstruct;

import com.jenk.springbootjenkins.dto.UserDTO;
import com.jenk.springbootjenkins.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserMapper {

    @Mappings({
            @Mapping(target = "name",source = "name"),
            @Mapping(target = "job",source = "job")
    })
    User userDTOtoUser(UserDTO userDTO);

    UserDTO userToUserDTO(User user);
}
