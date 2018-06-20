package com.jarq.runner;

public interface Runner extends Runnable {

    long getId();
    String getName();
    int getTimeout();
    boolean isArrived();
    int getDistanceToRun();

}
