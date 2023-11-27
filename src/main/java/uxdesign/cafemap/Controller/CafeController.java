package uxdesign.cafemap.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.web.bind.annotation.*;
import uxdesign.cafemap.Common.Response.BaseResponse;
import uxdesign.cafemap.Dto.Request.CafeIdRequest;
import uxdesign.cafemap.Dto.Request.SearchRequest;
import uxdesign.cafemap.Dto.Response.CafeDetailResponse;
import uxdesign.cafemap.Dto.Response.CafeListResponse;
import uxdesign.cafemap.Dto.Request.LocationRequest;
import uxdesign.cafemap.Dto.Response.MarkerCafeResponse;
import uxdesign.cafemap.Dto.Response.MyNearCafeListResponse;
import uxdesign.cafemap.Service.CafeService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe")
public class CafeController {
    private final CafeService cafeService;
    // 카페 전체 조회
    @GetMapping("/")
    public BaseResponse<CafeListResponse> getCafes(){
        log.info("[CafeController.getCafes]");
        return cafeService.getCafes();
    }

    // 카페 조회
    @GetMapping("/detail")
    public BaseResponse<CafeDetailResponse> getCafeDetail(@RequestBody CafeIdRequest cafeIdRequest){
        log.info("[CafeController.getCafeDetail]");
        return cafeService.getCafeDetail(cafeIdRequest);
    }

    // 마커 클릭했을 떄 카페 조회
    @GetMapping("/marker")
    public BaseResponse<MarkerCafeResponse> getCafeMarker(@RequestBody LocationRequest locationRequest){
        log.info("[CafeController.getCafeMarker]");
        return cafeService.getCafeMarker(locationRequest);
    }

    // 카페 이름 검색
    @GetMapping("/search")
    public BaseResponse<CafeListResponse> searchCafe(@RequestBody SearchRequest searchRequest){
        log.info("[CafeController.searchCafe]");
        return cafeService.searchCafe(searchRequest);
    }
}