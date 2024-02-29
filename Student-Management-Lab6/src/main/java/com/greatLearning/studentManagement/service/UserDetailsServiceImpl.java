package com.greatLearning.studentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatLearning.studentManagement.entity.User;
import com.greatLearning.studentManagement.repository.UserRepository;
import com.greatLearning.studentManagement.security.MyUserDetails;


//for retrieving a username, a password, and other attributes for authenticating
public class UserDetailsServiceImpl implements UserDetailsService {

	   @Autowired
	    private UserRepository userRepository;
	     
	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	        User user = userRepository.getUserByUsername(username);
	         
	        if (user == null) {
	            throw new UsernameNotFoundException("This user does not exist");
	        }
	         
	        return new MyUserDetails(user);
	    }

}
