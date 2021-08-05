package br.com.rchlo.dto;

import br.com.rchlo.domain.PaymentStatus;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class PaymentStatistics {

    private BigDecimal maximumAmountOfConfirmedPayment;
    private Map<PaymentStatus, Long> paymentsStatitics;

    public PaymentStatistics(BigDecimal maximumAmountOfConfirmedPayment, Map<PaymentStatus, Long> map) {
        this.maximumAmountOfConfirmedPayment = maximumAmountOfConfirmedPayment;
        this.paymentsStatitics = map;
    }

    public BigDecimal getMaximumAmountOfConfirmedPayment() {
        return maximumAmountOfConfirmedPayment;
    }

    public Map<PaymentStatus, Long> getQuantityOfPaymentsByStatus() {
        return this.paymentsStatitics;
    }


}