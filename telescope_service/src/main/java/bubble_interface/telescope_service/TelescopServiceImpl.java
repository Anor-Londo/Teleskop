package bubble_interface.telescope_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TelescopServiceImpl implements TelescopService {

    private TelescopRepository repository;

    @Autowired
    public void setRepository(TelescopRepository repository) {
        this.repository = repository;
    }

    public TelescopRepository getRepository() {
        return repository;
    }


    @Override
    public List<Telescop> findTelescopByCoords(String coords) {

        List<Telescop> telescopsFound = new ArrayList<Telescop>();
        Iterable<Telescop> allTelescops = repository.findAll();
        for (Telescop telescop: allTelescops)
        {
            if (telescop.getCoords().equals(coords))
            {
                telescopsFound.add(telescop);
            }
        }
        return telescopsFound;
    }

    @Override
    public List<Telescop> findTelescopByBeginDate(LocalDateTime date) {

        List<Telescop> telescopsFound = new ArrayList<Telescop>();
        Iterable<Telescop> allTelescops = repository.findAll();
        for (Telescop telescop: allTelescops)
        {
            if (telescop.getTimeBegin().isEqual(date))
            {
                telescopsFound.add(telescop);
            }
        }
        return telescopsFound;
    }

    @Override
    public List<Telescop> findTelescopByEndDate(LocalDateTime date) {

        List<Telescop> telescopsFound = new ArrayList<Telescop>();
        Iterable<Telescop> allTelescops = repository.findAll();
        for (Telescop telescop: allTelescops)
        {
            if (telescop.getTimeEnd().isEqual(date))
            {
                telescopsFound.add(telescop);
            }
        }
        return telescopsFound;
    }

    @Override
    public Telescop saveOrUpdateTelescop(Telescop telescop) {
        return repository.save(telescop);
    }

    @Override
    public void deleteTelescopByIdentifier(Integer id) {
        Telescop telescop = repository.findByid(id);
        repository.delete(telescop);
    }
}
