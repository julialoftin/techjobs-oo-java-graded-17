package org.launchcode.techjobs.oo;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job test_job1 = new Job();
        Job test_job2 = new Job();
        assertNotEquals(test_job1.getId(), test_job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test_job.getName() instanceof String);
        assertEquals("Product tester", test_job.getName());

        assertTrue(test_job.getEmployer() instanceof Employer);
        assertEquals("ACME", test_job.getEmployer().toString());

        assertTrue(test_job.getLocation() instanceof Location);
        assertEquals("Desert", test_job.getLocation().toString());

        assertTrue(test_job.getPositionType() instanceof  PositionType);
        assertEquals("Quality control", test_job.getPositionType().toString());

        assertTrue(test_job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", test_job.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        Job test_job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(test_job1.equals(test_job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test_job.toString().startsWith(System.lineSeparator()));
        assertTrue(test_job.toString().endsWith(System.lineSeparator()));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test_job.toString().contains("ID: " + test_job.getId() + System.lineSeparator()));
        assertTrue(test_job.toString().contains("Name: " + test_job.getName() + System.lineSeparator()));
        assertTrue(test_job.toString().contains("Employer: " + test_job.getEmployer() + System.lineSeparator()));
        assertTrue(test_job.toString().contains("Location: " + test_job.getLocation() + System.lineSeparator()));
        assertTrue(test_job.toString().contains("Position Type: " + test_job.getPositionType() + System.lineSeparator()));
        assertTrue(test_job.toString().contains("Core Competency: " + test_job.getCoreCompetency() + System.lineSeparator()));
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job test_job = new Job("Product tester", new Employer(""), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test_job.toString().contains("Employer: " + "Data not available"));
    }
}
