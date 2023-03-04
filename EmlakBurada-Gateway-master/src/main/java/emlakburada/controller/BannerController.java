package emlakburada.controller;

import emlakburada.client.BannerClient;
import emlakburada.model.request.BannerRequest;
import emlakburada.model.response.BannerResponse;
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
@RequestMapping(value = "/banners")
@RequiredArgsConstructor
public class BannerController {
    private final BannerClient bannerClient;

    @GetMapping
    public List<BannerResponse> getAllBanners() {
        return bannerClient.getAllBanners();
    }

    @PostMapping
    public BannerResponse createBanner(@RequestBody BannerRequest bannerRequest) {
        return bannerClient.createBanner(bannerRequest);
    }

    @PutMapping
    public BannerResponse updateBanner(@RequestBody BannerRequest bannerRequest) {
        return bannerClient.updateBanner(bannerRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteBanner(@PathVariable Integer id) {
        bannerClient.deleteBanner(id);
    }
}