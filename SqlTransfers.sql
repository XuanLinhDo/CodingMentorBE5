SELECT t.name, 
SUM(CASE WHEN t.money > 0 THEN t.money ELSE 0 END) AS sum_of_deposits,
SUM(CASE WHEN t.money < 0 THEN - t.money ELSE 0 END) AS sum_of_withdrawnls
FROM transfers t
GROUP BY t.name
ORDER BY t.name;