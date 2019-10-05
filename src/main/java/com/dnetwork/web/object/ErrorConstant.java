package com.dnetwork.web.object;

public class ErrorConstant {

    public static final int SUCCESS= 0;
    public static final String SUCCESS_DESC = "success";

    public static final int INVALID_PHYSICAL_DEVICE_ADDRESS= 101;
    public static final String INVALID_PHYSICAL_DEVICE_ADDRESS_DESC = "Invalid physical device address";

    public static final int INVALID_JWT_SIGNATURE= 101;
    public static final String INVALID_JWT_SIGNATURE_DESC = "Invalid JWT signature";

    public static final int INVALID_JWT_TOKEN= 102;
    public static final String INVALID_JWT_TOKEN_DESC = "Invalid JWT token";

    public static final int EXPIRED_JWT_TOKEN= 103;
    public static final String EXPIRED_JWT_TOKEN_DESC = "Expired JWT token";

    public static final int UNSUPPORTED_JWT_TOKEN= 104;
    public static final String NSUPPORTED_JWT_TOKEN_DESC = "Unsupported JWT token";

    public static final int JWT_CLAIMS_STRING_IS_EMPTY= 105;
    public static final String JWT_CLAIMS_STRING_IS_EMPTY_DESC = "JWT claims string is empty.";
}
