package bubble_interface.telescope_service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import net.bytebuddy.agent.builder.AgentBuilder;

public interface TelescopService {
    List<Telescop> findTelescopByCoords(String coords);
    List<Telescop> findTelescopByBeginDate(LocalDateTime date);
    List<Telescop> findTelescopByEndDate(LocalDateTime date);
    Telescop saveOrUpdateTelescop(Telescop telescop);
    void deleteTelescopByIdentifier(Integer id);
}
