package com.zavada.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zavada.domain.CreateAdvRequest;
import com.zavada.domain.EditUserRequest;
import com.zavada.domain.UserProfileRequest;
import com.zavada.entity.Car;
import com.zavada.entity.UserEntity;
import com.zavada.entity.enumeration.BodyType;
import com.zavada.entity.enumeration.Color;
import com.zavada.entity.enumeration.FuelType;
import com.zavada.mapper.CarMapper;
import com.zavada.mapper.UserMapper;
import com.zavada.service.CarService;
import com.zavada.service.UserService;
import com.zavada.service.utils.CustomFileUtils;

@Controller
@RequestMapping("/user")
@SessionAttributes("editModel")
public class UserController {

	@Autowired UserService userService;
	@Autowired CarService carService;
	
	@GetMapping//("/{firtName}")
	public String showUserProfile(Model model, Principal principal//,@PathVariable("firstName") String firstName
			) throws IOException {
	
		System.out.println("Secured user name: " + principal.getName());
		UserEntity entity = userService.findUserByEmail(principal.getName());	
		

		
		
		if(entity == null) return "redirect:/";
		//if (firstName != entity.getFirstName()) return "redirect:/home";
		UserProfileRequest request = UserMapper.entityToUserProfile(entity);//usermapper v dto
	
		
	//	model.addAttribute("firstName", firstName);
		//model.addAttribute("firstName", request);
		model.addAttribute("userProfile", request);
		model.addAttribute("imageSrc",
				CustomFileUtils.getImage("user_" + entity.getId(), entity.getImagePath()));
		return "user/profile";
	}
	
	@GetMapping("/edit/{userId}")
	public String editUserProfile(
			@PathVariable("userId") int userId,
			Model model, Principal principal) {
		UserEntity entity = userService.findUserByEmail(principal.getName());
		
		if (userId != entity.getId()) return "redirect:/user";
		EditUserRequest request = UserMapper.entityToEditUser(entity);
		model.addAttribute("editModel", request);
		return "user/edit";
	}
	
	@PostMapping("/edit/{userId}")
	public String saveEditedProfile(
			@ModelAttribute("editModel") EditUserRequest request,
			@PathVariable("userId") int userId
			) throws IOException {
		
		if (request.getFile().isEmpty()) {
			return "redirect:/user/edit/" + userId;
		}
		
		UserEntity entity = UserMapper.editRequestToEntity(request);
		System.out.println("pass: " + entity.getPassword());
		System.out.println("pass: " + entity.getRole());
		
		userService.editUser(entity);		
		CustomFileUtils.createFolder("user_" + entity.getId());
		CustomFileUtils.createImage("user_" + entity.getId(), request.getFile());
		
		return "redirect:/user";
	}
	
	// --- Advertisement
	
	@GetMapping("/{userId}/create")
	public String createAdvertisement(
			@PathVariable("userId") int userId, 
			Model model,
			Principal principal) {
		UserEntity entity = userService.findUserByEmail(principal.getName());//передаємо зареганого юзера
		CreateAdvRequest advRequest = new CreateAdvRequest();
		advRequest.setEntity(entity);//встановлюємо зареганого юзера
		
		model.addAttribute("title", "Create Advertisement");//динамічний тайтил
		// model.addAttribute("userId", userId);
		model.addAttribute("advModel", advRequest);
		model.addAttribute("colors", Color.values());
		model.addAttribute("fuelTypes", FuelType.values());
		model.addAttribute("bodyTypes", BodyType.values());
		
		return "user/create-adv";
	}
	
	@PostMapping("/{userId}/create")
	public String createAdvertisementForm(
			@ModelAttribute("advModel") CreateAdvRequest request,
			@PathVariable("userId") int userId 
			) throws IOException {
		UserEntity entity = userService.findUserById(userId);
		Car car = CarMapper.advRequestToCar(request);
		car.setUser(entity);
		
		carService.saveCar(car);
		
		CustomFileUtils.createFolder("car_" + car.getId());
		CustomFileUtils.createImage("car_" + car.getId(), request.getCarImage());
		return "redirect:/user";
	}
	
	@GetMapping("/advs")
	public String showAllAdvertisement(Model model) throws IOException {
		List<Car> cars = carService.findAllCars();
		for(int i = 0; i < cars.size(); i++) {
			String image = cars.get(i).getCarImage();
			cars.get(i).setCarImage(
					CustomFileUtils.getImage(
							"car_" + cars.get(i).getId(), 
							image));
		}
		
		model.addAttribute("carList", cars);
		return "user/advs";
	}
	
}