package com.farm.irregation.utils;

public class SystemCodes {
    public static enum StatusMessages {

        // 200s status messages
        OK("INFO_200_001", "Success Operation"),
        CREATED("INFO_200_002", "Data added successfully"),
        UPDATED("INFO_200_003", "Data updated successfully"),
        DELETED("INFO_200_004", "Data deleted successfully"),
        RECEIVED("INFO_200_005", "Data received successfully"),

        // 500s status messages
        GENERAL_ERROR("ERROR_500_001", "General Error: "),
        DATABASE_ERROR("ERROR_500_002", "Database Error: ");

        private String code, description;

        StatusMessages(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

    }
}
