package agency.travel.com.example.sitetravel.mappers;

import agency.travel.com.example.sitetravel.dtos.UserDto;
import agency.travel.com.example.sitetravel.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

    List<UserDto> usersToUserDtos(List<User> users);

    User userDtoToUser(UserDto userDto);


    List<User> userDtosToUsers(List<UserDto> userDtos);



}
