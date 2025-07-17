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
            },
            error: function (xhr, status, error) {
                console.error("Error saving job:", error);
                alert("Failed to save job.");
            }
        });
});
