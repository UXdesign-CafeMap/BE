package uxdesign.cafemap.Dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import uxdesign.cafemap.Domain.Cafe;
import uxdesign.cafemap.Domain.Member;
import uxdesign.cafemap.Domain.Review;
import uxdesign.cafemap.Dto.Response.GetReviewResponse;
import uxdesign.cafemap.Dto.Response.ReviewCountResponse;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class ReviewDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    public ReviewDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void save(int mamberId, int cafeId, String content, List<String> imgUrlList) {
        String sql = "insert into review (member_id, cafe_id, content) values (:memberId, :cafeId, :content)";
        Map<String, Object> param = Map.of("memberId", mamberId,
                "cafeId", cafeId,
                "content", content);

        jdbcTemplate.update(sql, param);

        String returnSql = "select last_insert_id()";
        Map<String, Object> returnParam = Map.of();

        int reviewId =  jdbcTemplate.queryForObject(returnSql, returnParam, Integer.class);

        for (String imgUrl : imgUrlList) {
            String reviewImgSql = "insert into reviewImage (review_id, image) values (:reviewId, :image)";
            Map<String, Object> reviewImgParam = Map.of("reviewId", reviewId,
                    "image", imgUrl);

            jdbcTemplate.update(reviewImgSql, reviewImgParam);
        }

    }

    public GetReviewResponse getReviews(int cafeId) {
        String sql = "select * from review where cafe_id=:cafeId";
        Map<String, Object> param = Map.of("cafeId", cafeId);

        RowMapper<Review> mapper = (rs, rowNum) -> {
            Review review = new Review();
            review.setReviewId(rs.getInt("review_id"));
            review.setMemberId(rs.getInt("member_id"));
            review.setContent(rs.getString("content"));
            review.setUpload_date(rs.getDate("upload_at"));
            return review;
        };

        List<Review> reviewList = jdbcTemplate.query(sql, param, mapper);

        for (Review review1 : reviewList) {
            String reviewImgSql = "select image from reviewImage where review_id=:reviewId";
            Map<String, Object> reviewImgParam = Map.of("reviewId", review1.getReviewId());

            RowMapper<String> reviewImgMapper = (rs, rowNum) -> {
                return rs.getString("image");
            };

            List<String> reviewImg = jdbcTemplate.query(reviewImgSql, reviewImgParam, reviewImgMapper);

            review1.setReviewImgList(reviewImg);
        }

        GetReviewResponse getReviewResponse = new GetReviewResponse();
        getReviewResponse.setReviewList(reviewList);

        return getReviewResponse;
    }

    public ReviewCountResponse getReviewCount(int memberId) {
        String sql = "select count(*) from review where member_id=:memberId";
        Map<String, Object> param = Map.of("memberId", memberId);

        int count = jdbcTemplate.queryForObject(sql, param, Integer.class);
        ReviewCountResponse response = new ReviewCountResponse();
        response.setCount(count);

        return response;
    }

    public int getCafeReviewCount(int cafeId) {
        String sql = "select count(*) from review where cafe_id=:cafeId";
        Map<String, Object> param = Map.of("cafeId", cafeId);

        return jdbcTemplate.queryForObject(sql, param, Integer.class);
    }
}
