package eu.codeacademy.eshop.user.service;

import eu.codeacademy.eshop.user.dto.UserDto;
import eu.codeacademy.eshop.user.entity.User;
import eu.codeacademy.eshop.user.mapper.UserMapper;
import eu.codeacademy.eshop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmailWithAuthorities(username)
                .map(userMapper::toDto)
                .orElseThrow(() -> new UsernameNotFoundException("'" + username + "' not found!"));
    }
}
