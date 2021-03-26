import java.util.Scanner;

public class BankOperations extends BankAccounts{
Scanner in = new Scanner(System.in);
private int countOperations = 0;
String [] action = new String[20];

    void balanceInfo(){   //Запрос баланса
        System.out.print("Введите пароль для данной операции: ");
        if (in.nextLine().hashCode() == getPassword()){    //Сравнение ХешКодов полученного пароля и установленного
            System.out.println("Баланс: " + getBalance() + "₽");
        }
        else{
            System.out.println("Введен не верный пароль");
        }
    }
    void withdraw(){     //Снятие средств
        System.out.print("Введите пароль для данной операции: ");
        if (in.nextLine().hashCode() == getPassword()){  //Сравнение ХешКодов полученного пароля и установленного
            System.out.print("Введите сумму для снятия: ");
            int withdraw = Integer.parseInt(in.nextLine());
            if (getBalance() > withdraw){
            int lastBalance = getBalance();//Проверка, чтобы не сняли больше, чем есть на балансе
            setBalance(lastBalance - withdraw);  //Установка нового баланса с учетом снятия
            System.out.println("Успешно! Произведено снятие " + withdraw + " рублей.");
            setAction(0,withdraw,lastBalance);} // Запись действия
            else System.out.println("Недостаточно средств!");
        }
        else{
            System.out.println("Введен не верный пароль");
        }
    }
    void replenishment() {     // Пополнение баланса
        System.out.print("Введите пароль для данной операции: ");
        if (in.nextLine().hashCode() == getPassword()) {  //Сравнение ХешКодов полученного пароля и установленного
            int lastBalance = getBalance();      //Учет баланса на момент операции
            System.out.print("Введите сумму для пополнения: ");
            int sum = Integer.parseInt(in.nextLine());//Звучит максимально глупо, но к сожалению
            setBalance(lastBalance + sum); //мы не можем отслеживать количество поступивших денег.
            setAction(1,sum,lastBalance); // Запись действия
        }
        else{
                System.out.println("Введен не верный пароль");
            }
        }
    void setAction(int operationType,int sum, int lastBalance){ //Запись операций
    action[countOperations] = (operationType + ":" + sum + ":" + lastBalance); //Запись операции по формату
    countOperations++;                              // x:y:z где x - тип операции, y - сумма
    }                                              // z - баланс на время операции
    String[] getAction(){
        return action;
    }
    void getDetalisation() { // Детализация
        String[] arr = action;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] != null){
                String[] action = arr[i].split(":"); // Делим на необходимые нам аспекты
                switch (Integer.parseInt(action[0])) {
                    case 0:
                        System.out.println("--Снятие баланса--\nБаланс до операции: " + action[2]
                                + "\nСнято наличными: " + action[1] + "₽");
                        break;
                    case 1:
                        System.out.println("--Пополнение баланса--\nБаланс до операции: " + action[2]
                                + "\nВнесено наличными: " + action[1] + "₽");
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
