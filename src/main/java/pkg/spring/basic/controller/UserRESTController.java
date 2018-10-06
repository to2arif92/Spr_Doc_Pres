package pkg.spring.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pkg.spring.basic.model.auth.User;
import pkg.spring.basic.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
/*@RequestMapping(
        value = "/user",    // suffix/root URI
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = {MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE}
)*/
/**
 * @implNote Use status codes carefully otherwise browser/ js may not render/process the content
 */
public class UserRESTController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.listUsers();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void removeUser(@PathVariable String username){
        userService.removeUser(username);
    }
}
