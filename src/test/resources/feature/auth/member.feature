Feature: 회원 정보 관리

  Scenario: 회원 정보를 관리
    When 회원 생성 요청
    Then 회원 생성됨
    When 회원 정보 조회 요청
    Then 회원 정보 조회됨
    When 회원 정보 수정 요청
    Then 회원 정보 수정됨
    When 회원 정보 삭제 요청
    Then 회원 정보 삭제됨

