package com.thephoenixcollective.user_service.utility;

import java.io.Serializable;

public class AppConstants implements Serializable {
    private AppConstants() {

    }

    private static final long serialVersionUID = 1L;
    public static final String USER_TABLE="users";
    public static final String PHOENIX_SCHEMA="phoenix";
    public static final String SYSTEM="SYSTEM";
}
