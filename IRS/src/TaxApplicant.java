
public class TaxApplicant {
	private double taxableIncome;
	private int maritalStatus;
	
	public TaxApplicant(double taxableIncome, int maritalStatus) {
		this.taxableIncome = taxableIncome;
		this.maritalStatus = maritalStatus;
	}
	
	public double calculateTaxesOwed() {
		double result = 0;
		if(maritalStatus == 1) {
			if(taxableIncome <= 27050 && taxableIncome > 0) {
				result = 0.15*(taxableIncome-0);
			}
			else if(taxableIncome <= 65550 && taxableIncome > 27050) {
				result = 4057.50 + 0.275*(taxableIncome-27050);
			}
			else if(taxableIncome <= 136750 && taxableIncome > 65550) {
				result = 14645.00 + 0.305*(taxableIncome-65550);
			}
			else if(taxableIncome <= 297350 && taxableIncome > 136750) {
				result = 36361.00 + 0.355*(taxableIncome-136750);
			}
			else if(taxableIncome > 297350) {
				result = 93374.00 + 0.391*(taxableIncome-297350);
			}
		}
		else if(maritalStatus == 2) {
			if(taxableIncome <= 45200 && taxableIncome > 0) {
				result = 0.15*(taxableIncome-0);
			}
			else if(taxableIncome <= 109250 && taxableIncome > 45200) {
				result = 6780.00 + 0.275*(taxableIncome-45200);
			}
			else if(taxableIncome <= 166500 &&  taxableIncome > 109250) {
				result = 24393.75 + 0.305*(taxableIncome-109250);
			}
			else if(taxableIncome <= 297350 && taxableIncome > 166500) {
				result = 41855.00 + 0.355*(taxableIncome-166500);
			}
			else if(taxableIncome > 297350) {
				result = 88306.00 + 0.391*(taxableIncome-297350);
			}
		}
		return result;
	}


}
