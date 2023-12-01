package uxdesign.cafemap.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uxdesign.cafemap.Common.Response.BaseResponse;
import uxdesign.cafemap.Dao.CafeDao;
import uxdesign.cafemap.Dao.MemberDao;
import uxdesign.cafemap.Dao.ReviewDao;
import uxdesign.cafemap.Domain.Member;
import uxdesign.cafemap.Domain.Review;
import uxdesign.cafemap.Dto.Request.CafeIdRequest;
import uxdesign.cafemap.Dto.Request.MemberIdRequest;
import uxdesign.cafemap.Dto.Request.ReviewRequest;
import uxdesign.cafemap.Dto.Response.GetReviewResponse;
import uxdesign.cafemap.Dto.Response.PostReviewResponse;
import uxdesign.cafemap.Dto.Response.ReviewCountResponse;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewDao reviewDao;
    public BaseResponse<PostReviewResponse> postReview(ReviewRequest reviewRequest){
        reviewDao.save(reviewRequest.getMemberId(), reviewRequest.getCafeId(), reviewRequest.getContent(), reviewRequest.getImgUrlList());
        PostReviewResponse response = new PostReviewResponse();
        response.setResponse("리뷰 작성에 성공하였습니다.");
        return new BaseResponse<>(response);
    }

    public BaseResponse<GetReviewResponse> getReviews(CafeIdRequest cafeIdRequest){
        GetReviewResponse review = reviewDao.getReviews(cafeIdRequest.getCafeId());
        return new BaseResponse<>(review);
    }

    public BaseResponse<ReviewCountResponse> getReviewCount(MemberIdRequest memberIdRequest){
        ReviewCountResponse response = reviewDao.getReviewCount(memberIdRequest.getMemberId());
        return new BaseResponse<>(response);
    }
}
