package uxdesign.cafemap.Dto.Response;

import lombok.*;
import uxdesign.cafemap.Domain.Menu;
import uxdesign.cafemap.Domain.Review;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CafeDetailResponse {
    private int cafeId;
    private String name;
    private String volume;
    private int totalSeat;
    private int remainSeat;
    private int totalMultitap;
    private int remainMultitap;
    private String distance;
    private String address;
    private String onpeningHours;
    private String isOpen;
    private String cafeImage;
    private double longitude;
    private double latitude;
    private List<Menu> menus;
}
