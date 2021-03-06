public class AdvancedAccount extends BankAccount {
    //Продвинутый счет

    final double CASHBACKPERC = 0.01;
    final int COMMISSION = 100; //Коммиссия
    final int PERCENT = 10; //Процент

    public AdvancedAccount(String fio, double balance, int pinCode, int month) {
        super(fio, balance, pinCode, month);
    }

    //Рассчет кэшбека
    @Override
    public double cashBack(double buyPrice) {
        if (buyPrice * CASHBACKPERC > 100) {
            return 100;
        } else {
            return buyPrice * CASHBACKPERC;
        }

    }

    @Override
    //Реализация комиссии
    protected String getCommission() {
        month++; //Увиличивем месяц
        String totalCommission = "Комиссия за обслуживание: ";
        if (COMMISSION > balance / PERCENT) { //Зачисление комиссии с учетом баланса
            balance -= balance / PERCENT;
            return totalCommission + (balance / PERCENT);
        }
        balance -= COMMISSION;
        return totalCommission + (COMMISSION);

    }


}
