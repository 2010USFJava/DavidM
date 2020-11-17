package com.project0part2.testing;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.project0part2.beans.Account;

public class ActionsTest {
	@BeforeClass
	public static void start() {
		System.out.println("Class loading");
	}
	@Before
	public void beforeTest() {
		System.out.println("Test loading");
	}
	@Test
	public void testDeposit( ) {
		Account a = new Account(22, "Checking", 24, 400);
		double depositAmt = 200;
		double newBalance = depositAmt + a.getBalance();
		a.setBalance(newBalance);
		double delta = 0;
		double expected = 600;
		double actual = newBalance;
		assertEquals(expected, actual ,delta);
	}
	@Test
	public void testOverDraft() {
		Account a = new Account(22, "Checking", 24, 400);
		double withdraw = 600;
		double newBalance;
		if (withdraw > a.getBalance() || withdraw < 0) {
			System.out.println("Not a valid amount");
		} else {
			newBalance = a.getBalance() - withdraw;
			a.setBalance(newBalance);
		}
		double delta = 0;
		double expected = 400;
		double actual = a.getBalance();
		assertEquals(expected, actual, delta);
		System.out.println(a.getBalance());
	}
	@Test
	public void testWithdraw() {
		Account a = new Account(22, "Checking", 24, 400);
		double withdraw = 200;
		double newBalance;
		if (withdraw > a.getBalance() || withdraw < 0) {
			//System.out.println("Not a valid amount");
		} else {
			newBalance = a.getBalance() - withdraw;
			a.setBalance(newBalance);
		}
		double delta = 0;
		double expected = 200;
		double actual = a.getBalance();
		assertEquals(expected, actual, delta);
		System.out.println(a.getBalance());
	}
	@Test
	public void testIterator() {
		Account a = new Account(22, "Checking", 24, 400);
		Account b = new Account(23, "Checking", 24, 400);
		Account c = new Account(24, "Checking", 24, 400);
		Account d = new Account(42, "Checking", 24, 400);
		List<Account> aList = new ArrayList<Account>();
		aList.add(a);
		aList.add(b);
		aList.add(c);
		aList.add(d);
		double delta = 0;
		int expected = 4;
		int actual = aList.size();
		assertEquals(expected, actual, delta);
	}
	@Test
	public void deleteAccounts() {
		Account a = new Account(22, "Checking", 24, 400);
		Account b = new Account(23, "Checking", 24, 400);
		Account c = new Account(24, "Checking", 24, 400);
		Account d = new Account(42, "Checking", 24, 400);
		List<Account> aList = new ArrayList<Account>();
		aList.add(a);
		aList.add(b);
		aList.add(c);
		aList.add(d);
		for (Account account : aList) {
			if (account.getBalance()>0) {
				aList.remove(account);
			}
		}
		assertFalse(aList.isEmpty());
		System.out.println(aList.toString());
	}
}
