package com.example.nutrient.domain.exception;

import lombok.Getter;

@Getter
public enum SupplementErrorCode {
    OK(400, "TILT : Should not get here"),
    SERIAL_NUMBER_CANNOT_BE_EMPTY(400, "품목제조번호는 비어있으면 안됩니다."),
    PERMIT_DATE_CANNOT_BE_EMPTY(400, "허가일자는 비어 있을수 없습니다."),
    PERMIT_DATE_NOT_AFTER_NOW(400, "허가일자는 현재일 이후 일 수 없습니다."),
    EXPIRATION_DATE_CANNOT_BE_EMPTY(400, "유통기한 일수는 비어 있을수 없습니다."),
    INTAKE_CANNOT_BE_EMPTY(400, "섭취 방법은 비어 있을수 없습니다."),
    MAIN_FUNCTIONAL_CANNOT_BE_EMPTY(400, "주된 기능성은 비어 있을수 없습니다."),
    PRECAUTIONS_CANNOT_BE_EMPTY(400, "섭취시주의사항은 비어 있을수 없습니다.");

    private int status;
    private String message;


    SupplementErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
