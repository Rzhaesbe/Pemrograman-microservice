/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zailany.order.service;

import com.zailany.order.entity.Order;
import com.zailany.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author rzhaesbe
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.getReferenceById(id);
    }

    public void insert(Order order) {
        orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Transactional
    public void update(Long orderId, int jumlah, String tanggal, String status, double total) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order tidak ada"));
        if(jumlah > 0 && (order.getJumlah() != jumlah) ){
            order.setJumlah(jumlah);
        }
        if(tanggal!=null && tanggal.length()>0 && !order.getTanggal().equals(tanggal)) {
            order.setTanggal(tanggal);
        }
        if(status!=null && status.length()>0 && !order.getStatus().equals(status)) {
            order.setStatus(tanggal);
        }
        if(jumlah > 0 && order.getTotal() != total) {
            order.setTotal(total);
        }
    }
}
