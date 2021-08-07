package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    @ApiOperation(value = "Adds a system user")
    public ResponseEntity<User> addSystemUser(@Nonnull @RequestBody User user) {
        return ResponseEntity.ok(usersService.addUser(user));
    }

    @GetMapping("/findByMobile/{mobile}")
    @ApiOperation(value = "Checks if the user exists by mobile number or not, returns true or false")
    public ResponseEntity<Boolean> findByMobileNumber(@RequestParam BigInteger mobile) {
        return ResponseEntity.ok(usersService.findByMobile(mobile));
    }

}
