package ru.kvs.doctrspring.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kvs.doctrspring.dto.UserDto;
import ru.kvs.doctrspring.model.User;
import ru.kvs.doctrspring.service.UserService;

/**
 * REST controller user connected requestst.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users/")
public class UserRestController {

    private final UserService userService;

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
