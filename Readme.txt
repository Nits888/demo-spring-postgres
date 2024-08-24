public List<ProjectRequestResponseDto> getAllProjectDetails() {
    var allProjectDetails = projectRepository.findAll();
    return allProjectDetails.stream()
                            .map(this::buildProjectResponse)
                            .collect(Collectors.toList());
}

@GetMapping("/projects")
public ResponseEntity<List<ProjectRequestResponseDto>> getAllProjectDetails() {
    var allDetails = service.getAllProjectDetails();
    if (allDetails.isEmpty()) {
        throw new ResourceNotFoundException("No project details found");
    }
    return new ResponseEntity<>(allDetails, HttpStatus.OK);
}
