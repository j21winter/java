package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
	// TO DO: Constructor that takes an IDcopy
	public Physician(Integer id) {
		super.id = id;
	}
	
    // TO DO: Implement HIPAACompliantUser!
	public boolean assignPin (int pin) {
		String stringPin = Integer.toString(pin);
		if(stringPin.length() != 4) {
			return false;
		}
		for(int i = 0; i < stringPin.length(); i++) {
			if (!Character.isDigit(stringPin.charAt(i))) {
				return false;
			}
		}
		super.setPin(pin);;
		return true;
	}
	
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.id == confirmedAuthID) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	// TO DO: Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
	
}
