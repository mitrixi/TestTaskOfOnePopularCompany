package my.sandbox.atm.factory;

import my.sandbox.atm.model.enums.ExchangeType;
import my.sandbox.atm.service.calculating_exchanger.CalculatingExchangeService;
import my.sandbox.atm.service.calculating_exchanger.impl.ExchangeOfLargeService;
import my.sandbox.atm.service.calculating_exchanger.impl.ExchangeOfSmallService;

import java.util.Map;

public class CalculatingExchangeServiceFactory {

    private final static Map<ExchangeType, CalculatingExchangeService> services = Map.of(
            ExchangeType.SMALL, new ExchangeOfSmallService(),
            ExchangeType.LARGE, new ExchangeOfLargeService()
    );

    public CalculatingExchangeService getInstance(ExchangeType exchangeType) {
        return services.get(exchangeType);
    }
}
