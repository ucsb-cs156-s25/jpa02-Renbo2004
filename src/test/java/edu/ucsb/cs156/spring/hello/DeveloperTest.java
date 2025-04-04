package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-s25-teams>
        assertEquals("Renbo Zhang", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-s25-teams>
        assertEquals("Renbo2004", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-04", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Joe Lee"),"Team should contain Joe Lee");
        assertTrue(t.getMembers().contains("Fahim Zaman"),"Team should contain Fahim Zaman");
        assertTrue(t.getMembers().contains("Renbo Zhang"),"Team should contain Renbo Zhang");
        assertTrue(t.getMembers().contains("Montgomery Forde"),"Team should contain Montgomery Forde");
        assertTrue(t.getMembers().contains("Ethan Solomon"),"Team should contain Ethan Solomon");
        assertTrue(t.getMembers().contains("Jeremiah Wong"),"Team should contain Jeremiah Wong");
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
