package br.com.rchlo.dto;

import br.com.rchlo.domain.PaymentStatus;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PaymentStatistics {

    private BigDecimal maximumAmountOfConfirmedPayment;
    private HashMap<PaymentStatus, Long> paymentStatus;

    public PaymentStatistics(BigDecimal maximumAmountOfConfirmedPayment) {
        this.maximumAmountOfConfirmedPayment = maximumAmountOfConfirmedPayment;
    }

    public BigDecimal getMaximumAmountOfConfirmedPayment() {
        return maximumAmountOfConfirmedPayment;
    }

    public Map<PaymentStatus, Long> getQuantityOfPaymentsByStatus() {
        return paymentStatus;
    }

    public void addPaymentForStatus(PaymentStatus status) {
        Long quantity = this.paymentStatus.get(status);
        if (quantity == null) {
            quantity = 1L;
        } else {
            quantity++;
        }
        this.paymentStatus.put(status, quantity);
    }

}
