package uxdesign.cafemap.Dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import uxdesign.cafemap.Domain.Member;
import uxdesign.cafemap.Domain.Review;
import uxdesign.cafemap.Dto.Response.MemberResponse;

import javax.sql.DataSource;
import java.util.Map;

@Slf4j
@Repository
public class MemberDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    public MemberResponse save(Member member) {
        String sql = "insert into member (email, password) values (:email, :password)";
        Map<String, String> param = Map.of("email", member.getEmail(),
                "password", member.getPassword());

        jdbcTemplate.update(sql, param);

        String returnSql = "select member_id from member where email=:email and password=:password";
        Map<String, String> returnParam = Map.of("email", member.getEmail(),
                "password", member.getPassword());

        RowMapper<MemberResponse> returnMapper = (rs, rowNum) -> {
            MemberResponse memberResponse = new MemberResponse();
            memberResponse.setMemberId(rs.getInt("member_id"));
            return memberResponse;
        };

        return jdbcTemplate.queryForObject(returnSql, returnParam, returnMapper);
    }

    public Boolean login(Member member) {
        String sql = "select exists(select * from member where email=:email and password=:password)";
        Map<String, String> param = Map.of("email", member.getEmail(),
                "password", member.getPassword());

        return jdbcTemplate.queryForObject(sql, param, Boolean.class);
    }
}
