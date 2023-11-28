package uxdesign.cafemap.Dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import uxdesign.cafemap.Domain.Cafe;
import uxdesign.cafemap.Domain.Member;
import uxdesign.cafemap.Domain.Review;

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

    public void save(int mamberId, int cafeId, String content) {
        String sql = "insert into review (member_id, cafe_id, content, reviewImg) values (:memberId, :cafeId, :content, :reviewImg)";
        Map<String, Object> param = Map.of("memberId", mamberId,
                "cafeId", cafeId,
                "content", content,
                "reviewImg", "dsfdfsdf");

        jdbcTemplate.update(sql, param);
    }

    public List<Review> getReviews(int cafeId) {
        String sql = "select * from review where cafe_id=:cafeId";
        Map<String, Object> param = Map.of("cafeId", cafeId);

        RowMapper<Review> mapper = (rs, rowNum) -> {
            Review review = new Review();
            review.setMemberId(rs.getInt("member_id"));
            review.setContent(rs.getString("content"));
            review.setReviewImg(rs.getString("reviewImg"));
            review.setUpload_date(rs.getDate("upload_at"));
            return review;
        };

        return jdbcTemplate.query(sql, param, mapper);
    }

    public int getReviewCount(int memberId) {
        String sql = "select count(*) from review where member_id=:memberId";
        Map<String, Object> param = Map.of("memberId", memberId);

        return jdbcTemplate.queryForObject(sql, param, Integer.class);
    }
}
