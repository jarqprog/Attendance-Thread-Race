package com.jarq.runners;

import com.jarq.runner.Runner;
import com.jarq.runner.Teacher;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SchoolRunners implements Runners {

    private final Set<Runner> runners = new HashSet<>();

    @Override
    public boolean add(Runner runner) {
        return runners.add(runner);
    }

    @Override
    public Runner[] getAll() {
        return runners.toArray(new Runner[0]);
    }

    @Override
    public Runner getRunner(int id) {
        return runners.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void clear() {
        runners.clear();
    }

    @Override
    public boolean validate() {

        boolean isTeacher = runners.stream().anyMatch(r -> r instanceof Teacher);

        return isTeacher && runners.size() > 1;
    }

    @Override
    public int quantity() {
        return runners.size();
    }

    @Override
    public Iterator<Runner> iterator() {
        return runners.iterator();
    }
}
