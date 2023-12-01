package uxdesign.cafemap.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import uxdesign.cafemap.Common.Response.BaseResponse;
import uxdesign.cafemap.Domain.Review;
import uxdesign.cafemap.Dto.Request.CafeIdRequest;
import uxdesign.cafemap.Dto.Request.MemberIdRequest;
import uxdesign.cafemap.Dto.Request.MemberRequest;
import uxdesign.cafemap.Dto.Request.ReviewRequest;
import uxdesign.cafemap.Dto.Response.CafeListResponse;
import uxdesign.cafemap.Dto.Response.GetReviewResponse;
import uxdesign.cafemap.Dto.Response.PostReviewResponse;
import uxdesign.cafemap.Dto.Response.ReviewCountResponse;
import uxdesign.cafemap.Service.MemberService;
import uxdesign.cafemap.Service.ReviewService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;
    // 리뷰 작성
    @PostMapping("/")
    public BaseResponse<PostReviewResponse> postReview(@RequestBody @Valid ReviewRequest reviewRequest){
        log.info("[ReviewController.postReview]");
        return reviewService.postReview(reviewRequest);
    }

    // 리뷰 조회
    @GetMapping("/")
    public BaseResponse<GetReviewResponse> getReviews(@RequestBody @Valid CafeIdRequest cafeIdRequest){
        log.info("[ReviewController.getReviews]");
        return reviewService.getReviews(cafeIdRequest);
    }

    // 한 사람이 작성한 리뷰의 수
    @GetMapping("/count")
    public BaseResponse<ReviewCountResponse> getReviewCount(@RequestBody @Valid MemberIdRequest memberIdRequest){
        log.info("[ReviewController.getReviews]");
        return reviewService.getReviewCount(memberIdRequest);
    }
}