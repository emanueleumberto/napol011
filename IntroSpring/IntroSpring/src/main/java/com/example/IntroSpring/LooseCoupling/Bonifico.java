package com.example.IntroSpring.LooseCoupling;

public class Bonifico implements PaymentGatway{
    @Override
    public void processPayment(double totalOrder) {
        System.out.println("Pagamento di €" + totalOrder + " effettuato tramite Bonifico!");
    }
}
