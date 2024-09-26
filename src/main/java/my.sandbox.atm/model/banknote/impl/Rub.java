package my.sandbox.atm.model.banknote.impl;

import my.sandbox.atm.model.banknote.Banknote;

import static my.sandbox.atm.model.enums.AtmCurrency.RUB;

public class Rub extends Banknote {

    public Rub(Integer denomination) {
        super(RUB, denomination);
    }
}
