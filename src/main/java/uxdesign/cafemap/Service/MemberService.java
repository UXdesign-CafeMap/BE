package uxdesign.cafemap.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uxdesign.cafemap.Common.Exception.UserException;
import uxdesign.cafemap.Common.Response.BaseResponse;
import uxdesign.cafemap.Dao.MemberDao;
import uxdesign.cafemap.Domain.Member;
import uxdesign.cafemap.Dto.Response.MemberResponse;
import uxdesign.cafemap.Dto.Response.SignInResponse;

import static uxdesign.cafemap.Common.Response.status.BaseExceptionResponseStatus.USER_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;

    public BaseResponse<MemberResponse> signup(String email, String password, String nickname){
        Member member = new Member(email, password, nickname);
        MemberResponse memberResponse = memberDao.save(member);
        return new BaseResponse<>(memberResponse);
    }

    public BaseResponse<SignInResponse> login(String email, String password){
        Member member = new Member(email, password);

        return new BaseResponse<>(memberDao.login(member));
    }
}
