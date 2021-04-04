public class RegularAccount extends BankAccount {
    //Обычный счет

    final int FINE = 5000;
    final int COMMISSION = 100;
    final int PERCENT = 10;

    @Override
    public String balanceRefill(double balance, int pinCode) {
        return super.balanceRefill(balance, pinCode);
    }

    @Override
    //Реализация штрафа
    public String getFine() {
        if (balance > FINE) {
            return "";
        }
        balance -= COMMISSION;
        return "Сумма штрафа составляет: " + COMMISSION;
    }

    @Override
    //Реализация комиссии
    public String getCommission() {
        String totalCommission = "Комиссия за обслуживание составила: ";
        if (COMMISSION > balance / PERCENT) { //Увеличиваем месяц и взымываем коммисию с учетом баланса
            balance -= balance / PERCENT;
            return totalCommission + (balance / PERCENT);
        }
        balance -= COMMISSION;
        return totalCommission + (COMMISSION);


    }


    public RegularAccount(String fio, double balance, int pinCode, int month) {
        super(fio, balance, pinCode, month);
    }


}
