package emlakburada.client;

import emlakburada.model.request.BannerRequest;
import emlakburada.model.response.BannerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "feign-client-banner", url = "http://localhost:8082")
public interface BannerClient {

    @RequestMapping(value = "/banners", method = RequestMethod.GET)
    List<BannerResponse> getAllBanners();

    @RequestMapping(value = "/banners", method = RequestMethod.POST)
    BannerResponse createBanner(@RequestBody BannerRequest bannerRequest);

    @RequestMapping(value = "/banners", method = RequestMethod.PUT)
    BannerResponse updateBanner(@RequestBody BannerRequest bannerRequest);

    @RequestMapping(value = "/banners/{id}", method = RequestMethod.DELETE)
    void deleteBanner(@PathVariable Integer id);
}