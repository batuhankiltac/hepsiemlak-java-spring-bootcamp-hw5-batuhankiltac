package emlakburada.client;

import emlakburada.model.request.UserRequest;
import emlakburada.model.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "feign-client-user", url = "http://localhost:8081")
public interface UserClient {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    List<UserResponse> getAllUsers();

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    UserResponse createUser(@RequestBody UserRequest userRequest);

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    UserResponse updateUser(@RequestBody UserRequest userRequest);

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable Integer id);
}