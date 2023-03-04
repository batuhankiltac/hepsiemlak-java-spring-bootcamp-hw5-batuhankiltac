package emlakburada.controller;

import emlakburada.client.AdvertClient;
import emlakburada.model.request.AdvertRequest;
import emlakburada.model.response.AdvertResponse;
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
@RequestMapping(value = "/adverts")
@RequiredArgsConstructor
public class AdvertController {
    private final AdvertClient advertClient;

    @GetMapping
    public List<AdvertResponse> getAllAdverts() {
        return advertClient.getAllAdverts();
    }

    @PostMapping
    public AdvertResponse createAdvert(@RequestBody AdvertRequest advertRequest) {
        return advertClient.createAdvert(advertRequest);
    }

    @PutMapping
    public AdvertResponse updateAdvert(@RequestBody AdvertRequest advertRequest) {
        return advertClient.updateAdvert(advertRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAdvert(@PathVariable Integer id) {
        advertClient.deleteAdvert(id);
    }
}