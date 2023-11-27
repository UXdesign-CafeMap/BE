package uxdesign.cafemap.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberRequest {
    private String email;
    private String password;
}