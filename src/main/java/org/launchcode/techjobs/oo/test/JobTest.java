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
        Job j1 = new Job();
        Job j2 = new Job();
        assertNotEquals(j1.getId(), j2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals('\n', testJob3.toString().charAt(0));
        assertEquals('\n', testJob3.toString().charAt(testJob3.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData () {
        Job testJob4  = new Job("jobTestName", new Employer("jobTestEmployer"), new Location("jobTestLocation"), new PositionType("jobTestPosition"), new CoreCompetency("jobTestCompetency"));
        String toStringTest = "\nID: " + testJob4.getId() + "\nName: jobTestName\nEmployer: jobTestEmployer\nLocation: jobTestLocation\nPosition Type: jobTestPosition\nCore Competency: jobTestCompetency\n";

        assertEquals(toStringTest, testJob4.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob5 = new Job("Test Case", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: " + testJob5.getId() + "\n" +
                "Name: " + testJob5.getName() +"\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available\n", testJob5.toString());

    }
//        Job testJob5 = new Job( "", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
//        String toStringTest = "\nID: " + testJob5.getId() + "\nName: jobTestName " + "\nEmployer: jobTestEmployer\nLocation: jobTestLocation\nPosition Type: jobTestPosition\nCore Competency: jobTestCompetency\n";
//
//        assertFalse(toStringTest.equals(testJob5.toString()));
//    }

}
