package by.overone.it.service;

import by.overone.it.pojo.User;
import by.overone.it.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
