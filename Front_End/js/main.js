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
$(document).ready(function () {
    loadJobs();
});

function loadJobs() {
    $.ajax({
        url: "http://localhost:8080/api/v1/job/get", // Adjust if your GET endpoint is different
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