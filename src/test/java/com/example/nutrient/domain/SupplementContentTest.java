package com.example.nutrient.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.contentOf;

import com.example.nutrient.domain.exception.SupplementException;
import java.time.LocalDate;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SupplementContentTest {

    @Test
    @DisplayName("영양제 내용을 생성한다")
    public void create() {
        assertThatCode(() -> new SupplementContent("201100200015",
            LocalDate.of(2011, 12, 9),
            "제조일로부터 24개월",
            "1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.",
            "①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음",
            "[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.",
            "직사광선을 피해 건조하고 서늘한 곳에서 보관한다."))
            .doesNotThrowAnyException();
    }

    @DisplayName("영양제 내용 비어있지 않아야 한다")
    @ParameterizedTest
    @CsvSource(value = {
        ":2011-07-12:제조일로부터 24개월:1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.:①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음:[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.:직사광선을 피해 건조하고 서늘한 곳에서 보관한다.",
        "201100200015::제조일로부터 24개월:1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.:①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음:[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.:직사광선을 피해 건조하고 서늘한 곳에서 보관한다.",
        "201100200015:2011-07-12::1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.:①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음:[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.:직사광선을 피해 건조하고 서늘한 곳에서 보관한다.",
        "201100200015:2011-07-12:제조일로부터 24개월::①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음:[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.:직사광선을 피해 건조하고 서늘한 곳에서 보관한다.",
        "201100200015:2011-07-12:제조일로부터 24개월:1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.::[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.:직사광선을 피해 건조하고 서늘한 곳에서 보관한다.",
        "201100200015:2011-07-12:제조일로부터 24개월:1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.:①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음::직사광선을 피해 건조하고 서늘한 곳에서 보관한다."
    }, delimiter = ':')
    public void createNull(String serialNumber, LocalDate permitDate, String expirationDate,
        String intake, String mainFunctional, String precautions, String storageWay) {
        assertThatThrownBy(
            () -> new SupplementContent(serialNumber, permitDate, expirationDate, intake,
                mainFunctional, precautions, storageWay))
            .isInstanceOf(SupplementException.class);
    }


    @Test
    @DisplayName("허용일자는 현재일 보다 클경우 등록되지 않는다.")
    public void afterPermitDateNow() {
        assertThatThrownBy(
            () -> new SupplementContent("201100200015",
                LocalDate.now().plusDays(1),
                "제조일로부터 24개월",
                "1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.",
                "①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음",
                "[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.",
                "직사광선을 피해 건조하고 서늘한 곳에서 보관한다."))
            .isInstanceOf(SupplementException.class);
    }

    @Test
    @DisplayName("허용일자는 현재일 보다 같을 경우 등록되어야 한다.")
    public void inPermitDateNow() {
        assertThatCode(() -> new SupplementContent("201100200015",
            LocalDate.now(),
            "제조일로부터 24개월",
            "1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.",
            "①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음",
            "[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.",
            "직사광선을 피해 건조하고 서늘한 곳에서 보관한다."))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("저장 방법은 NULL 과 빈값이 허용되어야 한다.")
    public void storageEmpty() {
        assertThatCode(() -> new SupplementContent("201100200015",
            LocalDate.now(),
            "제조일로부터 24개월",
            "1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.",
            "①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음",
            "[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.",
            null))
            .doesNotThrowAnyException();
        assertThatCode(() -> new SupplementContent("201100200015",
            LocalDate.now(),
            "제조일로부터 24개월",
            "1일 3회, 1회 1스푼(3.2g)씩 물에 녹여 섭취 하십시요.",
            "①면역력 증진②피로개선③혈소판 응집 억제를 통한 혈액흐름에 도움④기억력 개선⑤항산화에 도움을 줄 수 있음",
            "[홍삼제품]의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의 2) 특이체질등 알레르기 체질의 경우 제품성분을 확인 후 섭취하시기 바랍니다. 3) 15세 이하의 어린이는 상기 섭취량의 절반 정도를 섭취하시요. 4) 제품 개봉 또는 섭취시에 포장재로 인한 상처를 입을수 있으니주의 하십시오.",
            ""))
            .doesNotThrowAnyException();
    }



}