package uxdesign.cafemap.Dto.Request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewRequest {
    private int memberId;
    private int cafeId;
    private String content;
}
