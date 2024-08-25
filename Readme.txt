@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional // This controls the transaction for the entire batch
    public List<ProjectRequestResponseDto> updateMultipleProjectDetails(List<ProjectRequestResponseDto> requestDtos) {
        List<ProjectRequestResponseDto> responses = new ArrayList<>();

        for (ProjectRequestResponseDto requestDto : requestDtos) {
            var response = updateProjectDetails(requestDto);
            responses.add(response);
        }

        return responses;
    }

    @Transactional // This controls the transaction for a single record
    public ProjectRequestResponseDto updateProjectDetails(ProjectRequestResponseDto requestDto) {
        // Logic to update a single project detail
        // This will participate in the transaction controlled by the outer method
        return null; // replace with actual implementation
    }
}

import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PatchMapping("/projects")
    public ResponseEntity<List<ProjectRequestResponseDto>> updateMultipleProjectDetails(@RequestBody List<ProjectRequestResponseDto> requestDtos) {
        List<ProjectRequestResponseDto> responses = service.updateMultipleProjectDetails(requestDtos);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
