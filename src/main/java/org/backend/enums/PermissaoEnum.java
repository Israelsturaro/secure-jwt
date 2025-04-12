package org.backend.enums;

public enum PermissaoEnum {
    ADMIN("Admin"),
    USER("user");

    private final String permissao;

    PermissaoEnum(String permissao) {
        this.permissao = permissao;
    }

    public String getPermissao() {
        return permissao;
    }
}