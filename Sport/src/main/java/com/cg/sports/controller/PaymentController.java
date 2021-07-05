package com.cg.sports.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sports.entity.Payment;
import com.cg.sports.service.PaymentService;

import antlr.collections.List;


@RestController
@RequestMapping("/api/payment")

public class PaymentController {
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);
	//Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PaymentService paymentService;
	
	//adding payment to database
	
	  @PostMapping 
	  public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {	
		  LOGGER.info("Called POST mapping addPayment() method");
	  return new ResponseEntity<>(paymentService.addPayment(payment), HttpStatus.CREATED); }
	 
	
	//removing + exception??
	  
	  @DeleteMapping("/{paymentId}")
	  public ResponseEntity<Payment> removePayment(@PathVariable("paymentId") Long id){
		  LOGGER.info("Called DELETE mapping removePayment() method");
	  return new ResponseEntity<Payment>(paymentService.removePayment(id), HttpStatus.OK);
		  
	  }
	  
	//update + exception?
	  
	  @PutMapping
	  public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment){
		  LOGGER.info("Called PUT mapping updatePayment() method");
		  return new ResponseEntity<Payment>(paymentService.updatePayment(payment.getPaymentId(), payment), HttpStatus.ACCEPTED);
  
	  }
	  
	  //Get payment by id
	  
	  @GetMapping("/{paymentId}")
	  public ResponseEntity<Payment> getPayment(@PathVariable("paymentId") Long id) {
		  LOGGER.info("Called GET mapping getPayment() method");
		  return new ResponseEntity<Payment>(paymentService.getPayment(id), HttpStatus.OK);
	  }
	  
	  //Get list
	  
	  @GetMapping
		public ResponseEntity<List> getAllPaymentDetails() {
		  LOGGER.info("Called GET mapping getAllPaymentDetails() method");
		  List allPayments = (List) paymentService.getAllPaymentDetails();
			ResponseEntity<List> entity = new ResponseEntity<List>(allPayments, HttpStatus.OK);
			return entity;
		}
	  }

