import java.util.Scanner;

public class BankOperations extends BankAccounts {
    Scanner in = new Scanner(System.in);
    private int countOperations = 0, money = 0, currentMonth = 5, lastMonth;
    String[] action = new String[20];

    void balanceInfo() {   //Запрос баланса
        System.out.print("Введите пароль для данной операции: ");
        if (in.nextLine().hashCode() == getPassword()) {    //Сравнение ХешКодов полученного пароля и установленного
            System.out.println("Баланс: " + getBalance() + "₽");
        } else {
            System.out.println("Введен не верный пароль");
        }
    }

    void withdraw() {     //Снятие средств
        System.out.print("Введите пароль для данной операции: ");
        if (in.nextLine().hashCode() == getPassword()) {  //Сравнение ХешКодов полученного пароля и установленного
            System.out.print("Введите сумму для снятия: ");
            int withdraw = Integer.parseInt(in.nextLine());
            if (getBalance() > withdraw) {
                int lastBalance = getBalance();//Проверка, чтобы не сняли больше, чем есть на балансе
                setBalance(lastBalance - withdraw);  //Установка нового баланса с учетом снятия
                System.out.println("Успешно! Произведено снятие " + withdraw + " рублей.");
                setAction(0, withdraw, lastBalance,currentMonth);
            } // Запись действия
            else System.out.println("Недостаточно средств!");
        } else {
            System.out.println("Введен не верный пароль");
        }
    }

    void replenishment() {     // Пополнение баланса
        System.out.print("Введите пароль для данной операции: ");
        if (in.nextLine().hashCode() == getPassword()) {  //Сравнение ХешКодов полученного пароля и установленного
            int lastBalance = getBalance();      //Учет баланса на момент операции
            System.out.print("Введите сумму для пополнения: ");
            int sum = Integer.parseInt(in.nextLine());//Выглядит максимально глупо, но к сожалению
            setBalance(lastBalance + sum); //мы не можем отслеживать количество поступивших денег, поэтому вписываем лично.
            setAction(1, sum, lastBalance,currentMonth); // Запись действия
        } else {
            System.out.println("Введен не верный пароль");
        }
    }

    void setAction(int operationType, int sum, int lastBalance, int currentMonth) { //Запись операций
        action[countOperations] = (operationType + ":" + sum + ":" + lastBalance + ":" + currentMonth); //Запись операции по формату
        countOperations++;                              // x:y:z:d где x - тип операции, y - сумма операции
    }                                              // z - баланс на время операции, d - месяц операции

    String[] getAction() {
        return action;
    }

    void getDetalisation() { // Детализация
        String[] arr = action;
        System.out.println("-----------Детализация-----------");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                String[] action = arr[i].split(":"); // Делим на необходимые нам аспекты
                switch (Integer.parseInt(action[0])) {
                    case 0:
                        System.out.println("--Снятие баланса--\nБаланс до операции: " + action[2]
                                + "₽\nСнято наличными: " + action[1] + "₽\nМесяц операции: " + action[3]);
                        break;
                    case 1:
                        System.out.println("--Пополнение баланса--\nБаланс до операции: " + action[2]
                                + "₽\nВнесено наличными: " + action[1] + "₽\nМесяц операции: " + action[3]);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    void checkType(int type) {
        if (type == 1) {   //Тип банковского счета 1 - Обычный
            if (getBalance() < 5000) {   //Если при выполнении любой операции баланс падает ниже 5000
                money = +100;       //начисляется штраф в 100 рублей.
                setComissions(money);
            }
            if (currentMonth > lastMonth) {
                lastMonth = currentMonth;                    //При наступлении нового месяца начисляется коммиссия
                double endOfMonthCommission = getBalance() * 0.10; //за обслуживания счета
                if (endOfMonthCommission < 100) {   //в размере наименьшего из двух: 10% от остатка на счете
                    money += endOfMonthCommission;  //если процент больше 100 рублей
                    setComissions(money);  // начисляется коммиссия в 100 рублей
                } else {
                    money += 100;
                    setComissions(money);
                }
            }
        } else if (type == 2) {
        //---------НЕ ЗАБУДЬ СДЕЛАТЬ КЭШБЕК 1% НА ОПЕРАЦИИ ОПЛАТЫ----------
        //---------НЕ ЗАБУДЬ СДЕЛАТЬ КЭШБЕК 1% НА ОПЕРАЦИИ ОПЛАТЫ----------
            if (currentMonth > lastMonth) {
                lastMonth = currentMonth;                    //При наступлении нового месяца начисляется коммиссия
                double endOfMonthCommission = getBalance() * 0.10; //за обслуживания счета
                if (endOfMonthCommission < 100) {   //в размере наименьшего из двух: 10% от остатка на счете
                    money += endOfMonthCommission;  //если процент больше 100 рублей
                    setComissions(money);  // начисляется коммиссия в 100 рублей
                } else {
                    money += 100;
                    setComissions(money);
                }

            }


        }
    }
}
