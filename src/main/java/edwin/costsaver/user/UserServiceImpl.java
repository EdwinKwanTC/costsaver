package edwin.costsaver.user;

import edwin.costsaver.exception.InvalidInputException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        return optionalUser.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) throws InvalidInputException {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if(existingUser == null) {
            throw new InvalidInputException("invalid input");
        }
        existingUser.setUsername(user.getUsername());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
