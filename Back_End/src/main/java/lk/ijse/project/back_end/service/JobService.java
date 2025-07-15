package lk.ijse.project.back_end.service;

import lk.ijse.project.back_end.dto.JobDto;

import java.util.List;

public interface JobService {
     void saveJob(JobDto jobDto);
     void updateJob(JobDto jobDto);
     List<JobDto> getAllJobs();

     void changeJobStatus(String id);
}
