package lv.rvt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import rvt.Money;


public class MoneyTest {

    @Test
    public void testPlusEurosAndCents() {
        Money money = new Money(5, (byte)50);
        Money newMoney = money.plus(2, 25);
        assertEquals(7, newMoney.euros());
        assertEquals(75, newMoney.cents());
    }

    @Test
    public void testPlusEuros() {
        Money money = new Money(5, (byte)50);
        Money newMoney = money.plus(2);
        assertEquals(7, newMoney.euros());
        assertEquals(50, newMoney.cents());
    }

    @Test
    public void testPlusCents() {
        Money money = new Money(5, (byte)50);
        Money newMoney = money.plus((byte)25);
        assertEquals(5, newMoney.euros());
        assertEquals(75, newMoney.cents());
    }

    @Test
    public void lessThanTest() 
    {
        Money a = new Money(2, (byte)105);
        Money b = new Money(-1, (byte)3);
        boolean c = a.lessThan(b);
        assertTrue(!c);
    }
    @Test
    public void minusTest()
    {
        Money a = new Money(2, (byte)50);
        Money b = new Money(-1, (byte)-30);
        Money c = a.plus(b);
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
        a = new Money(5, (byte)4);
        assertEquals(4, a.cents());
        assertEquals(5, a.euros());
    }

    @Test
    public void isMoneyEqual()
    {
        Money mon1 = new Money(5, (byte)50);
        Money mon2 = new Money(5, (byte)50);
        assertEquals(mon1, mon2);

        mon1 = new Money();
        mon2 = new Money();
        assertEquals(mon1, mon2);
    }

    @Test
    public void isMoneyNotEqual()
    {
        Money mon1 = new Money(5, (byte)50);
        Money mon2 = new Money(6);
        assertNotEquals(mon1, mon2);
    }
}