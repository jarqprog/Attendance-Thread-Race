package com.jarq.runner;

public class TeacherRunner extends SchoolRunner implements Teacher {


    public TeacherRunner(long id, String name, int distanceToRun, int minSpeed, int maxSpeed, int timeInterval) {
        super(id, name, distanceToRun, minSpeed, maxSpeed, timeInterval);
    }

    @Override
    protected void markArrived() {
        setArrived(true);
    }

    @Override
    public boolean startedRollCall() {
        return isArrived();
    }
}
