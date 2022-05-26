package dto;

public class Account {
	String id;
	String name;
	int balance;
	
	public Account() {}

	public Account(String id, String name, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void deposit(int money) {
		this.balance += money;
	}
	
	public void withdraw(int money) {
		if(balance > money) {
			this.balance -= money;
		}
	}

	@Override
	public String toString() {
		return "계좌번호 : " + id + ", 이름 : " + name + ", 잔액 : " + balance;
	}
	
	
}
