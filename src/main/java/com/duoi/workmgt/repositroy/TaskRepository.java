package repositroy;

import com.duoi.workmgt.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    Optional<Task> findByTaskId(Long id);

    Optional<Task> findByName(String name);

    List<Task> findAllByEndOfTask(LocalTime endOfTask);

    List<Task> findAllByBeginningOfTask(LocalTime beginOfTask);

    List<Task>  findAllByTaskDay(Day day);

    List<Task> findAllByDate(LocalDate date);

    List<Task> findAllByMenager(Menager menager);

    List<Task> findAllByEmployees(List<Employee> employees);

    void deleteAllByTaskDay(Day day);
}
