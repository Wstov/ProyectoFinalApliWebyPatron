
package com.libreria.application.repository;

import com.libreria.domain.Payment;

/**
 *
 * @author Wstov
 */
public interface PaymentRepository {
    public Payment createPayment(Payment payment);
    public Payment findById(Integer id);
}
