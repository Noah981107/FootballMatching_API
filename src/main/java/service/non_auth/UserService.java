package service.non_auth;

import domain.Users;

public interface UserService {
    String checkPhoneNumber(String phoneNumber); // 전화번호 중복 검사
    String tokenIssued(String id) throws Exception; // 토큰 발급
    void signUp(Users user) throws Exception; // 회원가입
    String signIn(Users user) throws Exception; // 로그인
    String findId(Users user) throws Exception; // id 찾기
    Users lookUp(Users user) throws Exception; // 비밀번호 찾기 - id, 전화번호, 이름 일치 여부 파악
    void changePassword(Users user); // 비밀번호 찾기 - 비밀번호 변경
    String findIdx(String id); // idx 찾기
}
