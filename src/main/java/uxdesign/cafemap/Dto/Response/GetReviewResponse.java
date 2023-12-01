package uxdesign.cafemap.Dto.Response;

import lombok.*;
import uxdesign.cafemap.Domain.Review;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetReviewResponse {
    private List<Review> reviewList;
}
