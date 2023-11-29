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

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewDao reviewDao;
    public BaseResponse<String> postReview(ReviewRequest reviewRequest){
        reviewDao.save(reviewRequest.getMemberId(), reviewRequest.getCafeId(), reviewRequest.getContent(), reviewRequest.getImgUrlList());
        return new BaseResponse<>("리뷰 작성에 성공하였습니다.");
    }

    public BaseResponse<List<Review>> getReviews(CafeIdRequest cafeIdRequest){
        List<Review> review = reviewDao.getReviews(cafeIdRequest.getCafeId());
        return new BaseResponse<>(review);
    }

    public BaseResponse<Integer> getReviewCount(MemberIdRequest memberIdRequest){
        int reviewCount = reviewDao.getReviewCount(memberIdRequest.getMemberId());
        return new BaseResponse<>(reviewCount);
    }
}
