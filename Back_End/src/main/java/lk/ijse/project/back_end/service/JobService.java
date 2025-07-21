package lk.ijse.project.back_end.service;

import lk.ijse.project.back_end.dto.JobDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobService {
     void saveJob(JobDto jobDto);
     void updateJob(JobDto jobDto);
     List<JobDto> getAllJobs();
     void changeJobStatus(String id);
     List<JobDto> getAllJobsByKeyword(String keyword);

     Page<JobDto> getPagedJobs(Pageable pageable);
}
