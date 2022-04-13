package com.vti;

import com.vti.entity.Address;
import com.vti.entity.User;
import com.vti.entity.repository.AddressRepository;
import com.vti.entity.repository.UserRepository;

public class App {
    public static void main(String[] args) {
    	
    	// From User, get address info (street)
    	
    	UserRepository userRepo = new UserRepository();
        AddressRepository addressRepo = new AddressRepository();
        
//        User user = userRepo.getById(1);
//        System.out.println(user);
//        System.out.println(user.getUsername());
//        System.out.println(user.getAddress().getStreet());

        Address a1 = new Address();
        a1.setStreet("Phu Do");
        addressRepo.create(a1);

        User u1 = new User();
        u1.setUsername("tn1");
        u1.setAddress(a1);
        userRepo.create(u1);
        
    	// From Address, get user info (username)

//        Address address = addressRepo.getById(1);
//        System.out.println(address.getStreet());
//        System.out.println(address.getUser().getUsername());
    }
}
