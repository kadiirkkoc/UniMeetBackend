package edu.unimeet.controller;

import edu.unimeet.GenericResponse.Response;
import edu.unimeet.business.service.DepartmentService;
import edu.unimeet.business.service.PostService;
import edu.unimeet.business.service.UniDeptService;
import edu.unimeet.business.service.UniversityService;
import edu.unimeet.business.service.UserService;
import edu.unimeet.dto.DepartmentViewDto;
import edu.unimeet.dto.PostCreateDTO;
import edu.unimeet.dto.PostViewDTO;
import edu.unimeet.dto.UniDeptViewDto;
import edu.unimeet.dto.UniViewDto;
import edu.unimeet.dto.UserCreateDTO;
import edu.unimeet.dto.UserUpdateDTO;
import edu.unimeet.dto.UserViewDTO;
import edu.unimeet.entities.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class Controller {

    private final UserService userService;
    private final PostService postService;
    private final UniDeptService uniDeptService;
    private final DepartmentService departmentService;
    private final UniversityService universityService;
    
    @GetMapping("/v1/university/getAll")
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public ResponseEntity<List<UniViewDto>> getUniversity() {
        final List<UniViewDto> unis = universityService.getAll();
        return ResponseEntity.ok(unis);
    }
    
    @GetMapping("/v1/department/getAll")
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public ResponseEntity<List<DepartmentViewDto>> getDepts() {
        final List<DepartmentViewDto> depts = departmentService.getAll();
        return ResponseEntity.ok(depts);
    }
    
    @GetMapping("/v1/unidept/getAll")
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public ResponseEntity<List<UniDeptViewDto>> getUniDepts() {
        final List<UniDeptViewDto> unidepts = uniDeptService.getAll();
        return ResponseEntity.ok(unidepts);
    }
    
    
    @GetMapping("/v1/post/{id}")
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public ResponseEntity<PostViewDTO> getPostById(@PathVariable int id) {

        final PostViewDTO post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/v1/post/getAll")
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public ResponseEntity<List<PostViewDTO>> getPosts() {
        final List<PostViewDTO> posts = postService.getAll();
        return ResponseEntity.ok(posts);
    }
  
    @PostMapping("/v1/createPost")
    public ResponseEntity<?> createPost(@RequestBody PostCreateDTO postCreateDTO) {
    	postService.createPost(postCreateDTO);
        return ResponseEntity.ok(new Response("post created"));
    }
    

    @GetMapping("/v1/user/{id}")
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable int id) {

        final UserViewDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/v1/user/getAll")
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public ResponseEntity<List<UserViewDTO>> getUsers() {
        final List<UserViewDTO> users = userService.getAll();
        return ResponseEntity.ok(users);
    }
  
    @PostMapping("/v1/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new Response("user created"));
    }

    @PutMapping("/v1/updateUser/{id}")
    public ResponseEntity<UserViewDTO> updateUser(@PathVariable("id") int id, @RequestBody UserUpdateDTO userUpdateDTO) {
        UserViewDTO updatedUser = userService.updateUser(id, userUpdateDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/v1/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new Response("user deleted"));
    }


}
