package com.example.nutrient.domain;

import antlr.StringUtils;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Embeddable
@Getter
public class SupplementContent {

    private static final String SERIAL_NUMBER_CANNOT_BE_EMPTY = "품목제조번호는 비어있으면 안됩니다.";
    private static final String PERMIT_DATE_CANNOT_BE_NULL = "허가일자는 NULL 일 수 없습니다.";
    private static final String PERMIT_DATE_CANNOT_OVER_NOW = "허가일자는 오늘 날보다 이후 일 수 없습니다.";
    private static final String EXPIRATION_DATE_CANNOT_BE_EMPTY = "유통기한 일수는 비어있으면 안됩니다.";
    private static final String INTAKE_CANNOT_BE_EMPTY = "섭취 방법은 비어있으면 안됩니다.";
    private static final String MAIN_FUNCTIONAL_CANNOT_BE_EMPTY = "주된 기능성은 비어있으면 안됩니다.";
    private static final String PRECAUTIONS_CANNOT_BE_EMPTY = "섭취시주의사항은 비어있으면 안됩니다.";


    private final String serialNumber;

    private final LocalDate permitDate;

    private final String expirationDate;

    private final String intake;

    private final String mainFunctional;

    private final String precautions;

    private String storageWay;

    protected SupplementContent() {
        this.serialNumber = null;
        this.permitDate = null;
        this.expirationDate = null;
        this.intake = null;
        this.mainFunctional = null;
        this.precautions = null;
    }

    public SupplementContent(String serialNumber, LocalDate permitDate, String expirationDate,
        String intake, String mainFunctional, String precautions, String storageWay) {
        serialNumberValidation(serialNumber);
        permitDateValidation(permitDate);
        expirationDateValidation(expirationDate);
        intakeValidation(intake);
        mainFunctionalValidation(mainFunctional);
        precautionsValidation(precautions);

        this.serialNumber = serialNumber;
        this.permitDate = permitDate;
        this.expirationDate = expirationDate;
        this.intake = intake;
        this.mainFunctional = mainFunctional;
        this.precautions = precautions;

        this.storageWay = storageWay == null ? null : storageWay;
    }

    private void serialNumberValidation(String serialNumber) {
        if (Strings.isEmpty(serialNumber)) {
            throw new IllegalArgumentException(SERIAL_NUMBER_CANNOT_BE_EMPTY);
        }
    }

    private void permitDateValidation(LocalDate permitDate) {
        if(permitDate == null){
            throw new IllegalArgumentException(PERMIT_DATE_CANNOT_BE_NULL);
        }
        if(isOverToNow(permitDate) ){
            throw new IllegalArgumentException(PERMIT_DATE_CANNOT_OVER_NOW);
        }

    }
    private boolean isOverToNow(LocalDate permitDate) {
        return permitDate.compareTo(LocalDate.now()) > 0;
    }

    private void expirationDateValidation(String expirationDate) {
        if (Strings.isEmpty(expirationDate)) {
            throw new IllegalArgumentException(EXPIRATION_DATE_CANNOT_BE_EMPTY);
        }
    }

    private void intakeValidation(String intake) {
        if (Strings.isEmpty(intake)) {
            throw new IllegalArgumentException(INTAKE_CANNOT_BE_EMPTY);
        }
    }

    private void mainFunctionalValidation(String mainFunctional) {
        if (Strings.isEmpty(mainFunctional)) {
            throw new IllegalArgumentException(MAIN_FUNCTIONAL_CANNOT_BE_EMPTY);
        }
    }

    private void precautionsValidation(String precautions) {
        if (Strings.isEmpty(precautions)) {
            throw new IllegalArgumentException(PRECAUTIONS_CANNOT_BE_EMPTY);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SupplementContent that = (SupplementContent) o;
        return Objects.equals(serialNumber, that.serialNumber) && Objects.equals(
            permitDate, that.permitDate) && Objects.equals(expirationDate,
            that.expirationDate) && Objects.equals(intake, that.intake)
            && Objects.equals(mainFunctional, that.mainFunctional)
            && Objects.equals(precautions, that.precautions) && Objects.equals(
            storageWay, that.storageWay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, permitDate, expirationDate, intake, mainFunctional,
            precautions, storageWay);
    }
}
