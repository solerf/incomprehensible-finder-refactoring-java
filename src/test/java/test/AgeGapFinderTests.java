package test;

import algorithm.AgeGapFinder;
import algorithm.AgeGapResult;
import algorithm.Criteria;
import algorithm.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class AgeGapFinderTests {

    private Person sue;
    private Person greg;
    private Person sarah;
    private Person mike;

    @Before
    public void setup() {
        sue = new Person("Sue", LocalDate.of(1950, Month.JANUARY, 1));
        greg = new Person("Greg", LocalDate.of(1952, Month.JUNE, 1));
        sarah = new Person("Sarah", LocalDate.of(1982, Month.JANUARY, 1));
        mike = new Person("Mike", LocalDate.of(1979, Month.JANUARY, 1));
    }

    @Test
    public void Returns_Empty_Results_When_Given_Empty_List() {
        List<Person> list = new ArrayList<>();

        AgeGapFinder ageGapFinder = new AgeGapFinder(list);
        Optional<AgeGapResult> result = ageGapFinder.findBy(Criteria.CLOSEST);

        assertEquals(false, result.isPresent());
        assertEquals(false, result.isPresent());
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        List<Person> list = new ArrayList<>();
        list.add(sue);

        AgeGapFinder ageGapFinder = new AgeGapFinder(list);
        Optional<AgeGapResult> result = ageGapFinder.findBy(Criteria.CLOSEST);

        assertEquals(false, result.isPresent());
        assertEquals(false, result.isPresent());
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(greg);

        AgeGapFinder ageGapFinder = new AgeGapFinder(list);
        Optional<AgeGapResult> result = ageGapFinder.findBy(Criteria.CLOSEST);

        assertEquals(true, result.isPresent());
        assertEquals(sue, result.get().getOldest());
        assertEquals(greg, result.get().getYoungest());
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<>();
        list.add(mike);
        list.add(greg);

        AgeGapFinder ageGapFinder = new AgeGapFinder(list);
        Optional<AgeGapResult> result = ageGapFinder.findBy(Criteria.FURTHEST);

        assertEquals(true, result.isPresent());
        assertEquals(greg, result.get().getOldest());
        assertEquals(mike, result.get().getYoungest());
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        AgeGapFinder ageGapFinder = new AgeGapFinder(list);
        Optional<AgeGapResult> result = ageGapFinder.findBy(Criteria.FURTHEST);

        assertEquals(true, result.isPresent());
        assertEquals(sue, result.get().getOldest());
        assertEquals(sarah, result.get().getYoungest());
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        AgeGapFinder ageGapFinder = new AgeGapFinder(list);
        Optional<AgeGapResult> result = ageGapFinder.findBy(Criteria.CLOSEST);

        assertEquals(true, result.isPresent());
        assertEquals(sue, result.get().getOldest());
        assertEquals(greg, result.get().getYoungest());
    }

}
