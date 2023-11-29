package uxdesign.cafemap.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uxdesign.cafemap.Common.Exception.UserException;
import uxdesign.cafemap.Common.Response.BaseResponse;
import uxdesign.cafemap.Dao.MemberDao;
import uxdesign.cafemap.Domain.Member;
import uxdesign.cafemap.Dto.Response.MemberResponse;

import static uxdesign.cafemap.Common.Response.status.BaseExceptionResponseStatus.USER_NOT_FOUND;

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

    public BaseResponse<String> login(String email, String password){
        Member member = new Member(email, password);

        if (memberDao.login(member)) {
            return new BaseResponse<>("로그인 완료");
        } else {
            throw new UserException(USER_NOT_FOUND);
        }
    }
}
