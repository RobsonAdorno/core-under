//package com.example.core.controller;
//
//import com.example.core.model.modelRedundant.Client;
//import com.example.core.model.modelRedundant.OrderTest;
//
//import com.example.core.service.ClientService;
//import com.example.core.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("order")
//public class OrderController {
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private ClientService clientService;
//
//    @GetMapping
//    public ResponseEntity<List<OrderTest>> getAllOrders() {
//        List<OrderTest> orders = orderService.getAllOrders();
//
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orders);
//    }
//
////    @GetMapping("/{clientid}")
////    public ResponseEntity<OrderTest> saveOrder(@PathVariable("clientid") Integer clientId) {
////        Client client = clientService.getClientById(clientId).get();
////
////        OrderTest order = orderService.saveOrder(new OrderTest(client));
////
////        return ResponseEntity.status(HttpStatus.ACCEPTED).body(order);
////    }
//}
