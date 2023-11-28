package uxdesign.cafemap.Dto.Response;

import lombok.*;
import uxdesign.cafemap.Domain.Review;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewResponse {
    private List<Review> reviewList;
}