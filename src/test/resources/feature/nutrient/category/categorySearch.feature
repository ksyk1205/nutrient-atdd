Feature: 카테고리를 조회한다.

  Scenario: 카테고리를 조회
    Given 카테고리 생성되어있음
    When 카테고리 조회
    Then 카테고리 조회됨
