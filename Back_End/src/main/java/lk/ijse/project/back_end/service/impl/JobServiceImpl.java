package lk.ijse.project.back_end.service.impl;

import lk.ijse.project.back_end.dto.JobDto;
import lk.ijse.project.back_end.entity.Job;
import lk.ijse.project.back_end.repostory.JobRepository;
import lk.ijse.project.back_end.service.JobService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<JobDto> getAllJobs() {
//        return jobRepository.findAll().stream().map(j -> modelMapper.map(j, JobDto.class)).toList();
        List<Job> allJobs = jobRepository.findAll();
        return modelMapper.map(allJobs, new TypeToken<List<JobDto>>() {}.getType());

    }

    @Override
    public void changeJobStatus(String id) {
        jobRepository.updateJobStatus(id);
    }
}
