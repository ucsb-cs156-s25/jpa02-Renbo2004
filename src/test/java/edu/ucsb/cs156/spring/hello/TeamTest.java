package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_True_Object(){
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_False_Object(){
        assertFalse(team.equals(null));
    }

    @Test
    public void equals_returns_True_twoParts(){
        Team t1 = new Team("foo");
        t1.addMember("bar");
        Team t2 = new Team("foo");
        t2.addMember("bar");
        assertTrue(t1.equals(t2));

        Team t3 = new Team("foo");
        t3.addMember("bar");
        Team t4 = new Team("foo");
        t4.addMember("notbar");
        assertFalse(t3.equals(t4));

        Team t5 = new Team("foo");
        t5.addMember("bar");
        Team t6 = new Team("notfoo");
        t6.addMember("bar");
        assertFalse(t5.equals(t6));

        Team t7 = new Team("foo");
        t7.addMember("bar");
        Team t8 = new Team("notfoo");
        t8.addMember("notbar");
        assertFalse(t7.equals(t8));
    }

    

   @Test    
    public void hashCode_retuern(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_Secondaryl(){
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        
        assertEquals(expectedResult, result);
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
