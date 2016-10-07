package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Account.Account;
import Exception.InsufficientFundsException;

public class CheckingAccountTest {

	Account c;
	
	@Before
	public void setUp() throws Exception {
		c = new Account(1122,20000,0.045);
		c.withdraw(2500);
		c.deposit(3000);
		System.out.printf("The Balance is $%,.2f ", c.getBalance());
		System.out.println("The monthly interest is " + (c.getMonthlyInterestRate() * 100) + "%");
		System.out.println("The date the account was created was on " + c.getDateCreated());
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	@Test(expected=InsufficientFundsException.class)
	public final void testWithdraw() throws InsufficientFundsException {
		c.deposit(500.00);
		assertEquals("$400 Expected, actual is $500",(long)c.getBalance(),(long)500.00);
        c.withdraw(900);
		
	}

	@Test
	public final void testDeposit() {
		int x = 0;
		
		while (x < 20) {
			c.deposit(1000000000);
		}
	}


	@Test
	public void testGetID() {
		assertTrue(c.getID() == 1122);
		assertFalse(c.getID() == 1342);
	}

	@Test
	public void testGetBalance() {
		assertTrue(c.getBalance() == 20500);
		assertFalse(c.getBalance() == 14379);
	}

}
