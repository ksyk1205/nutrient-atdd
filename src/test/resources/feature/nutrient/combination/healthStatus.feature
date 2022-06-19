Feature: 건강 상태를 관리한다.

  Scenario: 건강 상태 관리
    Given 관리자 계정 생성되어있음
    And 로그인 되어있음
    When 건강 상태 생성 요청
    Then 건강 상태 생성됨
    When 건강 상태 조회 요청
    Then 건강 상태 조회됨
    When 건강 상태 수정 요청
    Then 건강 상태 수정됨
    When 건강 상태 삭제 요청
    Then 건강 상태 삭제됨
