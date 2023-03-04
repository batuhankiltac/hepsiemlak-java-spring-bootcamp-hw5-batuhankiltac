package emlakburada.client;

import emlakburada.model.request.MessageRequest;
import emlakburada.model.response.MessageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "feign-client-message", url = "http://localhost:8081")
public interface MessageClient {

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    List<MessageResponse> getAllMessages();

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    MessageResponse createMessage(@RequestBody MessageRequest messageRequest);

    @RequestMapping(value = "/messages", method = RequestMethod.PUT)
    MessageResponse updateMessage(@RequestBody MessageRequest messageRequest);

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.DELETE)
    void deleteMessage(@PathVariable Integer id);
}