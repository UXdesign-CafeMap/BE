package uxdesign.cafemap.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uxdesign.cafemap.Common.Response.BaseResponse;
import uxdesign.cafemap.Dao.MemberDao;
import uxdesign.cafemap.Domain.Member;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;

    public BaseResponse<String> signup(String email, String password){
        System.out.println(email);
        System.out.println(password);
        Member member = new Member(email, password);
        System.out.println(member.getEmail());
        System.out.println(member.getPassword());
        memberDao.save(member);
        return new BaseResponse<>("회원가입에 성공하였습니다.");
    }
}
