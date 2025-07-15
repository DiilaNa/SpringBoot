package lk.ijse.project.back_end.service.impl;

import lk.ijse.project.back_end.dto.JobDto;
import lk.ijse.project.back_end.entity.Job;
import lk.ijse.project.back_end.repostory.JobRepository;
import lk.ijse.project.back_end.service.JobService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveJob(JobDto jobDto) {
        jobRepository.save(modelMapper.map(jobDto, Job.class));
    }

    @Override
    public void updateJob(JobDto jobDto) {
      jobRepository.save(modelMapper.map(jobDto, Job.class));
    }
}
