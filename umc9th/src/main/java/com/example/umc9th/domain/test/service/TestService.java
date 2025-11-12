

@PostMapping("/users")
@ResponseStatus(HttpStatus.CREATED)
public UserResponse createUser(@RequestBody UserRequest request) {
    return userService.create(request);
}