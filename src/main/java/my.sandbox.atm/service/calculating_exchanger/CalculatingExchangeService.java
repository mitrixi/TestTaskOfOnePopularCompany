package my.sandbox.atm.service.calculating_exchanger;

import my.sandbox.atm.model.banknote.Banknote;

import java.util.Map;

public interface CalculatingExchangeService {

    Map<Banknote, Integer> calculateBanknotesToWithdraw(
            Integer withdrawalAmount, Map<Banknote, Integer> atmAvailableBanknotes);
}
