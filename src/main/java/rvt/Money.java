package rvt;

public class Money {

    private final int euros;
    private final byte cents;

    public Money(int euros, byte cents) {
        this.euros = euros;
        this.cents = cents;
    }

    public Money(int euros) {
        this(euros, (byte)0);
    }

    public Money() {
        this(0, (byte)0);
    }

    public int euros() {
        return euros;
    }

    public byte cents() {
        return cents;
    }

    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        Money compared = (Money) object;

        return this.euros == compared.euros && this.cents == compared.cents;
    }
    
    public Money plus(Money addition) {
        int totalEuros = this.euros + addition.euros;
        byte totalCents = (byte) (this.cents + addition.cents);
        return new Money(totalEuros, totalCents);
    }
    
     public Money plus(int additionalEuros, int additionalCents) {
        int totalEuros = this.euros + additionalEuros;
        byte totalCents = (byte) (this.cents + additionalCents);
        return new Money(totalEuros, totalCents);
    }

    public Money plus(double addition) {
        int additionalEuros = (int) addition;
        byte additionalCents = (byte) ((addition - additionalEuros) * 100);
        return plus(additionalEuros, additionalCents);
    }

    public Money plus(int additionalEuros) {
        return plus(additionalEuros, 0);
    }

    public Money plus(byte additionalCents) {
        return plus(0, additionalCents);
    }

    public boolean lessThan(Money compared) {
        if (this.euros < compared.euros) {
            return true;
        }
        if (this.euros == compared.euros && this.cents < compared.cents) {
            return true;
        }
        return false;
    }
}