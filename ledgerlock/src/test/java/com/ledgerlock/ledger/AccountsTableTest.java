package com.ledgerlock.ledger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.simple.JdbcClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class AccountsTableTest {

    @Autowired
    JdbcClient jdbcClient;

    @Test
    void insertsAnAccountRow() {
        jdbcClient.sql("INSERT INTO accounts (owner_name, balance) VALUES (:name, :balance)")
                .param("name", "Asha Traders")
                .param("balance", 500.00)
                .update();
        Integer count = jdbcClient.sql("SELECT COUNT(*) FROM accounts")
                .query(Integer.class)
                .single();
        assertEquals(1, count);

        String name = jdbcClient.sql("SELECT owner_name FROM accounts")
                .query(String.class)
                .single();
        assertEquals("Asha Traders", name);

        jdbcClient.sql("DELETE FROM accounts").update();
        Integer afterDelete = jdbcClient.sql("SELECT COUNT(*) FROM accounts")
                .query(Integer.class)
                .single();
        assertEquals(0, afterDelete);


    }
}