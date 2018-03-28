package com.tantan.l2.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.tantan.l2.models.Resp;
import com.tantan.l2.services.L2Service;
import com.tantan.l2.services.L2ServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/users")
    public Resp greeting(@RequestParam(value="id") Long id,
                         @RequestParam(value="limit") String limit,
                         @RequestParam(value="search") String search,
                         @RequestParam(value="filter", defaultValue = "") String filter,
                         @RequestParam(value="with") String with) {

        L2Service l2Service = new L2ServiceImpl();
        return l2Service.getUsers(id, limit, search, filter, with);
    }
}
