package emlakburada.controller;

import emlakburada.client.UserClient;
import emlakburada.model.request.UserRequest;
import emlakburada.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserClient userClient;

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userClient.getAllUsers();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userClient.createUser(userRequest);
    }

    @PutMapping
    public UserResponse updateUser(@RequestBody UserRequest userRequest) {
        return userClient.updateUser(userRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userClient.deleteUser(id);
    }
}