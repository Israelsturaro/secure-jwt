package org.backend.enums;

public enum StatusEnum {
    ATIVO( "Ativo"),
    INATIVO( "Inativo");
    private final String status;


    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}