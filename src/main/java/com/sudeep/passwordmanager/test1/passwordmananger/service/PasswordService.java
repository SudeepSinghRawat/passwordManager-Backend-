package com.sudeep.passwordmanager.test1.passwordmananger.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sudeep.passwordmanager.test1.passwordmananger.data.model.Password;
import com.sudeep.passwordmanager.test1.passwordmananger.data.model.PinModel;

@Service
public class PasswordService {
	
	private static List<Password> passwordList = new ArrayList<>();
	
	public boolean validPin(PinModel pin) {
		return pin.getOldPin() == 123456;
	}
	
	public boolean addPassword(Password pass) {
		int id = passwordList.size();
		pass.setId(id);
		passwordList.add(pass);
		System.out.println(passwordList);
		return true;
	}
	
	public List<Password> getAllPassword(){
		return passwordList;
	}

}
