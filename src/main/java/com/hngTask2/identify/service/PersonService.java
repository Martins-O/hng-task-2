package com.hngTask2.identify.service;

import com.github.fge.jsonpatch.JsonPatch;
import com.hngTask2.identify.data.dto.request.PersonRequest;
import com.hngTask2.identify.data.dto.request.UpdateProfileRequest;
import com.hngTask2.identify.data.dto.response.ApiResponse;
import com.hngTask2.identify.data.model.Person;
import org.springframework.data.domain.Page;

public interface PersonService {
    ApiResponse createPerson(PersonRequest personRequest);
    Person getPersonById(Long personId);
    Page<Person>getAllPersons(int pageNumber);

    ApiResponse updateProfile(Long id, UpdateProfileRequest request);

    void deletePerson(Long personId);


}
