package eu.codeacademy.eshop.user.service;

import eu.codeacademy.eshop.user.dto.UserDto;
import eu.codeacademy.eshop.user.entity.User;
import eu.codeacademy.eshop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void register(UserDto userDto) {
        userRepository.save(User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .password(userDto.getPassword()) //FIXME: do not save as plain text, for security reason!!!!
                .phoneNumber(userDto.getPhoneNumber())
                .zipCode(userDto.getZipCode())
                .build());
    }
}
