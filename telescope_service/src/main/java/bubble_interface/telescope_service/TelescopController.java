package bubble_interface.telescope_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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

}
