package my.sandbox.atm.service.calculating_exchanger.impl;

import my.sandbox.atm.exceptions.NotEnoughMoneyInAtmException;
import my.sandbox.atm.exceptions.NotMultipleAmountWithdrawalException;
import my.sandbox.atm.model.banknote.Banknote;
import my.sandbox.atm.service.calculating_exchanger.CalculatingExchangeService;

import java.util.Map;
import java.util.TreeMap;

import static java.util.Comparator.comparingInt;

public class ExchangeOfLargeService implements CalculatingExchangeService {

    @Override
    public Map<Banknote, Integer> calculateBanknotesToWithdraw(
            Integer withdrawalAmount, Map<Banknote, Integer> atmAvailableBanknotes) {
        int availableBanknotesSum = atmAvailableBanknotes.entrySet()
                .stream()
                .mapToInt(banknote -> banknote.getKey().getDenomination() * banknote.getValue())
                .sum();
        if (withdrawalAmount % ((TreeMap<Banknote, Integer>) atmAvailableBanknotes).lastKey().getDenomination() != 0) {
            throw new NotMultipleAmountWithdrawalException();
        }
        if (availableBanknotesSum < withdrawalAmount) {
            throw new NotEnoughMoneyInAtmException();
        }

        Map<Banknote, Integer> withdrawing = new TreeMap<>(comparingInt(Banknote::getDenomination).reversed()); //здесь TreeMap чтобы ATM упорядоченную пачку выдвавал

        while (withdrawalAmount != 0 && availableBanknotesSum != 0) {
            for (Map.Entry<Banknote, Integer> entry : atmAvailableBanknotes.entrySet()) {
                int requiredAmount = withdrawalAmount / entry.getKey().getDenomination();
                if (requiredAmount < entry.getValue()) {
                    withdrawing.put(entry.getKey(), requiredAmount);
                    atmAvailableBanknotes.put(entry.getKey(), entry.getValue() - requiredAmount);
                    withdrawalAmount = withdrawalAmount - requiredAmount * entry.getKey().getDenomination();
                }
            }
        }

        return withdrawing;
    }
}
