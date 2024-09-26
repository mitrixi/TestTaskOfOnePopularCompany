package my.sandbox.atm.service.calculating_exchanger.impl;

import my.sandbox.atm.model.banknote.Banknote;
import my.sandbox.atm.service.calculating_exchanger.CalculatingExchangeService;

import java.util.Map;

public class ExchangeOfSmallService implements CalculatingExchangeService {

    @Override
    public Map<Banknote, Integer> calculateBanknotesToWithdraw(
            Integer withdrawalAmount, Map<Banknote, Integer> atmAvailableBanknotes) {

        return null;
    }
}
