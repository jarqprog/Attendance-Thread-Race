package com.jarq.runner;

import java.util.Objects;
import java.util.Random;

public abstract class SchoolRunner implements Runner {

    private final long id;
    private final String name;
    private final int distanceToRun;
    private final int minSpeed;
    private final int maxSpeed;
    private final int timeInterval;
    private int timeout;
    private boolean arrived;
    private int myHashCode;

    public SchoolRunner(long id, String name, int distanceToRun, int minSpeed, int maxSpeed, int timeInterval) {
        validateArguments(distanceToRun, minSpeed, maxSpeed, timeInterval);  // throws IllegalArgumentExc.
        this.id = id;
        this.name = name;
        this.distanceToRun = distanceToRun;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.timeInterval = timeInterval;
    }

    public synchronized void run() {
        Random chaos = new Random();
        int traveledDistance = 0;
        int traveledDistanceInTurn;

        while(traveledDistance < getDistanceToRun() ) {

            traveledDistanceInTurn = minSpeed + chaos.nextInt(maxSpeed);
            traveledDistance += traveledDistanceInTurn > maxSpeed ? maxSpeed : traveledDistanceInTurn;

            try {
                Thread.sleep(timeInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeout++;
        }
        markArrived();  // different implementation in StudentRunner & TeacherRunner class
        System.out.println(this);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTimeout() {
        return timeout;
    }

    @Override
    public boolean isArrived() {
        return arrived;
    }


    @Override
    public int getDistanceToRun() {
        return distanceToRun;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timeout=" + timeout +
                ", arrived=" + arrived +
                '}';
    }

    @Override
    public int hashCode() {
        if (myHashCode == 0) {  // lazy style
            myHashCode = Objects.hash(id, name);
        }
        return myHashCode;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || !(that.getClass().getSimpleName().equals(getClass().getSimpleName()))) return false;
        Runner thatRunner = (Runner) that;
        return thatRunner.getId() == id && thatRunner.getName().equals(name);
    }

    protected abstract void markArrived();

    protected void setArrived(boolean arrived) {
        this.arrived = arrived;
    }

    private void validateArguments(int distanceToRun, int minSpeed, int maxSpeed, int timeInterval) {
        if (minSpeed >= maxSpeed) {
            throw new IllegalArgumentException("Invalid minSpeed (should be smaller than maxSpeed)!");
        }

        if (maxSpeed > 5) {
            throw new IllegalArgumentException("Max speed is too high (should be not greater than 5)!");
        }

        if (timeInterval < 5 || timeInterval > 1000) {
            throw new IllegalArgumentException("Time interval is incorrect, should be within the range 5-1000!");
        }

        if (distanceToRun < maxSpeed*10) {
            throw new IllegalArgumentException("Distance is too small (should be at least ten times greater than" +
                    "max speed)!");
        }
    }
}
