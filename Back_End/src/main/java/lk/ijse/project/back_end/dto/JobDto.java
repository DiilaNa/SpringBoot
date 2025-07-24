package lk.ijse.project.back_end.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobDto {
    private Integer id;
    @NotBlank(message = "Job title is mandatory")
    private String jobTitle;
    @NotBlank(message = "company name is mandatory")
    @Pattern(regexp = "^[A-Za-z]+$",message = "company Name should contain alphabet Lettres")
    private String company;
    private String location;
    @NotNull(message = "type is mandatory")
    private String type;
    @Size(min = 10,max = 100,message = "job description must be at least 10 Character long")
    private String jobDescription;
    private String status;
}
