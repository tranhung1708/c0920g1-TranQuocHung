package vn.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class Perform implements Calculate {
    @Override
    public long calculate(long usd) {
        return usd*23000;
    }
}
