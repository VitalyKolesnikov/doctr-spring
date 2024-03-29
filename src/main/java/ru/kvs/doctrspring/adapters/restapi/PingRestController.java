package ru.kvs.doctrspring.adapters.restapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/ping/")
public class PingRestController {

    @GetMapping
    public ResponseEntity<String> ping() {
        log.info("Ping endpoint triggered");
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
