package com.syx.bangumiCalender;


import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.util.UidGenerator;
import org.junit.jupiter.api.Test;

import java.net.SocketException;
import java.util.GregorianCalendar;

/**
 * @ClassName TestIcal4j
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/11/29 19:02
 * @Version v0.1
 **/
public class TestIcal4j {
    @Test
    void test1() throws SocketException {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(java.util.Calendar.MONTH, java.util.Calendar.DECEMBER);
        calendar.set(java.util.Calendar.DAY_OF_MONTH, 25);

        // initialise as an all-day event..
        VEvent christmas = new VEvent(new Date(calendar.getTime()), "Christmas Day");

        // Generate a UID for the event..
        UidGenerator ug = new UidGenerator("1");
        christmas.getProperties().add(ug.generateUid());

        net.fortuna.ical4j.model.Calendar cal = new net.fortuna.ical4j.model.Calendar();
        cal.getComponents().add(christmas);
        System.out.println(cal);
    }
}
