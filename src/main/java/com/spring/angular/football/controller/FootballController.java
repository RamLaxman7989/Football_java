package com.spring.angular.football.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.angular.football.exception.ResourceNotFoundException;
import com.spring.angular.football.model.FootballPlayer;
import com.spring.angular.football.model.LoginPlayer;
import com.spring.angular.football.repository.FootballRepository;
import com.spring.angular.football.repository.LoginRepository;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class FootballController {
	
	@Autowired
	private FootballRepository footballRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	//get all footballplayers rest api
	@GetMapping("/footballplayer")
	public List<FootballPlayer> getAllFootballPlayers(){
		return footballRepository.findAll();
	}

	//post footballplayer rest api
	@PostMapping("/footballplayer")
	public FootballPlayer createFootballPlayer(@RequestBody FootballPlayer footballplayer) {
		
		return footballRepository.save(footballplayer);
	}
	
	//get footballplayer by id rest api
	@GetMapping("/footballplayer/{id}")
	public ResponseEntity<FootballPlayer> getFootballPlayerById(@PathVariable Long id){
		FootballPlayer footballplayer = footballRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("FootballPlayer not exist with id:" +id));
		
		return ResponseEntity.ok(footballplayer);
	}
	
	//update footballplayer rest api
	@PutMapping("/footballplayer/{id}")
	public ResponseEntity<FootballPlayer> updateFootballPlayerById(@PathVariable Long id, @RequestBody FootballPlayer footballplayerDetails){
		FootballPlayer footballplayer = footballRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("FootballPlayer not exist with id:" +id));
		

		footballplayer.setPlayerName(footballplayerDetails.getPlayerName());
		footballplayer.setPlayerGoals(footballplayerDetails.getPlayerGoals());
		footballplayer.setPlayerRole(footballplayerDetails.getPlayerRole());
		footballplayer.setTeamName(footballplayerDetails.getTeamName());
		
		FootballPlayer updatedFootballPlayer = footballRepository.save(footballplayer);
		return ResponseEntity.ok(updatedFootballPlayer);
	}
	
	// delete footballplayer rest api
	@DeleteMapping("/footballplayer/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteFootballPlayer(@PathVariable Long id){
		FootballPlayer footballplayer = footballRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("FootballPlayer not exist with id:" +id));
		
		footballRepository.delete(footballplayer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/loginpage")
    public  LoginPlayer loginUsers(@RequestBody LoginPlayer loginPlayer) {
        
        String username = loginPlayer.getUsername();
        String password = loginPlayer.getPassword();
        
        LoginPlayer userByusername = loginRepository.findByUsername(username);
        
        boolean status;
        
        
        if(userByusername !=null) {
            if(password.equals(userByusername.getPassword())) {
                status=true;
            }
            else {
                status = false;
            }
        }
        else {
            status = false;
        }
            
            if(status) {
                return userByusername;
            }
            else {
                return null;
            }
            
            
        } 
	
}
