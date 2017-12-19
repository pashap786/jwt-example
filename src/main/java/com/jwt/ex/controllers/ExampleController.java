package com.jwt.ex.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.jwt.ex.user.Example;

@RestController
@RequestMapping(value = "/contacts/")
public class ExampleController {
	
    private static final List<Example> examples = Lists.newArrayList(
            new Example("x", "14242434"),
            new Example("p", "293482384")
    );

    @GetMapping
    @PreAuthorize("hasAuthority('read:examples')")
    public List<Example> getContacts() {
        return examples;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('add:examples')")
    public void addContact(@RequestBody Example contact) {
    	examples.add(contact);
    }
}