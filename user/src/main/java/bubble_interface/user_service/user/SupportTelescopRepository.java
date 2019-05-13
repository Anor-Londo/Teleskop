package bubble_interface.user_service.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportTelescopRepository extends CrudRepository<SupportTelescop, Long> {
}
