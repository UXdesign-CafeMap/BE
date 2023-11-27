package uxdesign.cafemap.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import uxdesign.cafemap.Common.Response.BaseResponse;
import uxdesign.cafemap.Dto.Request.MemberRequest;
import uxdesign.cafemap.Service.MemberService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public BaseResponse<String> signup(@RequestBody @Valid MemberRequest memberRequest){
        log.info("[MemberController.signup]");
        return memberService.signup(memberRequest.getEmail(), memberRequest.getPassword());
    }

}
