package lv.rvt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import rvt.Money;

public class MoneyTest {
    
    @Test
    public void plusTest() 
    {
        Money a = new Money(2, 105);
        Money b = new Money(-1, 3);
        Money c = a.plus(b);
        assertEquals(2, c.euros());
        assertEquals(2, c.cents());
    }
    @Test
    public void lessThanTest() 
    {
        Money a = new Money(2, 105);
        Money b = new Money(-1, 3);
        boolean c = a.lessThan(b);
        assertTrue(!c);
    }
    @Test
    public void minusTest()
    {
        Money a = new Money(2, 50);
        Money b = new Money(1, 30);
        Money c = a.minus(b);
        assertEquals(1, c.euros());
        assertEquals(20,c.cents());
    }
    @Test
    public void valuesTest()
    {
        Money a = new Money();
        assertEquals(0, a.cents());
        assertEquals(0, a.euros());
        a = new Money(5);
        assertEquals(0, a.cents());
        assertEquals(5, a.euros());
        a = new Money(5, 4);
        assertEquals(4, a.cents());
        assertEquals(5, a.euros());
    }
}