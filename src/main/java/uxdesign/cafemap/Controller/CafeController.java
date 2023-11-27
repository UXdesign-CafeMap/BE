package uxdesign.cafemap.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import uxdesign.cafemap.Common.Response.BaseResponse;
import uxdesign.cafemap.Dto.CafeIdRequest;
import uxdesign.cafemap.Dto.CafeListResponse;
import uxdesign.cafemap.Dto.MemberRequest;
import uxdesign.cafemap.Service.CafeService;
import uxdesign.cafemap.Service.MemberService;

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

    // 카페 이름 검색
}