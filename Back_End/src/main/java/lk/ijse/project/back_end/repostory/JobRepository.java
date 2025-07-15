package lk.ijse.project.back_end.repostory;

import lk.ijse.project.back_end.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Integer> {
}
