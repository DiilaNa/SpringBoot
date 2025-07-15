package lk.ijse.project.back_end.service.impl;

import lk.ijse.project.back_end.dto.JobDto;
import lk.ijse.project.back_end.repostory.JobRepository;
import lk.ijse.project.back_end.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public void saveJob(JobDto jobDto) {
        jobRepository.save(jobDto);
    }
}
