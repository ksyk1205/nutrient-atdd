package com.example.nutrient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SupplementsFixture {
    public static final Supplement 멀티비타민_센트룸;
    public static final Supplement 마그네슘_솔가;
    public static final Supplement 루테인_안국건강;
    public static final Supplement 밀크시슬_나우푸드;
    public static final Supplement 오메가3_종근당;
    public static final Supplement 빌베리_프롬바이오;
    public static final List<Supplement> SUPPLEMENT_LIST;
    public static final Supplements SUPPLEMENTS;

    static {
        멀티비타민_센트룸 = new FakeSupplement(UUID.randomUUID(), "멀티비타민_센트룸");
        마그네슘_솔가 = new FakeSupplement(UUID.randomUUID(), "마그네슘_솔가");
        루테인_안국건강 = new FakeSupplement(UUID.randomUUID(), "루테인_안국건강");
        밀크시슬_나우푸드 = new FakeSupplement(UUID.randomUUID(), "밀크시슬_나우푸드");
        오메가3_종근당 = new FakeSupplement(UUID.randomUUID(), "오메가3_종근당");
        빌베리_프롬바이오 = new FakeSupplement(UUID.randomUUID(), "빌베리_프롬바이오");
        SUPPLEMENT_LIST = Arrays.asList(
                멀티비타민_센트룸, 마그네슘_솔가, 루테인_안국건강, 밀크시슬_나우푸드, 오메가3_종근당
        );
        SUPPLEMENTS = new Supplements(SUPPLEMENT_LIST);
    }

    public static Supplements createSupplements(Supplement... supplements) {
        return new Supplements(Arrays.asList(supplements));
    }

    @AllArgsConstructor
    @Data
    static class FakeSupplement extends Supplement {
        private UUID id;
        private String name;
    }
}
