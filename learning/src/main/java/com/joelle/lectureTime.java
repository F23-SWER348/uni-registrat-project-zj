package com.joelle;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class lectureTime {
   private DayOfWeek dayOfWeek;
private LocalTime startTime;
private LocalTime endTime;

public lectureTime(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
this.dayOfWeek = dayOfWeek;
this.startTime = startTime;
this.endTime = endTime;
}

public DayOfWeek getDayOfWeek() {
return dayOfWeek;
}

public LocalTime getStartTime() {
return startTime;
}

public LocalTime getEndTime() {
return endTime;
}
} 

