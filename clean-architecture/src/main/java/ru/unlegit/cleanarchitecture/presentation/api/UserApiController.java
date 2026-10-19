package ru.unlegit.cleanarchitecture.presentation.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.unlegit.cleanarchitecture.application.dto.UserDto;
import ru.unlegit.cleanarchitecture.application.service.UserService;
import ru.unlegit.cleanarchitecture.presentation.dto.UserCreateDto;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserApiController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> listUsers() {
        return userService.listUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUsers(@RequestBody UserCreateDto dto) {
        return userService.createUser(dto.name(), dto.email());
    }

    @GetMapping("/exists/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void existsById(@PathVariable int id) {
        userService.checkExists(id);
    }
}