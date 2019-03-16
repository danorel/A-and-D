package date;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DateUnitTester {
    private ArrayList<Date> dates;
    private ArrayList<String> results;

    @org.junit.Before
    public void setUp() throws Exception {
        dates = new ArrayList<>();
        dates.add(new Date("03 January 1503"));
        dates.add(new Date("06 October 2011"));
        dates.add(new Date("01 11 1961"));
        dates.add(new Date("05 15 1933"));
        dates.add(new Date("-01 10 2056"));
        dates.add(new Date("04 12 2000"));
        dates.add(new Date("05 11 2095"));
        dates.add(new Date("03 January 2301"));
        dates.add(new Date("01 February 1921"));
        dates.add(new Date("-05 -02 1432"));
        dates.add(new Date("21 10 2000"));
        dates.add(new Date("04 12 2000"));
        dates.add(new Date("16 14 2043"));
        dates.add(new Date("18 04 2020"));

        results = new ArrayList<>();
        results.add("Saturday");
        results.add("Thursday");
        results.add("Wednesday");
        results.add("Thursday");
        results.add("Sunday");
        results.add("Monday");
        results.add("Saturday");
        results.add("Saturday");
        results.add("Tuesday");
        results.add("Thursday");
        results.add("Saturday");
        results.add("Monday");
        results.add("Friday");
        results.add("Saturday");
    }

    @org.junit.Test
    public void getDayOfWeek() {
        for(int test = 0; test < dates.size(); test++){
            Assert.assertEquals(results.get(test), dates.get(test).getDayOfWeek());
        }
    }

    @org.junit.Test
    public void testConstructorWithStringParameter(){
        Date firstDate = new Date("05 12 1943");
        Assert.assertEquals(5, firstDate.getDay());
        Assert.assertEquals(12, firstDate.getMonth());
        Assert.assertEquals(1943, firstDate.getYear());
    }

    @org.junit.Test
    public void testConstructorWithThreeNumericParameters(){
        Date firstDate = new Date(5, 12, 2020);
        Assert.assertEquals(5, firstDate.getDay());
        Assert.assertEquals(12, firstDate.getMonth());
        Assert.assertEquals(2020, firstDate.getYear());
    }

    @org.junit.Test
    public void testConstructorWithTwoNumericParameters(){
        Date firstDate = new Date(17, 13);
        Assert.assertEquals(17, firstDate.getDay());
        Assert.assertEquals(1, firstDate.getMonth());
        Assert.assertEquals(1920, firstDate.getYear());
    }

    @org.junit.Test
    public void testConstructorWithOneNumericParameter(){
        Date firstDate = new Date(13);
        Assert.assertEquals(13, firstDate.getDay());
        Assert.assertEquals(1, firstDate.getMonth());
        Assert.assertEquals(1920, firstDate.getYear());
    }
}
