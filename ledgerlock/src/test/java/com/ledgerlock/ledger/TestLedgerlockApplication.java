package com.ledgerlock.ledger;

import org.springframework.boot.SpringApplication;

public class TestLedgerlockApplication {

	public static void main(String[] args) {
		SpringApplication.from(LedgerlockApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
