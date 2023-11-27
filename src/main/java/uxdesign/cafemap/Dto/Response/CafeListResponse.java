package uxdesign.cafemap.Dto.Response;

import lombok.*;
import uxdesign.cafemap.Domain.Cafe;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CafeListResponse {
    private List<Cafe> cafeList;
}
