package ru.unlegit.orderservice.repository;

import org.springframework.data.repository.ListCrudRepository;
import ru.unlegit.orderservice.model.Order;

public interface OrderRepository extends ListCrudRepository<Order, Integer> {}