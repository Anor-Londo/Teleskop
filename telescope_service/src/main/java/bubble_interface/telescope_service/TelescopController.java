package bubble_interface.telescope_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TelescopController {

    @Autowired
    private TelescopRepository repository;

    @Autowired
    private TelescopService service;

    @RequestMapping(value = "telescop", method = RequestMethod.GET)
    public Iterable<Telescop> retrieveAllTelescops(){
        return repository.findAll();
    }


    @RequestMapping(value = "telescop/{id}", method = RequestMethod.GET)
    public Telescop retrieveTelescopById(@PathVariable Integer id){
        return repository.findByid(id);
    }

    @RequestMapping(value = "telescop/coords/{coords}", method = RequestMethod.GET)
    public List<Telescop> retrieveTelescopsByCoords(@PathVariable String coords){
        List<Telescop> telescops = service.findTelescopByCoords(coords);
        return telescops;
    }

    @RequestMapping(value = "telescop/timeBegin", method = RequestMethod.GET)
    public List<Telescop> retrieveTelescopsByBeginDate(@RequestParam(value = "timeBegin")
                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                   LocalDateTime time){
        List<Telescop> telescops = service.findTelescopByBeginDate(time);
        return telescops;
    }

    @RequestMapping(value = "telescop/timeEnd", method = RequestMethod.GET)
    public List<Telescop> retrieveTelescopsByEndDate(@RequestParam(value = "timeEnd")
                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                 LocalDateTime time){
        List<Telescop> telescops = service.findTelescopByEndDate(time);
        return telescops;
    }


    @PostMapping("telescop/create")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Telescop telescop, BindingResult result){
        if (result.hasErrors()){
            return new ResponseEntity<String>("Invalid object", HttpStatus.BAD_REQUEST);
        }
        Telescop telescop1 = service.saveOrUpdateTelescop(telescop);
        return new ResponseEntity<Telescop>(telescop, HttpStatus.CREATED);
    }

    @DeleteMapping("telescop/delete/{telescopId}")
    public ResponseEntity<?> deleteProject(@PathVariable Integer telescopId){
        service.deleteTelescopByIdentifier(telescopId);

        return new ResponseEntity<String>("Telescop with ID: '" + telescopId
                + "' was deleted", HttpStatus.OK);
    }


}
