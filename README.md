## 이벤트 스토밍
![image](https://user-images.githubusercontent.com/94955454/168463370-5b0215b6-f422-4832-89dd-3d6009782c52.png)


## 도메인 모델

### 카테고리(`Category`)
- 속성
  - 카테고리는 식별자, 이름(`name`), 카테고리 레벨(`depth`), 부모 카테고리(`parentCategory`)를 가진다.

- 기능
  - 카테고리를 생성한다.
  - 카테고리의 부모 카테고리를 변경한다.

### 영양제(`Supplement`)
- 속성
  - 영양제는 식별자, 이름(`name`), 카테고리(`category`), 일련번호(`serialNumber`), 주 기능(`mainFunction`)을 가진다.

- 기능
  - 영양제를 생성한다.
  - 영양제를 수정한다.
  - 영양제의 카테고리를 변경한다.
  - 영양제를 삭제한다.
  - 영양제의 ID로 영양제 상세정보와 최저가 정보를 조회한다.

### 영양제 조합(`Combination`)
- 속성
  - 조합은 식별자, 제목(`title`), 설명(`content`), 조합 품목 목록(`combinationLineItems`)을 가진다.
  - 조합은 추천 성별(`recommendedGender`), 건강 상태(`healthStatus`)를 가진다.

- 기능
  - 조합을 생성한다.
    - 조합 품목 목록의 크기는 5이하이다.
    - 조합 품목 목록은 중복되지 않는다.
