import java.util.*;
public class Fraction {
    public long wholePart;
    public short fractionalPart;

    public Fraction(long wholePart, short fractionalPart) {
        this.wholePart = wholePart;
        this.fractionalPart = fractionalPart;
    }

    public Fraction add(Fraction other) {                                              // сложение
        long newWholePart = this.wholePart + other.wholePart;
        short newFractionalPart = (short) (this.fractionalPart + other.fractionalPart);
        if (newFractionalPart >= 100) {
            newWholePart++;
            newFractionalPart -= 100;
        }
        return new Fraction(newWholePart, newFractionalPart);
    }

    public Fraction subtract(Fraction other) {                                         // разница, вычитание
        long newWholePart = this.wholePart - other.wholePart;
        short newFractionalPart = (short) (this.fractionalPart - other.fractionalPart);
        if (newFractionalPart < 0) {
            newWholePart--;
            newFractionalPart += 100;
        }
        return new Fraction(newWholePart, newFractionalPart);
    }

    public Fraction multiply(Fraction other) {                                          // умножение
        long newWholePart = this.wholePart * other.wholePart;    
        short newFractionalPart = (short) ((this.wholePart * other.fractionalPart) + (this.fractionalPart * other.wholePart) + (this.fractionalPart * other.fractionalPart / 100));
        return new Fraction(newWholePart, newFractionalPart);
    }
    public void print() {
        System.out.println(wholePart + "." + fractionalPart);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число так: сначала целую часть, через пробел дробную.");
        Fraction f1 = new Fraction(in.nextLong(), (short)in.nextShort());
        System.out.println("Введите второе число так: сначала целую часть, через пробел дробную.");
        Fraction f2 = new Fraction(in.nextLong(), (short)in.nextShort());
        
        System.out.println("Первое введённое вами число: ");
        f1.print();
        System.out.println("Второе введённое вами число: ");
        f2.print();

        Fraction sum = f1.add(f2);
        System.out.println("Результат их сложения: ");
        sum.print();

        Fraction difference = f1.subtract(f2);
        System.out.println("Их разница: ");
        difference.print();

        Fraction product = f1.multiply(f2);
        System.out.println("Результат их умножения: ");
        product.print();

        f1.print();
    }
}
