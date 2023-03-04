package emlakburada.controller;

import emlakburada.client.MessageClient;
import emlakburada.model.request.MessageRequest;
import emlakburada.model.response.MessageResponse;
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
@RequestMapping(value = "/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageClient messageClient;

    @GetMapping
    public List<MessageResponse> getAllMessages() {
        return messageClient.getAllMessages();
    }

    @PostMapping
    public MessageResponse createMessage(@RequestBody MessageRequest messageRequest) {
        return messageClient.createMessage(messageRequest);
    }

    @PutMapping
    public MessageResponse updateMessage(@RequestBody MessageRequest messageRequest) {
        return messageClient.updateMessage(messageRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Integer id) {
        messageClient.deleteMessage(id);
    }
}