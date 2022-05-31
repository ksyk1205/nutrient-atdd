package com.example.nutrient.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SupplementTest {
    @DisplayName("영양제 수정 테스트")
    @ParameterizedTest
    @CsvSource(value = {
        "김화란 클로렐라:20040020014500:2010-08-13:제조일로부터 24개월:1일 1회, 1회 1포를 물 또는 우유에 타서 섭취하십시오.:[클로렐라 제품]1. 피부건강에 도움 2. 항산화작용:특정 성분에 알레르기 체질이신 분은 섭취 전 원료(성분)를 확인하시기 바랍니다.:직사광선을 피하고 서늘한 곳에 보관 및 유통:",
    }, delimiter = ':')
    public void update(String name, String serialNumber, LocalDate permitDate,
        String expirationDate,
        String intake, String mainFunctional, String precautions, String storageWay) {

        SupplementTitle supplementTitle = new SupplementTitle("6년근 고려홍삼정 PREMIUM");
        SupplementContent supplementContent = new SupplementContent("201100200015",
            LocalDate.of(2011, 12, 9),
            "제조일로부터 24개월",
            "1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.",
            "①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음",
            "[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.",
            "직사광선을 피해 건조하고 서늘한 곳에서 보관한다.");
        Supplement supplement = Supplement.builder()
            .id(UUID.randomUUID())
            .title(supplementTitle)
            .content(supplementContent)
            .category(Category.builder().build())
            .build();
        SupplementTitle updateSupplementTitle = new SupplementTitle(name);
        SupplementContent updateSupplementContent = new SupplementContent(
            serialNumber, permitDate, expirationDate, intake, mainFunctional, precautions,
            storageWay);
        supplement.updateTitle(updateSupplementTitle);
        supplement.updateContent(updateSupplementContent);
        supplement.updateCategory(Category.builder()
            .id(UUID.randomUUID()).build());

        assertThat(supplement.getTitle()).isEqualTo(updateSupplementTitle);
        assertThat(supplement.getContent()).isEqualTo(updateSupplementContent);
    }
}
