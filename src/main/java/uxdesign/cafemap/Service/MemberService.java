package uxdesign.cafemap.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uxdesign.cafemap.Common.Response.BaseResponse;
import uxdesign.cafemap.Dao.MemberDao;
import uxdesign.cafemap.Domain.Member;
import uxdesign.cafemap.Dto.Response.MemberResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;

    public BaseResponse<MemberResponse> signup(String email, String password){
        Member member = new Member(email, password);
        MemberResponse memberResponse = memberDao.save(member);
        return new BaseResponse<>(memberResponse);
    }
}
