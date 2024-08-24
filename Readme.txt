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


@PatchMapping("/projects")
public ResponseEntity<List<ProjectRequestResponseDto>> updateMultipleProjectDetails(@RequestBody List<ProjectRequestResponseDto> requestDtos) {
    List<ProjectRequestResponseDto> responses = new ArrayList<>();
    for (ProjectRequestResponseDto requestDto : requestDtos) {
        var response = service.updateProjectDetails(requestDto);
        responses.add(response);
    }
    return new ResponseEntity<>(responses, HttpStatus.OK);
}
