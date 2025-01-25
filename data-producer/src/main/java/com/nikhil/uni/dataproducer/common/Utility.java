package com.nikhil.uni.dataproducer.common;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;

public class Utility {
	
    private static final SimpleDateFormat ISO_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    private static final SimpleDateFormat ISO_FORMAT_UTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    private static final Random RANDOM = new Random();
    private static final int MIN_VAL = -30;
    private static final int MAX_VAL = 50;
    
    private static List<String> guids = Arrays.asList(
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString()
        );
    
    private Utility() {}
    
    
	public static synchronized String getCurrentISODate() {
		return ISO_FORMAT.format(new Date());
	}
	
	public static synchronized String getCurrentISOUtcDate() {
		ISO_FORMAT_UTC.setTimeZone(TimeZone.getTimeZone("UTC"));
	    return ISO_FORMAT_UTC.format(new Date());
	}
	
	public static String getTemperature() {
        return String.valueOf(RANDOM.nextInt(MAX_VAL - MIN_VAL + 1) + MIN_VAL);
	}
	
	public static String getId() {
        return guids.get(RANDOM.nextInt(guids.size()));
	}
}
