package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import co.rivatech.nutrition.exception.InvalidResourceException;
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
        if (null != user.getBlockId() && user.getBlockId() == 0
                || null != user.getDistrictId() && user.getDistrictId() == 0
                || null != user.getTolaId() && user.getTolaId() == 0) {
            throw new InvalidResourceException(
                    "One of the values of the user block,district or tola is passed as 0 which " +
                            "violate the foreign id constraint. Please pass null.");
        }
        usersRepository.save(user);
        return user;
    }

    public User findByMobile(final BigInteger mobile) {
        return usersRepository.findByMobile(mobile)
                              .orElseThrow(() -> new ResourceNotFoundException(String.format(
                                      "User not found with mobile number %s",
                                      mobile)));
    }

    public void deleteById(final int userId) {
        usersRepository.deleteById(userId);
    }
}
