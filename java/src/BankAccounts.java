import java.util.Random;
import java.util.Scanner;

public class BankAccounts {
    Random random = new Random();
    private int password,balance,pinCode,monthAfterOpen,comissions,type;
    String fio;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setComissions(int comissions) {
        this.comissions = comissions;
    }

    public int getMonthAfterOpen() {
        return monthAfterOpen;
    }

    public void setMonthAfterOpen(int monthAfterOpen) {
        this.monthAfterOpen = monthAfterOpen;
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
        System.out.println("Введите тип банковского аккаунта (1-3): ");this.type = Integer.parseInt(in.nextLine());
        this.balance = random.nextInt(70000);  // Так как внесение баланса лично, выглядит как то читерно, решил использовать Random
        this.monthAfterOpen = random.nextInt(36);
        this.comissions = comissions;

    }
}
