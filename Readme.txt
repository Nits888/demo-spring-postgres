import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional
    public List<ProjectRequestResponseDto> updateMultipleProjectDetails(List<ProjectRequestResponseDto> requestDtos) {
        List<ProjectRequestResponseDto> responses = new ArrayList<>();

        for (ProjectRequestResponseDto requestDto : requestDtos) {
            var response = updateProjectDetails(requestDto);
            responses.add(response);
        }

        return responses;
    }

    public ProjectRequestResponseDto updateProjectDetails(ProjectRequestResponseDto requestDto) {
        // Logic to update a single project detail
        // This method should throw an exception if an update fails
        // e.g., validation failure, or some other business logic failure
        return null; // replace with actual implementation
    }
}
