package uxdesign.cafemap.Dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import uxdesign.cafemap.Domain.Cafe;
import uxdesign.cafemap.Domain.Menu;
import uxdesign.cafemap.Dto.Response.CafeDetailResponse;
import uxdesign.cafemap.Dto.Response.MarkerCafeResponse;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class CafeDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final ReviewDao reviewDao;
    public CafeDao(DataSource dataSource, ReviewDao reviewDao) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.reviewDao = reviewDao;
    }

    public List<Cafe> getCafes() {
        String sql = "select * from cafe";

        RowMapper<Cafe> mapper = (rs, rowNum) -> {
            Cafe cafe = new Cafe();
            cafe.setName(rs.getString("name"));
            cafe.setCafeId(rs.getInt("cafe_id"));
            cafe.setTotalSeat(rs.getInt("totalSeat"));
            cafe.setRemainSeat(rs.getInt("remainSeat"));
            cafe.setCafeImage(rs.getString("cafeImg"));
            cafe.setDistance(rs.getString("distance"));
            cafe.setReview(rs.getString("review"));
            cafe.setReviewCount(reviewDao.getCafeReviewCount(rs.getInt("cafe_id")));
            return cafe;
        };

        List<Cafe> cafeList = jdbcTemplate.query(sql, mapper);

        return cafeList;
    }

    public List<Cafe> getCafesByName(String name) {
        System.out.println(name);
        String sql = "SELECT * FROM cafe WHERE name LIKE :name";
//        Map<String, String> param = Map.of("name", name);

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("name", "%" + name + "%");

        RowMapper<Cafe> mapper = (rs, rowNum) -> {
            Cafe cafe = new Cafe();
            cafe.setName(rs.getString("name"));
            cafe.setCafeId(rs.getInt("cafe_id"));
            cafe.setTotalSeat(rs.getInt("totalSeat"));
            cafe.setRemainSeat(rs.getInt("remainSeat"));
            cafe.setCafeImage(rs.getString("cafeImg"));
            cafe.setDistance(rs.getString("distance"));
            cafe.setReview(rs.getString("review"));
            return cafe;
        };

        List<Cafe> cafeList = jdbcTemplate.query(sql, parameters, mapper);

        return cafeList;
    }

    public CafeDetailResponse getCafeDetail(int cafeId) {
        String sql = "select * from cafe where cafe_id=:cafe_id";
        Map<String, Object> param = Map.of("cafe_id", cafeId);

        RowMapper<CafeDetailResponse> mapper = (rs, rowNum) -> {
            CafeDetailResponse cafeDetail = new CafeDetailResponse();
            cafeDetail.setName(rs.getString("name"));
            cafeDetail.setCafeId(rs.getInt("cafe_id"));
            cafeDetail.setVolume(rs.getString("volume"));
            cafeDetail.setTotalSeat(rs.getInt("totalSeat"));
            cafeDetail.setRemainSeat(rs.getInt("remainSeat"));
            cafeDetail.setTotalMultitap(rs.getInt("totalMultitap"));
            cafeDetail.setRemainMultitap(rs.getInt("remainMultitap"));
            cafeDetail.setAddress(rs.getString("address"));
            cafeDetail.setCafeImage(rs.getString("cafeImg"));
            cafeDetail.setDistance(rs.getString("distance"));
            cafeDetail.setOnpeningHours(rs.getString("openingHours"));
            cafeDetail.setIsOpen(rs.getString("isOpen"));
            cafeDetail.setLongitude(rs.getDouble("longitude"));
            cafeDetail.setLatitude(rs.getDouble("latitude"));
            return cafeDetail;
        };

        CafeDetailResponse cafeDetailResponse = jdbcTemplate.queryForObject(sql, param, mapper);


        String menuSql = "select * from cafe a join menu b on a.cafe_id=b.cafe_id where a.cafe_id=:cafe_id";
        Map<String, Object> menuParam = Map.of("cafe_id", cafeId);

        RowMapper<Menu> menuMapper = (rs, rowNum) -> {
            Menu menu = new Menu();
            menu.setMenuName(rs.getString("menu_name"));
            menu.setMenuPrice(rs.getString("price"));
            return menu;
        };

        List<Menu> menu = jdbcTemplate.query(menuSql, menuParam, menuMapper);

        cafeDetailResponse.setMenus(menu);

        return cafeDetailResponse;
    }

    public MarkerCafeResponse getCafeMarker(double longitude, double latitude) {
        String sql = "select * from cafe where longitude=:longitude and latitude=:latitude";
        Map<String, Object> param = Map.of("longitude", longitude,
                "latitude", latitude);

        RowMapper<MarkerCafeResponse> mapper = (rs, rowNum) -> {
            MarkerCafeResponse markerCafeResponse = new MarkerCafeResponse();
            markerCafeResponse.setName(rs.getString("name"));
            markerCafeResponse.setCafeId(rs.getInt("cafe_id"));
            markerCafeResponse.setVolume(rs.getString("volume"));
            markerCafeResponse.setTotalSeat(rs.getInt("totalSeat"));
            markerCafeResponse.setRemainSeat(rs.getInt("remainSeat"));
            markerCafeResponse.setTotalMultitap(rs.getInt("totalMultitap"));
            markerCafeResponse.setRemainMultitap(rs.getInt("remainMultitap"));
            markerCafeResponse.setAddress(rs.getString("address"));
            markerCafeResponse.setCafeImage(rs.getString("cafeImg"));
            markerCafeResponse.setDistance(rs.getString("distance"));
            markerCafeResponse.setOnpeningHours(rs.getString("openingHours"));

            return markerCafeResponse;
        };

        MarkerCafeResponse markerCafeResponse = jdbcTemplate.queryForObject(sql, param, mapper);

        return markerCafeResponse;
    }


}
