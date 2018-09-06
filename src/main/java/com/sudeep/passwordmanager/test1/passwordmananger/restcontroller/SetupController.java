package com.sudeep.passwordmanager.test1.passwordmananger.restcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudeep.passwordmanager.test1.passwordmananger.data.model.Password;
import com.sudeep.passwordmanager.test1.passwordmananger.data.model.PasswordGenraterHelper;
import com.sudeep.passwordmanager.test1.passwordmananger.data.model.PinModel;
import com.sudeep.passwordmanager.test1.passwordmananger.response.MyResponse;
import com.sudeep.passwordmanager.test1.passwordmananger.service.PasswordService;

@RestController
@RequestMapping(UrlendPoint.SETUP)
public class SetupController {
	@Autowired
	PasswordService passwordService;
	
	@RequestMapping(path="" , method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PinModel> getPin(){
		
        return  new ResponseEntity<PinModel>(new PinModel(15,12,15), HttpStatus.OK);

    }
	
	@RequestMapping(path="" , method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	public ResponseEntity<MyResponse> validatePin(@RequestBody PinModel pin) {
		System.out.println(pin.toString());
		boolean status =  passwordService.validPin(pin);
		if(status == false) {
			return new ResponseEntity<MyResponse>(new MyResponse(status, "DefaultPinError"), HttpStatus.OK);
		}
		if(pin.getConfirmPin() != pin.getNewpin()) {
			return new ResponseEntity<MyResponse>(new MyResponse(false, "PinDontMatch"), HttpStatus.OK);
		}
		return new ResponseEntity<MyResponse>(new MyResponse(status, "Its return posstive"), HttpStatus.OK);
	}
	
	@RequestMapping(path="/passwordHelp" , method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	public ResponseEntity<MyResponse> savePasswordGenrateHelper(@RequestBody PasswordGenraterHelper help) {
		
		System.out.println(help);
		
		return new ResponseEntity<MyResponse>(new MyResponse(true, "Its return posstive"), HttpStatus.OK);
	}
	
	@RequestMapping(path="/savePassword" , method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<MyResponse> savePassword(@RequestBody Password  pass) {
		
		passwordService.addPassword(pass);
		return new ResponseEntity<MyResponse>(new MyResponse(true, "Its return posstive"), HttpStatus.OK);
	}
	
	@RequestMapping(path="/getAllPassword" , method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Password>> getAllPassword(){
		return new ResponseEntity<List<Password>>(passwordService.getAllPassword(), HttpStatus.OK);
	}
	
}
