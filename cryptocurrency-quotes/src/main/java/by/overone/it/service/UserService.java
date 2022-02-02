package by.overone.it.service;

import by.overone.it.pojo.User;
import by.overone.it.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public User getUserById(String id) {
        return userRepository.getById(id);
    }

    public void updateCryptoPrice(String price, String id) {
        userRepository.updateCryptoPrice(price, id);
    }

    public void updateCryptoSymbol(String symbol, String id) {
        userRepository.updateCryptoSymbol(symbol, id);
    }

    public List<User> getUsersByCryptoSymbol(String symbol) {
        return userRepository.getUsersByCryptoSymbol(symbol);
    }
}
