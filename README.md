## 도메인 모델

### 영양제 조합(`Combination`)
- 속성
  - 조합은 식별자, 제목(`title`), 설명(`content`), 조합 품목 목록(`combinationLineItems`)을 가진다.
  - 조합은 추천 성별(`recommendedGender`), 건강 상태(`healthStatus`)를 가진다.

- 기능
  - 조합을 생성한다.
    - 조합 품목 목록의 크기는 5이하이다.
    - 조합 품목 목록은 중복되지 않는다.
