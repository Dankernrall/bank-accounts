import java.util.Random;
import java.util.Scanner;

public class BankAccounts {
    Random random = new Random();
    private int password,balance,pinCode,monthAfterOpen,comissions;
    String fio;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public String getFio() {
        return fio;
    }

    Scanner in = new Scanner(System.in);
    BankAccounts() {  // Конструктор банковского аккаунта
        System.out.print("Введите ФИО: ");this.fio = in.nextLine();
        System.out.print("Введите пароль: ");this.password = in.nextLine().hashCode(); //Для безопасности сохраняем только
        System.out.print("Введите Пин-Код: ");this.pinCode = in.nextLine().hashCode(); //Хэш Коды паролей
        this.balance = random.nextInt(70000);  // Так как внесение баланса лично, выглядит как то читерно, решил использовать Random
        this.monthAfterOpen = random.nextInt(36);
        this.comissions = comissions;

    }
}
