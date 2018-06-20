package com.jarq.runner;

public class StudentRunner extends SchoolRunner {

    private final Teacher teacher;


    public StudentRunner(long id, String name, int distanceToRun, int minSpeed, int maxSpeed, int timeInterval,
                         Teacher teacher) {
        super(id, name, distanceToRun, minSpeed, maxSpeed, timeInterval);
        this.teacher = teacher;
    }

    @Override
    protected void markArrived() {
        if (! teacher.startedRollCall() ) {
            setArrived(true);
        }
    }
}
