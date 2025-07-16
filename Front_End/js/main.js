$("#saveJobBtn").on("click", function () {

        const jobData = {
            title: $("#jobTitle").val(),
            company: $("#companyName").val(),
            location: $("#jobLocation").val(),
            type: $("#jobType").val(),
            description: $("#jobDescription").val(),
            status: $("#jobStatus").val()

        };
        console.log(jobData);
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
