package service.non_auth;

import domain.BusinessUsers;

public interface BusinessUserService {

    String checkPhoneNumber(String phoneNumber); // 전화번호 중복 체크

    String tokenIssued(String id); // 토큰 발급

    void signUp(BusinessUsers bUser) throws Exception; // 회원가입

    String signIn(BusinessUsers bUser) throws Exception; // 로그인

    String findId(BusinessUsers bUser) throws Exception; // id 찾기

    BusinessUsers lookUp(BusinessUsers bUser) throws Exception; // 비밀번호 찾기 - id, 전화번호, 이름, 구장 이름 일치 여부 파악

    void changePassword(BusinessUsers bUser); // 비밀번호 찾기 - 비밀번호 변경
}
