package com.hngTask2.identify.service;

import com.hngTask2.identify.data.dto.request.PersonRequest;
import com.hngTask2.identify.data.dto.request.UpdateProfileRequest;
import com.hngTask2.identify.data.dto.response.ApiResponse;
import com.hngTask2.identify.data.model.Person;
import com.hngTask2.identify.data.repository.PersonRepository;
import com.hngTask2.identify.exception.BusinessLogicException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import static com.hngTask2.identify.utility.IdentifyUtilities.MAX_NUMBER_PER_PAGE;

@Service
@AllArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    @Override
    public ApiResponse createPerson(PersonRequest personRequest) {
        Person person = new Person();
        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        person.setAddress(personRequest.getAddress());
        person.setPhoneNumber(personRequest.getPhoneNumber());
        Person savedPerson = personRepository.save(person);
        return getApiResponse(savedPerson);
    }

    private static ApiResponse getApiResponse(Person savedPerson) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setId(savedPerson.getId());
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Person Created Successfully");
        return apiResponse;
    }

    @Override
    public Person getPersonById(Long personId) {
        return personRepository.findById(personId).orElseThrow(
                ()-> new BusinessLogicException(
                        String.format("Person with id %d not found", personId)
                )
        );
    }

    @Override
    public Page<Person> getAllPersons(int pageNumber) {
        int page = pageNumber < 1 ? 0 : pageNumber -1;
        Pageable pageable = PageRequest.of(page, MAX_NUMBER_PER_PAGE);
        return personRepository.findAll(pageable);
    }

    @Override
    public ApiResponse updateProfile(Long id, UpdateProfileRequest request) {
        Person checkUser = personRepository.findBPersonById (id);
        if (checkUser == null) {
            throw new RuntimeException ("User " + id + " not found");
        }
        updateUserMapping(checkUser, request);
        var savedUpdate = personRepository.save (checkUser);
        return getApiResponse (savedUpdate);
    }

    private void updateUserMapping(Person person, UpdateProfileRequest personRequest) {
        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        person.setAddress(personRequest.getAddress());
        person.setPhoneNumber(personRequest.getPhoneNumber());
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);

    }
}
