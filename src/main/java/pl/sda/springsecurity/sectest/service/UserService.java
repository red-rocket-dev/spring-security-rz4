package pl.sda.springsecurity.sectest.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.springsecurity.sectest.model.UserEntity;
import pl.sda.springsecurity.sectest.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //TODO: optional
        UserEntity byLogin = userRepository.findByLogin(username);
        if (byLogin == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return byLogin;
    }
}
