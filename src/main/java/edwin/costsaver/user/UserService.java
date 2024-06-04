package edwin.costsaver.user;

import edwin.costsaver.exception.InvalidInputException;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user) throws InvalidInputException;

    void deleteUser(Long userId);
}
