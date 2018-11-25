package repositroy;

import com.duoi.workmgt.domain.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DayRepository extends JpaRepository<Day,Long> {

    Optional<Day> findOneById(Long id);

    Optional<Day> findOneByDate(LocalDate date);

    void deleteOneById(Long id);

    void deleteByDate(LocalDate date);

    void deleteAll();


}
