package com.example.core.service;

import com.example.core.DTOs.ItemOrderDTO;
import com.example.core.DTOs.ItemsDTO;
import com.example.core.model.Items;
import com.example.core.model.modelRedundant.OrderTest;
import com.example.core.model.modelRedundant.Product;
import com.example.core.repository.IItemOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemOrderService {

    @Autowired
    private IItemOrderRepository iItemOrderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    public Items saveItemOrder(Items items) {
        return iItemOrderRepository.save(items);
    }

    public void saveItems(ItemOrderDTO itens) throws Exception {
        Long idOrder = itens.idOrder;

        itens.items.forEach((map) -> {
           int quantity = map.quantity;
           String description = map.description;
           Product product = getProduct(description);
           OrderTest order = getOrderById(idOrder);

           saveItemOrder(new Items(quantity, product, order));
        });
    }

    public List<ItemsDTO> getItemByClientID(Long id) {
        List map = iItemOrderRepository.getItemForUserByDate(id);
        List<ItemsDTO> list = new ArrayList<>();

        map.forEach((itens) -> {
            int quantity = (Integer) ((Object[]) itens)[0];
            Long productId = ((BigInteger) ((Object[])itens)[1]).longValue();

            Product product = productService.getProductById(productId);

            list.add(new ItemsDTO(product.getDescription(), quantity));
        });

        return list;
    }

    private Product getProduct(String description) {
        Long idProduct = productService.getProductIdByName(description);

        return new Product(idProduct, description);
    }

    private OrderTest getOrderById(Long orderId) {
        return orderService.getOrderById(orderId);
    }

    private Long convertStringToLong(String id) throws Exception {
        if (id != null || !id.isEmpty() || !id.isBlank()) {
            return Long.parseLong(id);
        }
        throw new Exception("Não foi possível converter String para Long");
    }

    private int convertStringToInt(String id) throws Exception {
        if (id != null || !id.isEmpty() || !id.isBlank()) {
            return Integer.parseInt(id);
        }
        throw new Exception("Não foi possível converter String para int");
    }
}
