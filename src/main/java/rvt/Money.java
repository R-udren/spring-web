package rvt;

public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {
        this.euros = euros;
        this.cents = cents;
    }
    public Money(int euros) {
        this(euros, 0);
    }
    public Money() {
        this(0, 0);
    }
    public int euros() {
        return euros;
    }
    
    public int cents() {
        return cents;
    }

    public String toString() {
        String zero = "";
        if (cents <= 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "€";
    }
    
    public Money plus(Money addition) {
        int a;
        int b;
        if (addition.euros() < 0 && addition.cents() >= 0) 
        {
            a = cents() - addition.cents();
            b = euros() + addition.euros() + a / 100;

        } 
        else if (euros() < 0 && cents() >= 0)
        {
            a = addition.cents() - cents();
            b = euros() + addition.euros() + a / 100;

        }
        else 
        {
            a = cents() + addition.cents();
            b = euros() + addition.euros() + a / 100;
        }
        Money newMoney;
        
        if ((b < 0) || (b <= 0 && a <= 0)) 
        {
            newMoney = new Money(0, 0);
        } 
        else if (a < 0) 
        {
            newMoney = new Money(b - 1, 100 + a);
        }
        else 
        {
            newMoney = new Money(b, a % 100);
        }
        
        return newMoney;
    }

    public boolean lessThan(Money compared) {
        return !(euros() > compared.euros() && cents() >= compared.cents());

    }

    public Money minus(Money decreaser) {
        int a = euros() - decreaser.euros();
        int b = cents() - decreaser.cents();
        Money decreasedvalue;

        if ((a <= 0 && b <=0) || (a < 0)) {
            decreasedvalue = new Money(0, 0);
        } else if (b <= 0 && a > 0){
            decreasedvalue = new Money(a - 1, 100 + b);
        } else {
            decreasedvalue = new Money(a, b);
        }

        
        return decreasedvalue;
    }
}