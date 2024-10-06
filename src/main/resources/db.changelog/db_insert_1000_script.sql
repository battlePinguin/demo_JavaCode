INSERT INTO wallet (id, amount)
SELECT
    gen_random_uuid(),
    round(CAST(random() * 10000 + 50 AS numeric), 2)
FROM generate_series(1, 1000);