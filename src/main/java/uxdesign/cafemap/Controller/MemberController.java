package uxdesign.cafemap.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import uxdesign.cafemap.Common.Response.BaseResponse;
import uxdesign.cafemap.Dto.Request.LoginRequest;
import uxdesign.cafemap.Dto.Request.MemberRequest;
import uxdesign.cafemap.Dto.Response.MemberResponse;
import uxdesign.cafemap.Service.MemberService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    // 회원가입
    @PostMapping("/signup")
    public BaseResponse<MemberResponse> signup(@RequestBody @Valid MemberRequest memberRequest){
        log.info("[MemberController.signup]");
        return memberService.signup(memberRequest.getEmail(), memberRequest.getPassword());
    }

    // 로그인
    @PostMapping("/login")
    public BaseResponse<String> login(@RequestBody @Valid LoginRequest loginRequest){
        log.info("[MemberController.signup]");
        return memberService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }

}
