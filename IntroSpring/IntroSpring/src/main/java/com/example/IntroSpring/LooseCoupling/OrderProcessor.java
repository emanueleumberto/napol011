package com.example.IntroSpring.LooseCoupling;

public class OrderProcessor {

    //private PaymentGatway paymentGatway = new PaymentGatway(); // Errore!!
    //private PaymentGatway paymentGatway = new PostePay(); // Accoppiamento Stretto

    private PaymentGatway paymentGatway; // Accoppiamento debole

    // Dependency Injection su Costruttore
    public OrderProcessor(PaymentGatway paymentGatway) {
        this.paymentGatway = paymentGatway;
    }

    // Dependency Injection su Setter
    public void setPaymentGatway(PaymentGatway paymentGatway) {
        this.paymentGatway = paymentGatway;
    }

    public void processOrder(Order order) {
        paymentGatway.processPayment(order.getTotale());
    }
}
