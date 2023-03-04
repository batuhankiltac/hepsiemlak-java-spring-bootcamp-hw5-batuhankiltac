package emlakburada.client;

import emlakburada.model.request.AdvertRequest;
import emlakburada.model.response.AdvertResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "feign-client-advert", url = "http://localhost:8081")
public interface AdvertClient {

    @RequestMapping(value = "/adverts", method = RequestMethod.GET)
    List<AdvertResponse> getAllAdverts();

    @RequestMapping(value = "/adverts", method = RequestMethod.POST)
    AdvertResponse createAdvert(@RequestBody AdvertRequest advertRequest);

    @RequestMapping(value = "/adverts", method = RequestMethod.PUT)
    AdvertResponse updateAdvert(@RequestBody AdvertRequest advertRequest);

    @RequestMapping(value = "/adverts/{id}", method = RequestMethod.DELETE)
    void deleteAdvert(@PathVariable Integer id);
}