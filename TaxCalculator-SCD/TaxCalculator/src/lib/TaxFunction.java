package lib;

public class TaxFunction {

	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		int tax = 0;
		int taxFreeIncome = calculateTaxFreeIncome(isMarried, numberOfChildren);
		if (numberOfMonthWorking > 12) {
			System.err.println("Lebih dari 12 bulan bekerja dalam setahun");
		}
		tax = calculateTaxAmount(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible, taxFreeIncome);
		return (tax < 0) ? 0 : tax;
	}
	
	private static int calculateTaxAmount(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, int taxFreeIncome) {
		return (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - taxFreeIncome));
	}
	
	private static int calculateTaxFreeIncome(boolean isMarried, int numberOfChildren) {
		int taxFreeIncome = 54000000;
		if (isMarried) {
			taxFreeIncome += 4500000;
		}
		taxFreeIncome += Math.min(numberOfChildren, 3) * 1500000;
		return taxFreeIncome;
	}
	
	
}
