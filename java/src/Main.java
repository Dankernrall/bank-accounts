import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int type;
        double balance;
        int pinCode;
        int month;
        String fio;
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        try {
            System.out.print("Здравствуйте! Какой тип счета вы хотите открыть?" +
                    "\n1) Обычный счет" + "\n2) Молодежный счет" +
                    "\n3) Продвинутый счет" + "\nОтвет(1-3): ");
            type = Integer.parseInt(in.nextLine());  //Выбираем тип аккаунта
            System.out.print("Введите свое ФИО.\nОтвет: ");
            fio = in.nextLine();
            balance = (double) random.nextInt(15000);
            System.out.print("Введите Пин-Код!\nОтвет: ");
            pinCode = in.nextInt();
            month = random.nextInt(12);
            Menu menu = new Menu();
            switch (type) { //Программа выбирает аккаунт с учетом выбора
                case 1:
                    RegularAccount rAccount = new RegularAccount(fio, balance, pinCode, month);
                    menu.startMenu(rAccount);
                    break;
                case 2:
                    YouthAccount yAccount = new YouthAccount(fio, balance, pinCode, month);
                    menu.startMenu(yAccount);
                    break;
                case 3:
                    AdvancedAccount aAccount = new AdvancedAccount(fio, balance, pinCode, month);
                    menu.startMenu(aAccount);
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Введен не верный символ!");
        }
    }
}