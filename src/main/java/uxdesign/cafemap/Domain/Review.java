package uxdesign.cafemap.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Review {
    private int memberId;
    private Date upload_date;
    private String content;
    private String reviewImg;
}
