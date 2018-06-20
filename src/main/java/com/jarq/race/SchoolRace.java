package com.jarq.race;

import com.jarq.runner.Runner;
import com.jarq.runners.Runners;

public class SchoolRace implements Race {

    private final Runners runners;

    public SchoolRace(Runners runners) {
        if (! runners.validate() ) {
            throw new IllegalArgumentException("Runners aren't prepared!");
        }
        this.runners = runners;
    }

    public void execute() {

        Runner[] contestants = runners.getAll();
        Thread[] threads = new Thread[contestants.length];

        for (int i=0; i<threads.length; i++) {
            Thread current = new Thread(contestants[i]);
            threads[i] = current;
            current.start();
        }
    }
}
