package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.ArrayList; 

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

    //same object
    @Test 
    public void equalsCase1() {
        Team temp = new Team("temp-team");
        assert(team.equals(team));
        assert(!(team.equals(temp)));
    }

    @Test 
    public void equalsCase2() {
        String test = "Different Class";
        assert(!(team.equals(test)));
    }

    @Test 
    public void equalsCase3() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");

        assert(t1.equals(t2));

        t2.setName("chris");
        assert(!(t1.equals(t2)));

        t2.addMember("john");
        assert(!(t1.equals(t2)));

        t2.setName("foo");
        assert(!(t1.equals(t2)));
    }

    @Test
    public void hashCodeEquals() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCodeEquivalentMutation() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
}
