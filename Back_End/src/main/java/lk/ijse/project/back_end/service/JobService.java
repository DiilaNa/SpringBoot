package lk.ijse.project.back_end.service;

import lk.ijse.project.back_end.dto.JobDto;
import org.springframework.stereotype.Service;

public interface JobService {
     void saveJob(JobDto jobDto);
     void updateJob(JobDto jobDto);
}
