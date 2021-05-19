package com.hotelapp.controllers;

import java.util.List;

import com.hotelapp.models.JwtRequest;
import com.hotelapp.models.JwtResponse;
import com.hotelapp.service.MyUserDetailsService;
import com.hotelapp.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelapp.models.Hotel;
import com.hotelapp.service.HotelService;

import javax.validation.Valid;

@RestController 
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	@Autowired
	private JwtUtil jwtUtility;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userService;

	Logger logger = LoggerFactory.getLogger(HotelController.class);

	@PostMapping("get-token")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							jwtRequest.getUsername(),
							jwtRequest.getPassword()
					)
			);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		final UserDetails userDetails
				= userService.loadUserByUsername(jwtRequest.getUsername());

		final String token =
				jwtUtility.generateToken(userDetails);

		return  new JwtResponse(token);
	}
	
	@PostMapping("add-hotel")
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel){
		Hotel newHotel = hotelService.addHotel(hotel);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "one hotel added");
		return ResponseEntity.ok().headers(header).body(newHotel);
	}
	@PutMapping("update-hotel")
	public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel){
		hotelService.updateHotel(hotel);
		return ResponseEntity.ok("Updated");
	}
	@GetMapping("hotels/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable int hotelId){
		logger.info("inside getHotelById controller method");
		Hotel hotel = hotelService.getHotelById(hotelId);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "getting one hotel instance");
		return ResponseEntity.ok().headers(header).body(hotel);
	}
	@GetMapping("hello")
	public ResponseEntity<String> hello(){
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "getting one hotel instance");
		return ResponseEntity.ok().headers(header).body("hello");
	}
	@DeleteMapping("hotels/{hotelId}")
	public ResponseEntity<Void> deleteHotel(@PathVariable int hotelId){
		hotelService.deleteHotel(hotelId);
		return ResponseEntity.ok().build();
	}
	@GetMapping("hotels/hotels-by-city/{city}")
	public ResponseEntity<List<Hotel>> getHotelsByCity(@PathVariable("city") String city){
		List<Hotel> hotelList = hotelService.getHotelsByCity(city);
		return ResponseEntity.ok().body(hotelList);
		
	}
	@GetMapping("hotels/hotels-by-menu/{menuName}")
	public ResponseEntity<List<Hotel>> getHotelsByMenu(@PathVariable String menuName){
		List<Hotel> hotelList = hotelService.getHotelsByMenu(menuName);
		return ResponseEntity.ok().body(hotelList);
	}
	@GetMapping("hotels/hotels-by-delivery/{partnerName}")
	public ResponseEntity<List<Hotel>> getHotelsByDelivery(@PathVariable String partnerName){
		List<Hotel> hotelList = hotelService.getHotelsByDelivery(partnerName);
		return ResponseEntity.ok().body(hotelList);
	}
	@GetMapping("hotels/hotels-by-location/{location}")
	public ResponseEntity<List<Hotel>> getHotelsByLocation(@PathVariable String location){
		List<Hotel> hotelList = hotelService.getHotelsByLocation(location);
		return ResponseEntity.ok().body(hotelList);
	}
	@GetMapping("hotels/hotels-by-location/{location}/menuName/{menuName}")
	public ResponseEntity<List<Hotel>> getHotelsByLocationAndMenu(@PathVariable String location,@PathVariable String menuName){
		List<Hotel> hotelList = hotelService.getHotelsByMenu(menuName);
		return ResponseEntity.ok().body(hotelList);
	}
	
}
