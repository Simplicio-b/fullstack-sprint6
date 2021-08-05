package br.com.rchlo.service;

import br.com.rchlo.data.PaymentRepository;
import br.com.rchlo.domain.Card;
import br.com.rchlo.domain.Payment;
import br.com.rchlo.domain.PaymentStatus;
import br.com.rchlo.dto.PaymentStatistics;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class PaymentStatisticsCalculatorTest {

    @Mock
    private PaymentRepository paymentRepository;

    private PaymentStatisticsCalculator paymentStatisticsCalculator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(paymentRepository.all()).thenReturn(payments());
        paymentStatisticsCalculator = new PaymentStatisticsCalculator(paymentRepository);
    }

    @Test
    void shouldCalculateMaximumAmountOfConfirmedPayment() {
        PaymentStatistics paymentStatistics = paymentStatisticsCalculator.calculate();
        BigDecimal maximumAmountOfConfirmedPayment = paymentStatistics.getMaximumAmountOfConfirmedPayment();
        Assertions.assertThat(maximumAmountOfConfirmedPayment).isEqualTo(new BigDecimal("200.00"));
    }

    @Test
    void deveConsiderarQuantidadeDePagamentoPorStatus() {
        PaymentStatistics paymentStatistics = paymentStatisticsCalculator.calculate();

        Map<PaymentStatus, Long> quantityOfPaymentsByStatus = paymentStatistics.getQuantityOfPaymentsByStatus();

        Assertions.assertThat(quantityOfPaymentsByStatus)
                .containsEntry(PaymentStatus.CREATED, 2L)
                .containsEntry(PaymentStatus.CONFIRMED, 1L)
                .containsEntry(PaymentStatus.CANCELED, 1L);
    }

    public List<Payment> payments() {
        List<Payment> allPayments = new ArrayList<>();

        allPayments.add(
                new Payment(
                        new BigDecimal("200.00"),
                        new Card("SS", "1234", null, "302"),
                        PaymentStatus.CONFIRMED
                )
        );

        allPayments.add(
                new Payment(
                        new BigDecimal("100.00"),
                        new Card("SS", "1240", null, "312"),
                        PaymentStatus.CREATED
                )
        );

        allPayments.add(
                new Payment(
                        new BigDecimal("50.00"),
                        new Card("SS", "1240", null, "312"),
                        PaymentStatus.CREATED
                )
        );

        allPayments.add(
                new Payment(
                        new BigDecimal("10.00"),
                        new Card("SS", "1240", null, "312"),
                        PaymentStatus.CANCELED
                )
        );

        return allPayments;
    }

}