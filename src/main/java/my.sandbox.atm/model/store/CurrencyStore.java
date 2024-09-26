package my.sandbox.atm.model.store;

import lombok.Getter;
import my.sandbox.atm.model.banknote.Banknote;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

@Getter
public abstract class CurrencyStore {

    protected Map<Banknote, Integer> banknotes = new TreeMap<>(Comparator.comparingInt(Banknote::getDenomination).reversed());

}
