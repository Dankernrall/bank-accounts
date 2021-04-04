public abstract class BankAccount {
    private String fio;
    protected double balance;
    protected int hashPinCode;
    protected int month;
    public int check = 0;
    protected String detailing;

    public BankAccount(String fio, double balance, int pinCode, int month) {
        this.balance = balance;
        this.hashPinCode = this.hashCode() - pinCode; // Шифруем данные с помощью hashCode()
        this.month = month;
        this.fio = fio;
        this.detailing = "Счет открыт на имя " + fio + "\n";
    }

    //Пополнение баланса
    public String balanceRefill(double balance, int pinCode) {
        if (hashPinCode == this.hashCode() - pinCode) {   //Проверка пинкода через хэш
            this.balance = balance + this.balance;
            detailing += "Пополнение баланса на сумму: "
                    + balance + "\n";
            return "Пополнение баланса на сумму: " + balance;
        } else {
            return "Неверный пинкод";

        }
    }

    //Снятие наличных
    public String withdrawal(double money, int pinCode) {
        if (hashPinCode == this.hashCode() - pinCode) {  //Проверка пинкода через хэш
            if (money > this.balance) { //Проверяем наличие запрошенных денег на балансе
                return "Недостаточно средств на балансе!";
            } else {
                check++;
                this.balance = this.balance - money;
                detailing += "Снятие наличных на сумму: "  //Запись операции в детализацию
                        + money + "\n";
                return "Снятие наличных на сумму: " + money;
            }
        } else {
            return "Неверный пинкод";
        }

    }

    //Совершение покупки в магазине
    public String buyInMagazine(String nameMagazine, double buyPrice, int pinCode) {
        if (hashPinCode == this.hashCode() - pinCode) {  //Проверка пинкода через хэш
            if (buyPrice > balance) {   //Удостоверяемся в том, что на балансе достаточно денег
                return "Недостаточно средств на балансе!";
            } else {
                this.balance -= buyPrice;
                this.balance += cashBack(buyPrice); //Зачисляем кэшбек через метод
                detailing += "Покупка в магазине " + nameMagazine + " на сумму: "
                        + buyPrice + "\n";    //Добавляем информацию в детализацию
                return "Покупка в " + nameMagazine
                        + " на сумму: " + buyPrice +
                        "\nБаланс после операции: " + this.balance;
            }
        } else {
            return "Неверный пинкод";
        }
    }

    public String balance(int pinCode) {
        if (hashPinCode != this.hashCode() - pinCode) {
            return "Неверный пинкод";
        }
        return "Ваш баланс: " + this.balance;


    }

    //Методы по рассчету комиссий и штрафов
    protected String getFine() {
        return "";
    }

    protected String getCommission() {
        return "";
    }

    public double cashBack(double buyPrice) {
        return 0;
    }

    //Метод детализации по счету
    public String getDetailing(int pinCode) {
        if (hashPinCode == this.hashCode() - pinCode) {
            return detailing;
        }
        return "";
    }
}

