package org.backend.model.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "TokenResponse", description = "DTO Token JWT")
public class TokenResponse {


    @Schema(description = "Token JWT", example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3F1YXJrdXMuaW8vdXNpbmctand0L2lzc3VlciIsInVwbiI6ImVtYWlsQGV4YW1wbGUuY29tIiwiZ3JvdXBzIjpbXSwiZnVsbF9uYW1lIjoiRnVsYW5vIGRlIFRhbCIsImV4cCI6MTc0NDM3NDQ4MSwiaWF0IjoxNzQ0MzcwODgxLCJqdGkiOiJlYTYzZmIzMi01YmZiLTRkODUtYjg2Ni1mNjdmNWY3ZjcwMzQifQ.lMWd6dLYerbjCg-N-TDVw1G1ExaAxS6_in9SupHipi6MOkrU1Qr9dJYrgbqRfIFRocfG-aKztFBc7fu6AMxSUqWgnSVAohqb-hPesYn-Wqzihrcy_xxqIhcN_F9VK5Syo8tmPV6WlwjzzIsYx_mPo4-x_pKJ0ATkFKN_MRzTRpDxkyckhTfT2jm9Xf4rOUlJfCHcYfvwz4SPJgiR0rkv8ASwouyxMjJ5zqy1PYB8SPRDeoPYdT1SngmpTe1Jcxq8mN_oKy-Sy_Y4vPLgPN9IDMVDT6DWxNtGNKXKZtsb5mmCdL45dnB48zNCoQSbMWkegoxF915qm4tp3OBn3mCqfg")
    @JsonProperty("access_token")
    public String token;
}
