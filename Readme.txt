@PatchMapping("/projects")
public ResponseEntity<List<ProjectRequestResponseDto>> updateMultipleProjectDetails(@RequestBody List<ProjectRequestResponseDto> requestDtos) {
    List<ProjectRequestResponseDto> responses = new ArrayList<>();
    for (ProjectRequestResponseDto requestDto : requestDtos) {
        var response = service.updateProjectDetails(requestDto);
        responses.add(response);
    }
    return new ResponseEntity<>(responses, HttpStatus.OK);
}
