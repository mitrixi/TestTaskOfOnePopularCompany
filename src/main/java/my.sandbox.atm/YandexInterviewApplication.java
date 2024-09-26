package my.sandbox.atm;

import my.sandbox.atm.factory.CalculatingExchangeServiceFactory;
import my.sandbox.atm.factory.CurrencyStoreFactory;
import my.sandbox.atm.model.banknote.Banknote;
import my.sandbox.atm.model.banknote.impl.Rub;
import my.sandbox.atm.model.banknote.impl.Usd;
import my.sandbox.atm.model.enums.ExchangeType;

import java.util.HashMap;
import java.util.Map;

import static my.sandbox.atm.model.enums.AtmCurrency.RUB;

public class YandexInterviewApplication {

    public static void main(String[] args) {
        ATM atm = new ATM(new CalculatingExchangeServiceFactory(), new CurrencyStoreFactory());

        Map<Banknote, Integer> banknotes = new HashMap<>();
        banknotes.put(new Rub(5000), 555);
        banknotes.put(new Rub(1000), 111);
        banknotes.put(new Rub(500), 55);
        banknotes.put(new Rub(100), 11);

        banknotes.put(new Usd(20), 22);

        atm.depositIntoAtm(banknotes);

        Map<Banknote, Integer> banknoteIntegerMap = atm.withdrawFromAccount(RUB, ExchangeType.LARGE, 7600);
        banknoteIntegerMap.forEach((banknote, integer) -> System.out.println(banknote + " " + integer));
    }

}
