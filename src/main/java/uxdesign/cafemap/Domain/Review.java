package uxdesign.cafemap.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Review {
    private int reviewId;
    private int memberId;
    private String nickname;
    private Date upload_date;
    private String content;
    private int reviewCount;
    private List<String> reviewImgList;
}
