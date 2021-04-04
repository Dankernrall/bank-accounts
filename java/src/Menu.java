import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner in = new Scanner(System.in);
    private int pincode;
    protected int get;
    public String magazine = "СпортМастер"; //Магазин для демонстрации

    public void startMenu(BankAccount ob) {
        String keepGoing = "Y";
        while (keepGoing.equals("Y")) {
            try {
                System.out.println("Что за операцию вы желаете сделать?\n1) Пополнить баланс" +
                        "\n2) Снять деньги" + "\n3) Оплатить покупку" + "\n4) Запросить детализацию" +
                        "\n5) Посмотреть баланс" + "\n6) Посмотреть штрафы");
                get = in.nextInt();
                switch (get) {
                    case 1:  //Пополнение
                        System.out.print("Введите ПинКод\nОтвет: ");
                        pincode = in.nextInt();
                        System.out.print("Какую сумму?\nОтвет: ");
                        get = in.nextInt();
                        System.out.println(ob.balanceRefill(get, pincode));
                        break;
                    case 2: //Снятие
                        System.out.print("Введите ПинКод\nОтвет: ");
                        pincode = in.nextInt();
                        System.out.print("Какую сумму?\nОтвет: ");
                        get = in.nextInt();
                        System.out.println(ob.withdrawal(get, pincode));
                        break;
                    case 3://Оплата
                        System.out.print("Введите ПинКод\nОтвет: ");
                        pincode = in.nextInt();
                        System.out.print("Введите сумму оплаты\nОтвет: "); //Странно, но все же
                        get = in.nextInt();
                        System.out.println(ob.buyInMagazine(magazine, get, pincode));
                        break;
                    case 4://Детализация
                        System.out.print("Введите ПинКод\nОтвет: ");
                        pincode = in.nextInt();
                        System.out.println(ob.detailing);
                        break;
                    case 5://Баланс
                        System.out.print("Введите ПинКод\nОтвет: ");
                        pincode = in.nextInt();
                        System.out.println(ob.balance(pincode));
                    case 6://Штрафы
                        System.out.println(ob.getFine());
                }
                System.out.print("Следующая команда? (y/n)\nОтвет: ");
                keepGoing = in.next().toUpperCase();

            } catch (InputMismatchException e) {
                System.out.println("Неверный символ!");
                System.exit(0);
            }
        }
    }
}
