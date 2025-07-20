$(document).ready(function () {
    loadJobs();

});

/*----------------------Edit Button -------------------------*/
$(document).on("click", ".edit-btn", function () {
    const jobId = $(this).data("id");

    $.ajax({
        url: `http://localhost:8080/api/v1/job/get`, // get all jobs
        type: "GET",
        success: function (jobs) {
            const job = jobs.find(j => j.id == jobId); // find the one you need

            if (!job) {
                alert("Job not found.");
                return;
            }

            $("#editJobId").val(job.id);
            $("#editJobTitle").val(job.jobTitle);
            $("#editCompanyName").val(job.company);
            $("#editJobLocation").val(job.location);
            $("#editJobType").val(job.type);
            $("#editJobDescription").val(job.jobDescription);
            $("#editJobStatus").val(job.status || "");

            $("#editJobModal").modal("show");
        },
        error: function () {
            alert("Failed to load jobs.");
        }
    });
});

/*-----------------Load Data to the Table---------------------*/
function loadJobs() {
    $.ajax({
        url: "http://localhost:8080/api/v1/job/get",
        type: "GET",
        success: function (jobs) {
            $("#jobsTableBody").empty();

            jobs.forEach((job, index) => {
                $("#jobsTableBody").append(`
                    <tr>
                        <td>${index + 1}</td>
                        <td>${job.jobTitle}</td>
                        <td>${job.company}</td>
                        <td>${job.location}</td>
                        <td>${job.type}</td>
                        <td>${job.status}</td>
                        <td>
                            <button class="btn btn-sm btn-warning edit-btn" data-id="${job.id}">Edit</button>
                             <button class="btn btn-sm btn-info status-btn" data-id="${job.id}">Change Status</button>
                        </td>
                    </tr>
                `);
            });
        },
        error: function () {
            alert("Failed to load jobs.");
        }
    });
}

$(document).on("click", ".status-btn", function () {
    const jobId = $(this).data("id");

    $.ajax({
        url: `http://localhost:8080/api/v1/job/status/${jobId}`,
        type: "PATCH",
        success: function (jobs) {
           alert("Changed Successfully")
            loadJobs();
        },
        error: function () {
            alert("Failed to load jobs.");
        }
    });
});

/*---------------Save Data--------------------*/
$("#saveJobBtn").on("click", function () {

        const jobData = {
            jobTitle: $("#jobTitle").val(),
            company: $("#companyName").val(),
            location: $("#jobLocation").val(),
            type: $("#jobType").val(),
            jobDescription: $("#jobDescription").val(),
            status: $("#jobStatus").val()

        };

        if(jobData.type === null || jobData.title === null || jobData.company === null || jobData.location === null ||  jobData.description === null || jobData.status === null ){
            alert("Job saved failed")
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/v1/job/create",
            data: JSON.stringify(jobData),
            contentType: "application/json",
            success: function (response) {
                alert("Job saved successfully!");
                loadJobs();
            },
            error: function (xhr, status, error) {
                console.error("Error saving job:", error);
                alert("Failed to save job.");
            }
        });
});

/*----------------Update Data------------------------*/
$("#updateJobBtn").on("click", function () {
    const updatedJob = {
        id: $("#editJobId").val(),
        jobTitle: $("#editJobTitle").val(),
        company: $("#editCompanyName").val(),
        location: $("#editJobLocation").val(),
        type: $("#editJobType").val(),
        jobDescription: $("#editJobDescription").val(),
        status: $("#editJobStatus").val()
    };

    if (!updatedJob.id || !updatedJob.jobTitle || !updatedJob.company || !updatedJob.location || !updatedJob.type || !updatedJob.jobDescription || !updatedJob.status) {
        alert("All fields are required for update.");
        return;
    }

    $.ajax({
        url: `http://localhost:8080/api/v1/job/update`,
        type: "PUT",
        data: JSON.stringify(updatedJob),
        contentType: "application/json",
        success: function () {
            alert("Job updated successfully!");
            $("#editJobModal").modal("hide");
            loadJobs();
        },
        error: function () {
            alert("Failed to update job.");
        }
    });
});
