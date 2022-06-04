Feature: 영양제를 상세조회한다.

  Scenario:
    Given 로그인 되어 있음
    And  영양제 생성되어있음
    When 영양제 상세 조회
    Then 영양제 상세 조회됨