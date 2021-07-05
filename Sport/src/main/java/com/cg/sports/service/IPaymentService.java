package com.cg.sports.service;

import com.cg.sports.entity.Payment;


public interface IPaymentService {

	Payment addPayment(Payment payment);

	Payment removePayment(long paymentId);


	Payment updatePayment(long paymentId, Payment payment);
	
    public Payment getPayment(long paymentid) ;
    
	public java.util.List<Payment> getAllPaymentDetails();


}
