package com.Techno.Techno.Service;

import com.Techno.Techno.Model.User;
import com.Techno.Techno.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;   //for connect user repository
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }  //for fetch user list

    @Override
    public User saveUser(User user) {

        this.userRepository.save(user);
        return user;
    }  // for save user details

    @Override
    public ResponseDto getUser(int userId) {

        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        UserDto userDto = mapToUser(user);

        ResponseEntity<ReservationDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8081/" + user.getReservationId(),
                        ReservationDto.class);

        ReservationDto reservationDto = responseEntity.getBody();

        System.out.println(responseEntity.getStatusCode());

        responseDto.setUser(userDto);
        responseDto.setReservation(reservationDto);

        return responseDto;
    }
    @Override
    public User getUserById(int id) {
        Optional< User> optional = userRepository.findById(id);  // reservation details by id
        User user = null;
        if (optional.isPresent()) {        //if reservation present then fetch details
            user = optional.get();
        } else {                            // if not then throw exception
            throw new RuntimeException(" User not found for id :: " + id);
        }
        return user;   // return reservation
    }
    @Override
    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }  // to delete user data by id

    private UserDto mapToUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setEmailId(user.getEmailId());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setGender(user.getGender());
        userDto.setUserStatus(user.getUserStatus());
        userDto.setAddress(user.getAddress());
        return userDto;
    }

}

