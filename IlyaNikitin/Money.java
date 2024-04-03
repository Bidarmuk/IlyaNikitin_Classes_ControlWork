public class Money {
    public long rubles;
    public byte kopecks;

    public Money(long rubles, byte kopecks) {
        if (kopecks >= 100) {
            throw new IllegalArgumentException("Копеек должно быть меньше 100. Некорректный ввод");        //обработка исключения
        }
        this.rubles = rubles;
        this.kopecks = kopecks;
    }
 
    public Money add(Money other) {                                // Сложение
        long totalRubles = this.rubles + other.rubles;
        int totalKopecks = this.kopecks + other.kopecks;
        if (totalKopecks >= 100) {
            totalRubles++;
            totalKopecks -= 100;
        }
        return new Money(totalRubles, (byte) totalKopecks);
    }

    public Money subtract(Money other) {                            // Раазница 
        long totalRubles = this.rubles - other.rubles;     
        int totalKopecks = this.kopecks - other.kopecks;
        if (totalKopecks < 0) {
            totalRubles--;
            totalKopecks += 100;
        }
        return new Money(totalRubles, (byte) totalKopecks);
    }

    public Money multiply(double multiplier) {                        // Умножение 
        double totalAmount = this.rubles + this.kopecks / 100.0;
        totalAmount *= multiplier;
        long newRubles = (long) totalAmount;
        byte newKopecks = (byte) ((totalAmount - newRubles) * 100);
        return new Money(newRubles, newKopecks);
    }

    public double divide(Money other) {
        double thisAmount = this.rubles + this.kopecks / 100.0;
        double otherAmount = other.rubles + other.kopecks / 100.0;    // Деление 
        if (otherAmount == 0) {                                       // Обработка возможной ошибки в дедлении
            throw new IllegalArgumentException("На 0 нельзя делить. Ошибка.");  
        }
        return thisAmount / otherAmount;
    }

    public boolean equals(Money other) {
        return (this.rubles == other.rubles && this.kopecks == other.kopecks);   // Сравнение сумм
    }

    public void print() {
        System.out.println(rubles + "," + kopecks);   // Вывод копеек через ","
    }

    public static void main(String[] args) {
        try {
            Money m1 = new Money(10, (byte) 31);
            Money m2 = new Money(12, (byte) 13);

            Money sum = m1.add(m2);
            System.out.println("Сумма: ");
            sum.print();

            Money diff = m1.subtract(m2);
            System.out.println("Разница: ");
            diff.print();

            double divisionResult = m1.divide(m2);
            System.out.println("Результат деления: " + divisionResult);

            Money product = m1.multiply(1.5);
            System.out.println("Результат умножения: ");
            product.print();

            if (m1.equals(m2)) {
                System.out.println("Денежные суммы равны");
            } else {
                System.out.println("Денежные суммы не равны");
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
