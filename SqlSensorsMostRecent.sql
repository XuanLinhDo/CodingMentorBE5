SELECT p.id, p.title, IFNULL(SUM(r.number_of_tickets), 0) AS reserved_tickets
FROM plays p
LEFT JOIN reservations r ON r.play_id = p.id
GROUP BY p.id
ORDER BY reserved_tickets DESC;

