package my.sandbox.atm.model.banknote.impl;

import lombok.Getter;
import my.sandbox.atm.model.banknote.Banknote;

import static my.sandbox.atm.model.enums.AtmCurrency.USD;

@Getter
public class Usd extends Banknote {

    public Usd(Integer denomination) {
        super(USD, denomination);
    }
}
