/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.application.service;

import com.libreria.application.repository.PaymentRepository;
import com.libreria.domain.Payment;

/**
 *
 * @author Wstov
 */
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    
    public Payment createPayment(Payment payment){
        return paymentRepository.createPayment(payment);
    }


    public Payment getPaymentById(Integer id){
        return paymentRepository.findById(id);
    }
}
