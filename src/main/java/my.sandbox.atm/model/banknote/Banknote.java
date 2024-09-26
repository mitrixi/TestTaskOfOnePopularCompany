package my.sandbox.atm.model.banknote;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import my.sandbox.atm.model.enums.AtmCurrency;

@ToString
@Getter
@AllArgsConstructor
public abstract class Banknote {
    protected final AtmCurrency currency;
    protected final Integer denomination;
}
