package rvt;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DefaultRestController {
    @RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUser() {
        User user = new User(1L, "John Doe", "email@mail.com", "password", "Other");

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            return "Error";
        }
    }
}