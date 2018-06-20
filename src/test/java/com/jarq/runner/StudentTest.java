package com.jarq.runner;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    private final Teacher dummy = ()-> false;

    private Runner student = new StudentRunner(1, "Jerry", 1000,
            1, 2, 500, dummy);


    @Test
    public void testEquals() {

        // only id & name should affect on equals()
        StudentRunner otherStudent = new StudentRunner(1, "Jerry", 1000,
                2, 3, 105, dummy);

        otherStudent.markArrived();

        assertEquals(student, otherStudent);
    }

    @Test
    public void testEquals_if_different_name() {

        StudentRunner otherStudent = new StudentRunner(1, "Jerr", 1000,
                2, 3, 105, dummy);
        assertNotSame(student, otherStudent);
    }

    @Test
    public void testEquals_if_different_id() {

        StudentRunner otherStudent = new StudentRunner(2, "Jerry", 1000,
                2, 3, 105, dummy);

        assertNotSame(student, otherStudent);
    }



    @Test
    public void testHashCode() {

        // only id & name should affect on hashCode()
        StudentRunner otherStudent = new StudentRunner(1, "Jerry", 1000,
                2, 3, 105, dummy);

        otherStudent.markArrived();

        assertEquals(student.hashCode(), otherStudent.hashCode());
    }

    @Test
    public void testHashCode_if_different_name() {

        StudentRunner otherStudent = new StudentRunner(1, "Jerr", 1000,
                2, 3, 105, dummy);

        assertNotSame(student.hashCode(), otherStudent.hashCode());
    }

    @Test
    public void testHashCode_if_different_id() {

        StudentRunner otherStudent = new StudentRunner(2, "Jerry", 1000,
                2, 3, 105, dummy);

        assertNotSame(student.hashCode(), otherStudent.hashCode());
    }

}