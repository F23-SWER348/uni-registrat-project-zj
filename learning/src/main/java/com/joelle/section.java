package com.joelle;

import java.util.List;

public class section extends course{

    private List<schedule> sectionSchedule;

        public section(int courseID, String courseName, int credits, faculty faculty, List<schedule> schedule, List<Schedule> sectionSchedule) {
        super(courseID, courseName, credits, faculty, schedule);
        this.sectionSchedule = sectionSchedule;
    }

    public List<schedule> getSectionSchedule() {
        return sectionSchedule;
    }

    public void setSectionSchedule(List<schedule> sectionSchedule) {
        this.sectionSchedule = sectionSchedule;
    }

    
}
