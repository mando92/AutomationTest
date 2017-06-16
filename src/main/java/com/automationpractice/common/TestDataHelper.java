package com.automationpractice.common;

import com.automationpractice.utils.Hobby;
import com.automationpractice.utils.Status;

public class TestDataHelper {

	public Person getDataFromExcel(int recordNumber) {
		Person p = new Person();
		try {
			ReadExcel.setExcelFile(
					"../AutomationTest/externalFile/RegistrationPractice.xlsx",
					"RegistrationLog");

			p.setFirstName(ReadExcel.getCellData(recordNumber, 0));
			p.setLastName(ReadExcel.getCellData(recordNumber, 1));
			p.setStatus(ReadExcel.getCellData(recordNumber, 2));
			p.setHobby(ReadExcel.getCellData(recordNumber, 3));
			p.setCountry(ReadExcel.getCellData(recordNumber, 4));
			p.setDateOfBirth(ReadExcel.getCellData(recordNumber, 5));
			p.setPhoneNumber(ReadExcel.getCellData(recordNumber, 6));
			p.setUserName(ReadExcel.getCellData(recordNumber, 7));
			p.setEmail(ReadExcel.getCellData(recordNumber, 8));
			p.setPicProfile(ReadExcel.getCellData(recordNumber, 9));
			p.setDescription(ReadExcel.getCellData(recordNumber, 10));
			p.setPassword(ReadExcel.getCellData(recordNumber, 11));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	public int[] splitDate(String dateOfBirth) {
		
		String[] temp = dateOfBirth.split("/");
		int[] dates = new int[temp.length];
		
		System.out.println(" Length: "+ temp.length);
		
		for(int i=0; i< temp.length; i++)
		{
			System.out.println("Temp: " + temp[i]);
			dates[i] = Integer.parseInt(temp[i]);
		}

		return dates;
	}

	public Status chooseStatus(String name) {
		
		if (name.equals("S")) {
			
			return Status.SINGLE;
			
		} else if (name.equals("D")) {
			
			return Status.DIVORCED;
			
		} else {
			
			return Status.MARRIED;
		}
	}
	
	public Hobby chooseHobby(String name) {
		
		if (name.equals("R")) {
			
			return Hobby.READING;
			
		} else if (name.equals("C")) {
			
			return Hobby.CRICKET;
			
		} else {
			
			return Hobby.DANCE;
		}
	}

}
