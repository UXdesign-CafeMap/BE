package uxdesign.cafemap.Dto.Request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LocationRequest {
    private double latitude;
    private double longitude;
}
