package my.sandbox.atm.factory;

import my.sandbox.atm.model.enums.AtmCurrency;
import my.sandbox.atm.model.store.CurrencyStore;
import my.sandbox.atm.model.store.impl.RubStore;
import my.sandbox.atm.model.store.impl.UsdStore;

import java.util.Map;

import static my.sandbox.atm.model.enums.AtmCurrency.RUB;
import static my.sandbox.atm.model.enums.AtmCurrency.USD;

public class CurrencyStoreFactory {

    private final static Map<AtmCurrency, CurrencyStore> stores = Map.of(
            RUB, new RubStore(),
            USD, new UsdStore()
    );

    public CurrencyStore getStoreInstance(AtmCurrency atmCurrency) {
        return stores.get(atmCurrency);
    }
}
