package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.User;
import co.rivatech.nutrition.repository.UsersRepository;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Iterable<User> iterable = usersRepository.findAll();
        iterable.forEach(users::add);
        return users;
    }

    public User addUser(final User user) {
        usersRepository.save(user);
        return user;
    }

    public User findByMobile(final BigInteger mobile) {
        return usersRepository.findByMobile(mobile)
                              .orElseThrow(() -> new ResourceNotFoundException(String.format(
                                      "User not found with mobile number %s",
                                      mobile)));
    }
}
