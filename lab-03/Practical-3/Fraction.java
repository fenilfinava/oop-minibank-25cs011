import java.util.Objects;

public class Fraction {
    private int num;
    private int den;

    private static int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    public Fraction(int num, int den) {
        if (den == 0) {
            den = 1;
        }
        int g = gcd(num, den);
        this.num = num / g;
        this.den = den / g;
    }

    public String toString() {
        return num + "/" + den;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return num == fraction.num && den == fraction.den;
    }

    public int hashCode() {
        return Objects.hash(num, den);
    }
}
