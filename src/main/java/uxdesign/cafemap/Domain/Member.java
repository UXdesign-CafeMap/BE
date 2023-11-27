package uxdesign.cafemap.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Member {
    private int memberId;
    private String email;
    private String password;

    public Member(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
