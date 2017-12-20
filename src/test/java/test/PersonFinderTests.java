package test;

import algorithm.Criteria;
import algorithm.Person;
import algorithm.PersonAgeComparison;
import algorithm.PersonFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonFinderTests {

    private Person sue;
    private Person greg;
    private Person sarah;
    private Person mike;

    @Before
    public void beforeClass() {
        sue = new Person("Sue", new Date(50, 0, 1));
        greg = new Person("Greg", new Date(52, 5, 1));
        sarah = new Person("Sarah", new Date(82, 0, 1));
        mike = new Person("Mike", new Date(79, 0, 1));
    }

    @Test
    public void Returns_Empty_Results_When_Given_Empty_List() {
        List<Person> list = new ArrayList<>();
        PersonFinder personFinder = new PersonFinder(list);

        PersonAgeComparison personAgeComparison = personFinder.findBy(Criteria.CLOSEST_AGE_DIFFERENCE);

        assertEquals(null, personAgeComparison.getOlder());
        assertEquals(null, personAgeComparison.getYounger());
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        List<Person> list = new ArrayList<>();
        list.add(sue);

        PersonFinder personFinder = new PersonFinder(list);

        PersonAgeComparison personAgeComparison = personFinder.findBy(Criteria.CLOSEST_AGE_DIFFERENCE);

        assertEquals(null, personAgeComparison.getOlder());
        assertEquals(null, personAgeComparison.getYounger());
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(greg);
        PersonFinder personFinder = new PersonFinder(list);

        PersonAgeComparison personAgeComparison = personFinder.findBy(Criteria.CLOSEST_AGE_DIFFERENCE);

        assertEquals(sue, personAgeComparison.getOlder());
        assertEquals(greg, personAgeComparison.getYounger());
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<>();
        list.add(mike);
        list.add(greg);

        PersonFinder personFinder = new PersonFinder(list);

        PersonAgeComparison personAgeComparison = personFinder.findBy(Criteria.FURTHEST_AGE_DIFFERENCE);

        assertEquals(greg, personAgeComparison.getOlder());
        assertEquals(mike, personAgeComparison.getYounger());
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(mike);
        list.add(greg);
        list.add(sarah);
        PersonFinder personFinder = new PersonFinder(list);

        PersonAgeComparison personAgeComparison = personFinder.findBy(Criteria.FURTHEST_AGE_DIFFERENCE);

        assertEquals(sue, personAgeComparison.getOlder());
        assertEquals(sarah, personAgeComparison.getYounger());
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        PersonFinder personFinder = new PersonFinder(list);

        PersonAgeComparison personAgeComparison = personFinder.findBy(Criteria.CLOSEST_AGE_DIFFERENCE);

        assertEquals(sue, personAgeComparison.getOlder());
        assertEquals(greg, personAgeComparison.getYounger());
    }

}
