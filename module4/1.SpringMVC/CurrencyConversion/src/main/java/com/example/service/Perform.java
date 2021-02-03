package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class Perform implements Calculate {
    @Override
    public double calculate(double usd) {
        return usd*23000;
    }
}
