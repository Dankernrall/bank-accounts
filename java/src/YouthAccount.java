public class YouthAccount extends BankAccount {
//Молодежный счет

    public YouthAccount(String fio, double balance, int pinCode, int month) {
        super(fio, balance, pinCode, month);
    }

    @Override
    public double cashBack(double buyPrice) {
        return buyPrice * 0.02;
    }

    @Override
    protected String getFine() {
        month++; //Прибавляем месяц
        String totalCommission = "Штраф составил: ";
        if (check == 0) { //Если не было ни одной операции зачисляем штраф
            balance -= 300;
            return totalCommission + 300;
        }
        check = 0;
        return "У вас нет штрафа";


    }

    @Override
    public String withdrawal(double money, int pinCode) {
        if (hashPinCode == this.hashCode() - pinCode) {
            if (money + 10 > this.balance) {
                return "Недостаточно средств на балансе!";
            } else {
                check++;
                detailing += "снятие наличных на сумму: "
                        + money + "\n";
                this.balance = this.balance - money - 10;
                return "Снятие наличных на сумму: " + money;
            }
        } else {
            return "Неверный пинкод";
        }
    }
}
