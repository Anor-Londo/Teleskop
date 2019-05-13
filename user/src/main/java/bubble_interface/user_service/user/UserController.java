package bubble_interface.user_service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService service;

    @Autowired
    private SupportTelescopRepository supportRepository;

    @RequestMapping(value = "user/telescop/{id}", method = RequestMethod.GET)
    public Optional<SupportTelescop> telescopsId (@PathVariable Long id){
        Optional<SupportTelescop> telescops = supportRepository.findById(id);
        return telescops;
    }
}
