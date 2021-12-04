package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.User;
import co.rivatech.nutrition.service.UsersService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 07/08/2021
 */
@RestController
@RequestMapping("/v1/users")
public class UsersResource {

    @Autowired
    private UsersService usersService;

    @GetMapping("/")
    @ApiOperation(value = "Get all users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add/update a system user")
    public ResponseEntity<User> addSystemUser(@Nonnull @RequestBody User user) {
        return ResponseEntity.ok(usersService.addUser(user));
    }

    @GetMapping("/findByMobile/{mobile}")
    @ApiOperation(value = "Returns user details by mobile number or else throw 404.")
    public ResponseEntity<User> findByMobileNumber(@RequestParam BigInteger mobile) {
        return ResponseEntity.ok(usersService.findByMobile(mobile));
    }

    @DeleteMapping("/deleteById/{userId}")
    @ApiOperation(value = "Delete user by id.",
                  notes = "Successfully deletes user data or throws exception")
    public ResponseEntity<?> deleteByUserId(@PathVariable int userId) {
        usersService.deleteById(userId);
        return ResponseEntity.ok().build();
    }

}
