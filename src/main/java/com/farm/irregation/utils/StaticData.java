package com.farm.irregation.utils;

public class StaticData {

    //Schedule Rates
    public static final int SENSOR_IRREGATION_CHECK_RATE = 60*1000; // 1 minute
    public static final int MINUTES_NUMBER_IN_DAY = 24*60; // 1440 minutes
    public static final int IRRIGATION_SPEED = 5; // 5 Litres/minute
    public static final int MAX_SENSOR_RETRIES = 3;

    //Time Slot States
    public static final String SCHEDULED_SLOT = "Scheduled";
    public static final String IN_PROGRESS_SLOT = "InProgress";
    public static final String DONE_SLOT = "Done";
    public static final String REJECTED = "Rejected";

    //Alarm States
    public static final String RINGING = "Ringing !!";
    public static final String SILENT = "Silent";

    //Sensor States
    public static final String AVAILABLE = "Available";
    public static final String NOT_AVAILABLE = "Not Available";

    //Test Cases
    public static final String FIRST_TEST_CASE = "firstTestCase";
    public static final String SECOND_TEST_CASE = "secondTestCase";
}
