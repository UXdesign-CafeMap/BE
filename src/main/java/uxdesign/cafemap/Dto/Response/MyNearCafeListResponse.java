package uxdesign.cafemap.Dto.Response;

import lombok.*;
import uxdesign.cafemap.Domain.MyNearCafe;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyNearCafeListResponse {
    private List<MyNearCafe> myNearCafeList;
}
