package controller.auth;

import annotation.UserAuth;
import domain.Users;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletRequestAttributes;
import service.auth.UserAuthService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    //회원 정보 수정 - 비밀번호, 이름 , 전화번호 수정 가능
    @UserAuth
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PATCH)
    @ApiOperation(value = "회원 정보 수정", notes = "이름, 비밀번호, 전화번호 수정 가능합니다.")
    public ResponseEntity modification(@RequestHeader(value = "Authorization") String token,
                                       @RequestBody Users user) throws Exception{
        userAuthService.modification(token, user);
        return new ResponseEntity(HttpStatus.OK);
    }

    //자신의 정보 조회
    @UserAuth
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "자신의 정보 조회", notes = "자신의 정보를 조회합니다.", authorizations = @Authorization(value = "Authorization"))
    public ResponseEntity inquiry(){
        return new ResponseEntity(userAuthService.inquiry(), HttpStatus.OK);
    }

    //회원 탈퇴
    @UserAuth
    @ResponseBody
    @RequestMapping(value="", method = RequestMethod.DELETE)
    @ApiOperation(value = "회원 탈퇴", notes = "회원 탈퇴를 합니다.")
    public ResponseEntity withdraw(@RequestHeader(value = "Authorization") String token){
        userAuthService.withdraw(token);
        return new ResponseEntity(HttpStatus.OK);
    }

}
