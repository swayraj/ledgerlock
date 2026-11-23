CREATE TABLE accounts (
    id BIGSERIAL PRIMARY KEY,
    owner_name TEXT NOT NULL CHECK (btrim(owner_name) <> ''),
    balance NUMERIC(19, 2) NOT NULL DEFAULT 0.00
);