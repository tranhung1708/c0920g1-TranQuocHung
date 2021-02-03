package vn.codegym.common;

import vn.codegym.Model.Contract;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CheckDuration implements ConstraintValidator<ValidDuration, Contract> {

    public void initialize(ValidDuration constraint) {
    }

    @Override
    public boolean isValid(Contract contract, ConstraintValidatorContext context) {
        try{
            LocalDate start = LocalDate.parse(contract.getContractStartDate(), DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate end = LocalDate.parse(contract.getContractEndDate(), DateTimeFormatter.ISO_LOCAL_DATE);
            if(start.isBefore(end)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
