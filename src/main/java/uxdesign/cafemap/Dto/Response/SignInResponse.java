package uxdesign.cafemap.Dto.Response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignInResponse {
    private int memberId;
    private String email;
    private String nickname;
}
