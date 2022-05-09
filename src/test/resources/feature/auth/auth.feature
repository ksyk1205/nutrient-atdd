Feature: 회원 인증 정보 관리

  Scenario: 회원 인증 정보를 관리
    Given 회원 생성 요청
    When 로그인 되어있음
    When 내 회원 정보 조회 요청
    Then 회원 정보 조회됨
