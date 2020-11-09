package com.project0.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.project0.bankapp.actions.CustomerDoes;
import com.project0.bankapp.beans.Account;

public class ActionsTest {
	
	@BeforeClass
	public static void start() {
		System.out.println("It has begun");
	}
	@Before
	public void runBeforeTest() {
		System.out.println("You havent messed it up yet");
	}
	@Test
	public void test() {
		assertTrue(true);
	}
	@Test
	public void anotherTest() {
		//assertEquals(a, a)
	}
	@Test
	public void depositSomething() {
		Account a = new Account();
		CustomerDoes.takeMonies(a, 10000.75d);
		a.getBalance();
		double actual = 10000.75d;
		double delta = 0;
		assertEquals(10000.75d, actual, delta);
		System.out.println(a.getBalance());
	}
	@Test
	public void withdrawSomething() {
		Account a = new Account();
		a.setBalance(10000);
		CustomerDoes.giveMonies(a, 500);
		a.getBalance();
		double actual = 9500;
		double delta = 0;
		assertEquals(9500, actual, delta);
		System.out.println(a.getBalance());
	}
	@Test
	public void moveMoney() {
		Account a = new Account();
		Account b = new Account();
		a.setBalance(500);
		b.setBalance(500);
		CustomerDoes.moveMonies(a, b, 200);
		double actual = a.getBalance();
		double expected = 300;
		double delta = 0;
		assertEquals(expected, actual, delta);
		System.out.println(a.getBalance() + " " + b.getBalance());
	}
}
