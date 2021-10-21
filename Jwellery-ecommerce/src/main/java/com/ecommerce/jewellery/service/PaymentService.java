package com.ecommerce.jewellery.service;

import com.ecommerce.jewellery.model.Payment;
import com.ecommerce.jewellery.dao.PaymentRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityNotFoundException;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public Payment save(Payment payment){
        return paymentRepository.save(payment);
    }

    public Payment getById(long id){
        return paymentRepository.findById(id).orElseThrow(EntityNotFoundException::new) ;
    }

    public List<Payment> getAll(){
        return paymentRepository.findAll();
    }

    public Payment updatePayment(Long id, Payment updatedPayment){
        Payment existingPayment = paymentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        existingPayment.setPaymentType(updatedPayment.getPaymentType());
        existingPayment.setPaymentStatus(updatedPayment.getPaymentStatus());
        existingPayment.setPaymentDate(updatedPayment.getPaymentDate());

        return paymentRepository.save(existingPayment);
    }

    public String deleteById(long id){
        paymentRepository.deleteById(id);

        return "ID: "+id+" deleted";
    }

    public String deleteAll(){
        paymentRepository.deleteAll();

        return "All Admin deleted";
    }
}
