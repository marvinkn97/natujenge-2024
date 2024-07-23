package dev.marvin.seriviceImpl;

import com.sun.jdi.request.DuplicateRequestException;
import dev.marvin.model.User;
import dev.marvin.repository.UserRepository;
import dev.marvin.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public boolean create(String username, String password) {
        log.info("Inside create method of UserServiceImpl");

        try {
            User user = User.builder()
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .build();

            return userRepository.save(user).getId() > 0;

        } catch (DataIntegrityViolationException e) {
            log.info("DataIntegrityViolationException: {}", e.getMessage(), e);
            throw new DuplicateRequestException("Username already taken");

        } catch (Exception e) {
            log.info("Error occurred in create method of UserServiceImpl: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to process request");
        }

    }

}

