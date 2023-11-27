package uxdesign.cafemap.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cafe {
    private int cafeId;
    private String volume;
    private int totalSeat;
    private int remainSeat;
    private int totalMultitap;
    private int remainMultitap;
    private String address;
    private String onpeningHours;
    private String isOpen;
    private double longitude;
    private double latitude;
}
