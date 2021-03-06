package Instruments;

import java.io.Serializable;
import java.util.Date;

public class CreditCard implements Serializable{
	private String name;
	private String number;
	private Date dueDate;
	private int segurityCode;
	private float balance;
	
	public CreditCard()
	{
		number = "";
		balance = -1; // el balance es igual -1 para saber si el usuario agrego la tarjeta o no
	}

	public CreditCard(String name, String number, Date dueDate, int segurityCode, float balance) {
		this.name = name;
		this.number = number;
		this.dueDate = dueDate;
		this.segurityCode = segurityCode;
		this.balance = balance;
	}
	
	// GETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getSegurityCode() {
		return segurityCode;
	}

	public void setSegurityCode(int segurityCode) {
		this.segurityCode = segurityCode;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 
	 * @return The formatted credit card number
	 */
	public  String getNumber() {
		Character[] number2 = new Character[number.length()];
		String numberFormated = "";
		
		if(number == "")
		{
			numberFormated = "Ingrese una tarjeta";
		}
		else
		{
			for(int i = 0; i < number.length(); i++)
			{ 
				if(i < 12)
				{
					number2[i] = '*';
				}
				else
				{
					number2[i] = number.charAt(i);
				}
				
				numberFormated += number2[i];
			}
		}
		
		return numberFormated;
	}
	
	public float getBalance() {
		return balance;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}
}




	



























