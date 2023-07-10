CREATE TABLE balances (
                          id INT PRIMARY KEY,
                          balance_amount NUMERIC (10, 3) NOT NULL,
                          last_transaction_date DATE NOT NULL
);





--CREATE VIEW sum_of_transaction_amounts AS
--SELECT COALESCE(SUM(transaction_amount), 0) AS sum_amount
--FROM transactions;


--CREATE VIEW sum_of_client_transaction_amounts AS
--SELECT COALESCE(SUM(CASE WHEN client_id IS NOT NULL THEN transaction_amount ELSE 0 END), 0) AS sum_amount
--FROM transactions;


--CREATE TRIGGER calculate_current_balance
--    AFTER INSERT ON transactions
--    FOR EACH ROW
--BEGIN
--    INSERT INTO balances (balance_amount, last_transaction_date)
--   SELECT (SELECT sum_amount FROM sum_of_transaction_amounts) - (SELECT sum_amount FROM sum_of_client_transaction_amounts), NOW();
--END;