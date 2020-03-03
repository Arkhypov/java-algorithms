/*selecting count from 2 tables */
SELECT s.ShipperName, COUNT(o.ShipperID) as c
FROM Shippers s inner join Orders o
on s.ShipperID = o.ShipperID
GROUP BY ShipperName
ORder BY ShipperName;