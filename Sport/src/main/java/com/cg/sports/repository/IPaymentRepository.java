package com.cg.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sports.entity.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Long>{

}
