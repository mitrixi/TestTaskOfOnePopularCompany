package my.sandbox.atm;

import lombok.RequiredArgsConstructor;
import my.sandbox.atm.factory.CalculatingExchangeServiceFactory;
import my.sandbox.atm.factory.CurrencyStoreFactory;
import my.sandbox.atm.model.enums.AtmCurrency;
import my.sandbox.atm.model.banknote.Banknote;
import my.sandbox.atm.model.enums.ExchangeType;
import my.sandbox.atm.service.ClientOperationsService;
import my.sandbox.atm.service.MaintenanceOperationsService;
import my.sandbox.atm.service.calculating_exchanger.CalculatingExchangeService;

import java.util.Map;

@RequiredArgsConstructor
public class ATM implements ClientOperationsService, MaintenanceOperationsService {

    private final CalculatingExchangeServiceFactory calculatingExchangeServiceFactory;
    private final CurrencyStoreFactory currencyStore;

    @Override
    public void depositIntoAtm(Map<Banknote, Integer> depositingBanknotes) {
        depositingBanknotes.forEach((banknote, amount) ->
                currencyStore.getStoreInstance(banknote.getCurrency()).getBanknotes().put(banknote, amount));
    }

    @Override
    public Map<Banknote, Integer> withdrawFromAccount(
            AtmCurrency atmCurrency, ExchangeType exchangeType, Integer withdrawalAmount) {
        CalculatingExchangeService exchanger = calculatingExchangeServiceFactory.getInstance(exchangeType);
        return exchanger.calculateBanknotesToWithdraw(withdrawalAmount, currencyStore.getStoreInstance(atmCurrency).getBanknotes());
    }
}
