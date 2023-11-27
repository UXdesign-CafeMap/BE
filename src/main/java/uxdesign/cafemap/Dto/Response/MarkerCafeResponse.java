package uxdesign.cafemap.Dto.Response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MarkerCafeResponse {
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
    private String cafeImage;
}
