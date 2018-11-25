package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.Menager;
import com.duoi.workmgt.domain.Task;
import com.duoi.workmgt.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MenagerRepository extends CrudRepository<Menager, Long> {

    Optional<Menager> findByOrderedTasks(List<Task> orderedTasks);

}