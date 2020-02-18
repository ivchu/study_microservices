package org.nipu.po.order;

import org.nipu.po.order.clients.ProductSpecificationRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final ProductOrderRepository orderRepository;
    private final ProductSpecificationRepository specificationRepository;

    public OrderController(ProductOrderRepository orderRepository, ProductSpecificationRepository specificationRepository) {
        this.orderRepository = orderRepository;
        this.specificationRepository = specificationRepository;
    }

    @PutMapping("/{specificationId}/order")
    public ProductOrder orderProductBySpecificationId(@PathVariable String specificationId) {
        Object product = specificationRepository.existsById(specificationId);
        if (product == null) {
            throw new RuntimeException("There is no product specification with Id: " + specificationId);
        }
        return orderRepository.save(new ProductOrder(null, specificationId, 1L));
    }
}
