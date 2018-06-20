package com.jarq;

import com.jarq.race.Race;
import com.jarq.race.SchoolRace;
import com.jarq.runner.Runner;
import com.jarq.runner.StudentRunner;
import com.jarq.runner.Teacher;
import com.jarq.runner.TeacherRunner;
import com.jarq.runners.Runners;
import com.jarq.runners.SchoolRunners;

import java.util.Arrays;
import java.util.Random;

public class Root {

    public static Root getInstance() {

        return new Root();
    }

    private Root () {}

    public void start() {

        Runners runners = createRunners();

        System.out.println("Runners prepared!");
        Arrays.stream(runners.getAll()).forEach(System.out::println);


        final Race race = new SchoolRace(runners);
        System.out.println("\n\n\nRace prepared! Start...\n\n");

        race.execute();
        System.out.println("Results:");
    }

    private Runners createRunners() {

        Runners runnersContainer = new SchoolRunners();
        int distance = 100;
        int minSpeed = 1;
        int maxSpeed = 3;
        final int TIME_INTERVAL = 10;
        int id = 1;
        Random chaos = new Random();
        String[] studentsNames = {"Mark", "Tom", "Anna", "Jerry", "Chris", "Robin", "Ben", "John", "Maria", "Paul"};
        String teacherName = "Jacob the teacher";

        // create teacher & add to container:
        Runner teacher = new TeacherRunner(id, teacherName, distance, minSpeed, maxSpeed, TIME_INTERVAL);
        runnersContainer.add(teacher);

        // create students & add to container:
        for (String name : studentsNames) {
            id++;

            runnersContainer.add(
                    new StudentRunner(id, name,
                    distance + chaos.nextInt(10),
                    minSpeed + chaos.nextInt(1),
                    maxSpeed + chaos.nextInt(2),
                    TIME_INTERVAL,
                    (Teacher) teacher) );
        }
        return runnersContainer;
    }
}
