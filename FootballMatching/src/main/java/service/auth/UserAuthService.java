package service.auth;

import domain.Users;

public interface UserAuthService {
    String modification(String token, Users user); // 회원 정보 수정 - 비밀번호, 이름 , 전화번호 수정 가능
    Users inquiry(String token);
    void withdraw(String token);
}