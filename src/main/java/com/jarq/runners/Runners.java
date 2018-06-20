package com.jarq.runners;

import com.jarq.runner.Runner;

import java.util.Iterator;

public interface Runners {

    boolean add(Runner runner);
    Runner[] getAll();
    Runner getRunner(int id);
    void clear();
    boolean validate();  // return true if runners are ready to race
    int quantity();
    Iterator<Runner> iterator();
}
