package uxdesign.cafemap.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cafe {
    private int cafeId;
    private String name;
    private int totalSeat;
    private int remainSeat;
    private String distance;
    private String review;
    private String cafeImage;
    private int reviewCount;
}
