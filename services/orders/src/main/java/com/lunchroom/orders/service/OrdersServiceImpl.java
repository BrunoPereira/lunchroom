package com.lunchroom.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lunchroom.orders.model.CaloriesRequest;
import com.lunchroom.orders.model.CaloriesResponse;
import com.lunchroom.orders.model.Orders;
import com.lunchroom.orders.repository.OrdersRepository;

import java.util.*;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private Environment environment;

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Orders save(Orders order, String employee) {
        long[] mockProductIds = { 1, 3, 2 };
        order.setCalories(calculateCalories(order.getId(), mockProductIds));
        order.setCreated(new Date());
        order.setUpdated(new Date());
        return ordersRepository.save(order);
    }

    @Override
    public List<Orders> findAllByEmployee(String employee) {
        return ordersRepository.findAll();
    }

    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> findById(Long id, String employee) {
        return ordersRepository.findById(id);
    }

    @Override
    public Orders update(Orders order, String employee) {
        Optional<Orders> previousOrder = findById(order.getId(), employee);
        if (previousOrder.isPresent()) {
            order.setCreated(previousOrder.get().getCreated());
        }
        long[] mockProductIds = { 1, 3, 4 };
        order.setCalories(calculateCalories(order.getId(), mockProductIds));
        order.setUpdated(new Date());
        return ordersRepository.save(order);
    }

    @Override
    public void deleteById(Long id, String employee) {
        ordersRepository.deleteById(id);
    }

    private int calculateCalories(long orderId, long[] products) {
        RestTemplate restTemplate = new RestTemplate();
        CaloriesRequest caloriesRequest = new CaloriesRequest();

        caloriesRequest.setOrderId(orderId);
        caloriesRequest.setProductIds(products);
        String auxEndpoint = environment.getProperty("CALORIES_ENDPOINT");
        if (auxEndpoint != null) {
            CaloriesResponse caloriesResponse = restTemplate.postForObject(auxEndpoint, caloriesRequest,
                    CaloriesResponse.class);
            if (caloriesResponse != null && caloriesResponse.getOrderId() == orderId) {
                return caloriesResponse.getCalories();
            }
        }
        return 0;
    }
}