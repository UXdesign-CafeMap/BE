package uxdesign.cafemap.Dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import uxdesign.cafemap.Domain.Member;

import javax.sql.DataSource;
import java.util.Map;

@Slf4j
@Repository
public class MemberDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    public void save(Member member) {
        String sql = "insert into member (email, password) values (:email, :password)";
        Map<String, String> param = Map.of("email", member.getEmail(),
                "password", member.getPassword());

        jdbcTemplate.update(sql, param);
    }
}
