package lk.ijse.project.back_end.repostory;

import jakarta.transaction.Transactional;
import lk.ijse.project.back_end.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job,Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE job SET status='DEACTIVATE' WHERE id=?",nativeQuery = true)
    void updateJobStatus(String id);

    List<Job> findJobByJobTitleContainingIgnoreCase(String jobTitle);
}
