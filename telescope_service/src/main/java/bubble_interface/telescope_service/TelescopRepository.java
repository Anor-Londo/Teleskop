package bubble_interface.telescope_service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelescopRepository extends CrudRepository<Telescop, Integer> {
    Telescop findByid(Integer Id);
}
