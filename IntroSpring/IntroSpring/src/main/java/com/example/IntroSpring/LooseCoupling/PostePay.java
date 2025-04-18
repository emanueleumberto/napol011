package com.example.IntroSpring.LooseCoupling;

public class PostePay implements PaymentGatway{
    @Override
    public void processPayment(double totalOrder) {
        System.out.println("Pagamento di €" + totalOrder + " effettuato tramite PostePay!");
    }
}
