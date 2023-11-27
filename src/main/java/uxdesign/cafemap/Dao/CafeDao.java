package uxdesign.cafemap.Dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import uxdesign.cafemap.Domain.Cafe;
import uxdesign.cafemap.Domain.Member;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
public class CafeDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    public CafeDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Cafe> getCafes() {
        String sql = "select * from cafe";

        RowMapper<Cafe> mapper = (rs, rowNum) -> {
            Cafe cafe = new Cafe();
            cafe.setCafeId(rs.getInt("cafe_id"));
            cafe.setAddress(rs.getString("address"));
            cafe.setVolume(rs.getString("volume"));
            cafe.setIsOpen(rs.getString("isOpen"));
            cafe.setOnpeningHours(rs.getString("openingHours"));
            cafe.setTotalSeat(rs.getInt("totalSeat"));
            cafe.setRemainSeat(rs.getInt("remainSeat"));
            cafe.setTotalMultitap(rs.getInt("totalMultitap"));
            cafe.setRemainMultitap(rs.getInt("remainMultitap"));
            cafe.setLatitude(rs.getInt("latitude"));
            cafe.setLongitude(rs.getInt("longitude"));
            return cafe;
        };

        return jdbcTemplate.query(sql, mapper);
    }
}
