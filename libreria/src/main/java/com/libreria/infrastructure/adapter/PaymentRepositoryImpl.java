/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.adapter;

import com.libreria.application.repository.PaymentRepository;
import com.libreria.domain.Payment;
import com.libreria.infrastructure.entity.PaymentEntity;
import com.libreria.infrastructure.mapper.PaymentMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wstov
 */
@Repository
public class PaymentRepositoryImpl implements PaymentRepository{
    private final PaymentCrudRepository paymentCrudRepository;
    private final PaymentMapper paymentMapper;

    public PaymentRepositoryImpl(PaymentCrudRepository paymentCrudRepository, PaymentMapper paymentMapper) {
        this.paymentCrudRepository = paymentCrudRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentMapper.toPayment(paymentCrudRepository.save(paymentMapper.toPaymentEntity(payment)));
    }

    @Override
    public Payment findById(Integer id) {
        return paymentMapper.toPayment(paymentCrudRepository.findById(id).get());
    }   
}
