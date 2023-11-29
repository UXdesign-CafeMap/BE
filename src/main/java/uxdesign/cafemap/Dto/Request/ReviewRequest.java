package uxdesign.cafemap.Dto.Request;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewRequest {
    private int memberId;
    private int cafeId;
    private String content;
    private List<String> imgUrlList;
}
