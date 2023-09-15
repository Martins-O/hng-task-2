package com.hngTask2.identify.controller;

import com.hngTask2.identify.data.dto.request.PersonRequest;
import com.hngTask2.identify.data.dto.request.UpdateProfileRequest;
import com.hngTask2.identify.service.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<?> create(
            @Valid @RequestBody PersonRequest createPersonRequest
            ){
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(createPersonRequest));
    }

    @GetMapping("{user_id}")
    public ResponseEntity<?> getPassengerById(
            @PathVariable Long user_id)
    {
        return ResponseEntity.ok(
                personService.getPersonById(user_id)
        );
    }
    @PutMapping(value = "{user_id}", consumes = {"application/json-patch+json"})
    public ResponseEntity<?> updatePerson(@PathVariable Long user_id, @RequestBody UpdateProfileRequest request) {
        try{
            return ResponseEntity.ok(personService.updateProfile(user_id, request));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @DeleteMapping("{user_id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long user_id){
        personService.deletePerson(user_id);
        return ResponseEntity.ok(
                "Person deleted successfully"
        );
    }

}
