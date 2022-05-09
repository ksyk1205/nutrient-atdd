Feature: 영양제를 관리한다.

  Scenario:
    Given 로그인 되어 있음
    And  카테고리 생성되어 있음
    When 영양제 생성 요청
    Then 영양제 생성됨
    When 영양제 수정 요청
    Then 영양제 수정됨
    When 영양제 삭제 요청
    Then 영양제 삭제됨

