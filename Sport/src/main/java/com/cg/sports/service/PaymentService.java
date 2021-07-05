package com.cg.sports.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sports.entity.Payment;
import com.cg.sports.repository.IPaymentRepository;


@Service
public class PaymentService implements IPaymentService {
	
	
	@Autowired
	IPaymentRepository paymentRepository;
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

	@Override
	public Payment addPayment(Payment payment) {
		LOGGER.info("Called addPayment() method of PaymentService");
		return paymentRepository.save(payment);
	}
	
	
	@Override
	public Payment removePayment(long paymentId) {
		LOGGER.info("Called removePayment() method of PaymentService");

		Optional<Payment> searchedPayment = paymentRepository.findById(paymentId);
		if (searchedPayment.isPresent()) {
			Payment paymentToDelete = searchedPayment.get();
			paymentRepository.delete(paymentToDelete);
			return paymentToDelete;
		} else {
			// PaymentNotFoundException
			return null;
		}

	}

	@Override
	public Payment updatePayment(long paymentId, Payment payment) {
		LOGGER.info("Called updatePayment() method of PaymentService");
		Optional<Payment> searchedPayment = paymentRepository.findById(paymentId);
		if (searchedPayment.isPresent()) {
			return paymentRepository.save(payment);
		} else {
			//PaymentNotFoundException
			return null;
		}

	}

	@Override
	public Payment getPayment(long paymentid) {
		LOGGER.info("Called getPayment() method of PaymentService");
		Optional<Payment> searchedPayment = paymentRepository.findById(paymentid);
		if (searchedPayment.isPresent()) {
			return searchedPayment.get();
		} else {
			//PaymentNotFoundException
			return null;
		}

	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		LOGGER.info("Called getAllPaymentDetails() method of PaymentService");
		return paymentRepository.findAll();
	}
	
}
