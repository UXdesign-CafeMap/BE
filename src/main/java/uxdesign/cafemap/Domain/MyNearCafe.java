package uxdesign.cafemap.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyNearCafe {
    private int cafeId;
    private String name;
    private int totalSeat;
    private int remainSeat;
    private double longitude;
    private double latitude;
    private String distance;
    private String cafeImage;
}
