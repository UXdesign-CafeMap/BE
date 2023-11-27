package uxdesign.cafemap.Dto;

import lombok.*;
import uxdesign.cafemap.Domain.Cafe;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CafeListResponse {
    List<Cafe> cafeList;
}
