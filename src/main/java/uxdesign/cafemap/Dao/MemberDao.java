package uxdesign.cafemap.Dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import uxdesign.cafemap.Common.Exception.UserException;
import uxdesign.cafemap.Domain.Member;
import uxdesign.cafemap.Domain.Review;
import uxdesign.cafemap.Dto.Response.MemberResponse;
import uxdesign.cafemap.Dto.Response.SignInResponse;

import javax.sql.DataSource;
import java.util.Map;

import static uxdesign.cafemap.Common.Response.status.BaseExceptionResponseStatus.USER_NOT_FOUND;

@Slf4j
@Repository
public class MemberDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    public MemberResponse save(Member member) {
        String sql = "insert into member (email, password, nickname) values (:email, :password, :nickname)";
        Map<String, String> param = Map.of("email", member.getEmail(),
                "password", member.getPassword(),
                "nickname", member.getNickname());

        jdbcTemplate.update(sql, param);

        String returnSql = "select member_id from member where email=:email and password=:password and nickname=:nickname";
        Map<String, String> returnParam = Map.of("email", member.getEmail(),
                "password", member.getPassword(),
                "nickname", member.getNickname());

        RowMapper<MemberResponse> returnMapper = (rs, rowNum) -> {
            MemberResponse memberResponse = new MemberResponse();
            memberResponse.setMemberId(rs.getInt("member_id"));
            return memberResponse;
        };

        return jdbcTemplate.queryForObject(returnSql, returnParam, returnMapper);
    }

    public SignInResponse login(Member member) {
        String sql = "select exists(select * from member where email=:email and password=:password)";
        Map<String, String> param = Map.of("email", member.getEmail(),
                "password", member.getPassword());

        if (jdbcTemplate.queryForObject(sql, param, Boolean.class)) {
            String returnSql = "select member_id, email, nickname from member where email=:email and password=:password";
            Map<String, String> returnParam = Map.of("email", member.getEmail(),
                    "password", member.getPassword());

            RowMapper<SignInResponse> returnMapper = (rs, rowNum) -> {
                SignInResponse signInResponse = new SignInResponse();
                signInResponse.setMemberId(rs.getInt("member_id"));
                signInResponse.setEmail(rs.getString("email"));
                signInResponse.setNickname(rs.getString("nickname"));
                return signInResponse;
            };
            return jdbcTemplate.queryForObject(returnSql, returnParam, returnMapper);
        } else {
            throw new UserException(USER_NOT_FOUND);
        }
    }
}
