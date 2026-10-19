package ru.unlegit.orderservice.mapper;

import org.mapstruct.Mapper;
import ru.unlegit.orderservice.dto.OrderDto;
import ru.unlegit.orderservice.model.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto modelToDto(Order order);

    List<OrderDto> modelToDto(List<Order> models);
}