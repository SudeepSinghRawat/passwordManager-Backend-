package com.sudeep.passwordmanager.test1.passwordmananger.data.model;

public class PinModel {
	private int oldPin;
	private int newpin;
	private int confirmPin;

//	public PinModel() {
//		super();
//		System.out.println("in empyt");
//	}

	public PinModel(int defaultPin, int pin, int conformPin) {
		System.out.println("in req body");
		
		this.oldPin = defaultPin;
		this.newpin = pin;
		this.confirmPin = conformPin;
	}

	public int getOldPin() {
		return oldPin;
	}

	public void setOldPin(int oldPin) {
		this.oldPin = oldPin;
	}

	public int getNewpin() {
		return newpin;
	}

	public void setNewpin(int newpin) {
		this.newpin = newpin;
	}

	public int getConfirmPin() {
		return confirmPin;
	}

	public void setConfirmPin(int confirmPin) {
		this.confirmPin = confirmPin;
	}

	@Override
	public String toString() {
		return "PinModel [oldPin=" + oldPin + ", newpin=" + newpin + ", confirmPin=" + confirmPin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + confirmPin;
		result = prime * result + newpin;
		result = prime * result + oldPin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PinModel other = (PinModel) obj;
		if (confirmPin != other.confirmPin)
			return false;
		if (newpin != other.newpin)
			return false;
		if (oldPin != other.oldPin)
			return false;
		return true;
	}

	
	

}
