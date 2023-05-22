package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job firstJob = new Job();
        Job seccondJob = new Job();
        assertNotEquals(firstJob, seccondJob);
    }



    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //int testId = job1.getId();
        String testName = job1.getName();
        Employer testEmployer = job1.getEmployer();
        Location testLocation = job1.getLocation();
        PositionType testPositionType = job1.getPositionType();
        CoreCompetency testCoreCompetency = job1.getCoreCompetency();

        assertEquals("Product tester", testName);
        assertEquals("ACME", testEmployer.getValue());
        assertEquals("Desert", testLocation.getValue());
        assertEquals("Quality control", testPositionType.getValue());
        assertEquals("Persistence", testCoreCompetency.getValue());

        //assertTrue(testId instanceof Job);
        assertTrue(testName instanceof String);
        assertTrue(testEmployer instanceof Employer);
        assertTrue(testLocation instanceof Location);
        assertTrue(testPositionType instanceof PositionType);
        assertTrue(testCoreCompetency instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {

        Job jobA = new Job ("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job jobB = new Job ("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(jobA == jobB);
    }


    @Test
    public void testToStringStartsAndEndsWithNewLine() {

        Job jobFormat = new Job ("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        char startChar = jobFormat.toString().charAt(0);
        char endChar = jobFormat.toString().charAt(jobFormat.toString().length() - 1);

        assertEquals(startChar, '\n');
        assertEquals(endChar, '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job madeUpJob = new Job ("Dog Mom", new Employer("Toby, My Dog"), new Location("Home"),
                new PositionType("Boss"), new CoreCompetency("Love"));

        assertEquals("\nID: " + madeUpJob.getId() + "\nName: Dog Mom\nEmployer: Toby, My Dog\nLocation: Home" +
                        "\nPosition Type: Boss\nCore Competency: Love\n",
                madeUpJob.toString());
    }


    @Test
    public void testToStringHandlesEmptyField(){
        Job emptyJob = new Job("Missing Info", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency("Java"));

        assertEquals("\nID: " + emptyJob.getId() + "\nName: Missing Info\nEmployer: Data not available" +
                        "\nLocation: Data not available" + "\nPosition Type: Data not available\nCore Competency: Java\n",
                emptyJob.toString());
    }

}
