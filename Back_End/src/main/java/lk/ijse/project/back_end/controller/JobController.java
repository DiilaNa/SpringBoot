package lk.ijse.project.back_end.controller;

import lk.ijse.project.back_end.dto.JobDto;
import lk.ijse.project.back_end.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/job")
@RestController
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping("create")
    public void createJob(@RequestBody JobDto jobDto) {
        jobService.saveJob(jobDto);
    }

    @PutMapping("update")
    public void updateJob(@RequestBody JobDto jobDto) {
        jobService.updateJob(jobDto);
    }

    @GetMapping("get")
    public List<JobDto> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PatchMapping("status/{id}") /*change one or two details of dto / not full dto */
    public void changeJob(@PathVariable String id) {
        jobService.changeJobStatus(id);
    }
}
