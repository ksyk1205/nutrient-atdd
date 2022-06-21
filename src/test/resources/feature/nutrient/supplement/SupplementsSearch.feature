Feature: 영양제를 전체 조회한다.

  Scenario:
    Given 조회할 페이지가 설정되어 있음
    And 카테고리 생성되어 있음
    And  영양제 생성되어있음
    And  영양제 생성되어있음
    And  영양제 생성되어있음
    When 영양제 페이지별 조회
    Then 영양제 페이지별 조회됨