package my.sandbox.atm.service;

import my.sandbox.atm.model.banknote.Banknote;

import java.util.Map;

public interface MaintenanceOperationsService {

    void depositIntoAtm(Map<Banknote, Integer> depositingBanknotes);
}
