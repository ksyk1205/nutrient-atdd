package com.example.nutrient.domain;

import static com.example.nutrient.domain.exception.SupplementErrorCode.EXPIRATION_DATE_CANNOT_BE_EMPTY;
import static com.example.nutrient.domain.exception.SupplementErrorCode.INTAKE_CANNOT_BE_EMPTY;
import static com.example.nutrient.domain.exception.SupplementErrorCode.MAIN_FUNCTIONAL_CANNOT_BE_EMPTY;
import static com.example.nutrient.domain.exception.SupplementErrorCode.PERMIT_DATE_CANNOT_BE_EMPTY;
import static com.example.nutrient.domain.exception.SupplementErrorCode.PERMIT_DATE_NOT_AFTER_NOW;
import static com.example.nutrient.domain.exception.SupplementErrorCode.PRECAUTIONS_CANNOT_BE_EMPTY;
import static com.example.nutrient.domain.exception.SupplementErrorCode.SERIAL_NUMBER_CANNOT_BE_EMPTY;

import antlr.StringUtils;
import com.example.nutrient.domain.exception.SupplementException;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Embeddable
@Getter
public class SupplementContent {

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
        validate(serialNumber, permitDate, expirationDate, intake, mainFunctional, precautions);

        this.serialNumber = serialNumber;
        this.permitDate = permitDate;
        this.expirationDate = expirationDate;
        this.intake = intake;
        this.mainFunctional = mainFunctional;
        this.precautions = precautions;
        this.storageWay = storageWay;
    }

    private void validate(String serialNumber, LocalDate permitDate, String expirationDate,
        String intake, String mainFunctional, String precautions) {
        validateSerialNumber(serialNumber);
        validatePermitDate(permitDate);
        validateExpirationDate(expirationDate);
        validateIntake(intake);
        validateMainFunctional(mainFunctional);
        validatePrecautions(precautions);
    }

    private void validateSerialNumber(String serialNumber) {
        if (Strings.isEmpty(serialNumber)) {
            throw new SupplementException(SERIAL_NUMBER_CANNOT_BE_EMPTY);
        }
    }

    private void validatePermitDate(LocalDate permitDate) {
        if (permitDate == null) {
            throw new SupplementException(PERMIT_DATE_CANNOT_BE_EMPTY);
        }
        if (isAfterPermitDate(permitDate)) {
            throw new SupplementException(PERMIT_DATE_NOT_AFTER_NOW);
        }

    }

    private boolean isAfterPermitDate(LocalDate permitDate) {
        return permitDate.compareTo(LocalDate.now()) > 0;
    }

    private void validateExpirationDate(String expirationDate) {
        if (Strings.isEmpty(expirationDate)) {
            throw new SupplementException(EXPIRATION_DATE_CANNOT_BE_EMPTY);
        }
    }

    private void validateIntake(String intake) {
        if (Strings.isEmpty(intake)) {
            throw new SupplementException(INTAKE_CANNOT_BE_EMPTY);
        }
    }

    private void validateMainFunctional(String mainFunctional) {
        if (Strings.isEmpty(mainFunctional)) {
            throw new SupplementException(MAIN_FUNCTIONAL_CANNOT_BE_EMPTY);
        }
    }

    private void validatePrecautions(String precautions) {
        if (Strings.isEmpty(precautions)) {
            throw new SupplementException(PRECAUTIONS_CANNOT_BE_EMPTY);
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
