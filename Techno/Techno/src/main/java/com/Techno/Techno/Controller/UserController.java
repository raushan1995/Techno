package com.Techno.Techno.Controller;

import com.Techno.Techno.Model.User;
import com.Techno.Techno.Repository.AddressRepository;
import com.Techno.Techno.Repository.UserRepository;
import com.Techno.Techno.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserRepository userRepository;  // for connection to repository
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserService userService;


// fetching all user data
 //   @GetMapping("/")
 //   public List<User> list(){
  //      return userRepository.findAll();
  //  }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "index";        //after fetch details page will redirect to index page
    }

//fetching user data by id
 //   @GetMapping("{id}")
   // public ResponseEntity<ResponseDto> getUser(@PathVariable("id") int id){
   //     ResponseDto responseDto = userService.getUser(id);
    //    return ResponseEntity.ok(responseDto);
 //   }
    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";     //
    }
//storing user data
  //  @PostMapping
 //   public ResponseEntity<User> saveUser(@RequestBody User user){
  //      User savedUser = userService.saveUser(user);
  //      return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
  //  }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        // save user to database
        userService.saveUser(user);

        return "redirect:/";     // after fill user details and submit , page will redirect to index page
    }

//delete user data by id

    @GetMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable(value = "id") int id) {

        // call delete user method
        this.userService.deleteUserById(id);
        return "redirect:/"; // after delete page will be on index page
    }


//update user data by id
  //  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  //  public User update(@PathVariable int id, @RequestBody User user){
   //     User existingUser = userRepository.getOne(id);
   //     BeanUtils.copyProperties(user,existingUser,"address_id");
   //     return userRepository.saveAndFlush(existingUser);
   // }
@GetMapping("/showFormForUpdate/{id}")
public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

    // get user from the service
   User user = userService.getUserById(id);

    // set user as a model attribute to pre-populate the form
    model.addAttribute("user", user);
    return "update_user";   // after update the details page will redirect to index page
}

}
