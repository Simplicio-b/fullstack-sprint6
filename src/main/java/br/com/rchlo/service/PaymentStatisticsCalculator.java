package br.com.rchlo.service;

import br.com.rchlo.data.PaymentRepository;
import br.com.rchlo.domain.Payment;
import br.com.rchlo.domain.PaymentStatus;
import br.com.rchlo.dto.PaymentStatistics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentStatisticsCalculator {

    private final PaymentRepository paymentRepository;

    public PaymentStatisticsCalculator(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentStatistics calculate() {
        List<Payment> allPayments = paymentRepository.all(); // será que essa é a melhor maneira de fazer isso?

        BigDecimal maximumConfirmedPayment = BigDecimal.ZERO;

        for (Payment payment : allPayments) {
            if (PaymentStatus.CONFIRMED.equals(payment.getStatus()) && maximumConfirmedPayment.compareTo(payment.getAmount()) < 0) {
                maximumConfirmedPayment = payment.getAmount();
            }
        }

        Map<PaymentStatus, Long> map = new HashMap<>();

        for (Payment payment : allPayments) {
            Long quantiny = map.get(payment.getStatus());

            if(quantiny == null) {
                quantiny = 1L;
            }else {
                quantiny++;
            }

            map.put(payment.getStatus(), quantiny);
        }

        PaymentStatistics paymentStatistics = new PaymentStatistics(maximumConfirmedPayment, map);
        return paymentStatistics;
    }
}
