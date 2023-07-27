//package com.example.core.controller;
//
//import com.example.core.DTOs.ItemOrderDTO;
//import com.example.core.DTOs.ItemsDTO;
//import com.example.core.model.Items;
//import com.example.core.service.ItemOrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("item")
//public class ItemController {
//
//    @Autowired
//    private ItemOrderService itemOrderService;
//
//    @GetMapping("/{clientId}")
//    public ResponseEntity<List<ItemsDTO>> fetchAllOrders(@PathVariable("clientId") Long clientId) {
//        List<ItemsDTO> itemsDTO = itemOrderService.getItemByClientID(clientId);
//
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(itemsDTO);
//    }
//
//     @PostMapping
//     private ResponseEntity<Items> saveItems(@RequestBody ItemOrderDTO itemOrderDTO) {
//        try {
//             itemOrderService.saveItems(itemOrderDTO);
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//         }
//
//         return ResponseEntity.status(HttpStatus.ACCEPTED).build();
//     }
//}
