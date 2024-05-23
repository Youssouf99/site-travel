package agency.travel.com.example.sitetravel.services.user;

import agency.travel.com.example.sitetravel.dtos.UserDto;
import agency.travel.com.example.sitetravel.entities.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);


}
