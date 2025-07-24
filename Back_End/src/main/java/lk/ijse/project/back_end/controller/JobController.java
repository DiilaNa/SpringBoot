package lk.ijse.project.back_end.controller;

import lk.ijse.project.back_end.dto.JobDto;
import lk.ijse.project.back_end.service.JobService;
import lk.ijse.project.back_end.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/job")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class JobController {

    private final JobService jobService;

    @PostMapping("create")
    public ResponseEntity<ApiResponse> createJob(@RequestBody JobDto jobDto) {
            jobService.saveJob(jobDto);
            return ResponseEntity.ok(
                    new ApiResponse(
                            200,
                            "success",
                            "Saved successfully"
                    )
            );
    }

    @PutMapping("update")
    public ResponseEntity<ApiResponse> updateJob(@RequestBody JobDto jobDto) {
        jobService.updateJob(jobDto);
        return ResponseEntity.ok(
                new ApiResponse(
                        200,
                        "success",
                        "Updated successfully"
                )
        );

    }

    @GetMapping("get")
    public ResponseEntity<ApiResponse> getAllJobs() {
        List<JobDto> jobLists = jobService.getAllJobs();
        return ResponseEntity.ok(
                new ApiResponse(
                        200,
                        "success",
                        jobLists
                )
        );
    }

    @PatchMapping("status/{id}") /*change one or two details of dto / not full dto */
    public ResponseEntity<ApiResponse> changeJob(@PathVariable String id) {

        jobService.changeJobStatus(id);
        return ResponseEntity.ok(
                new ApiResponse(
                        200,
                        "success",
                        "Id Changed successfully"
                )
        );
    }

    @GetMapping("search/{keyword}")
    public ResponseEntity<ApiResponse> searchJob(@PathVariable("keyword") String keyword) {

        List<JobDto> jobLists = jobService.getAllJobsByKeyword(keyword);
        return ResponseEntity.ok(
                new ApiResponse(
                        200,
                        "Searched successfully",
                        jobLists
                )
        );

    }
    @GetMapping("get-paged")
    public ResponseEntity<ApiResponse> getPagedJobs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "7") int size) {
        Page<JobDto> jobLists = jobService.getPagedJobs(PageRequest.of(page, size));
        return ResponseEntity.ok(
                new ApiResponse(
                        200,
                        "success",
                        jobLists
                )
        );

    }

}
