package banking;

public class Loan {

	private double _taux;
	private int _amount;
	private int _time;

	public Loan(double taux, int amount, int time) {
		_taux = taux;
		_amount = amount;
		_time = time;
	}

	public double getTaux() {
		return _taux;
	}

	public int getAmount() {
		return _amount;
	}

	public int getTime() {
		return _time;
	}
}
