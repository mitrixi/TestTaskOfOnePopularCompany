package my.sandbox.atm.service;

import my.sandbox.atm.model.enums.AtmCurrency;
import my.sandbox.atm.model.banknote.Banknote;
import my.sandbox.atm.model.enums.ExchangeType;

import java.util.Map;

public interface ClientOperationsService {

    Map<Banknote, Integer> withdrawFromAccount(AtmCurrency atmCurrency, ExchangeType exchangeType, Integer withdrawalAmount);

}
