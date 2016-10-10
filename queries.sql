
/*

Ejemplos de Queries que usé en la DB;

Nota: Los '?' se deben cambiar por el valor que se quiera buscar
	
SELECT t1.flight_no, t1.airbus_no, t1.capacity, t1.city, air.city, t1.depart_date, t1.depart_time, t1.arrive_date, t1.arrive_time, t1.fare, (t1.capacity - rs.ocurrences) as no_seats FROM airport air, (select flight_no, count(*) as ocurrences from ticket group by flight_no order by flight_no ASC) as rs, (SELECT f.flight_no, f.airbus_no, f.capacity, a.city, f.destination_airport_code, f.depart_date, f.arrive_date, f.depart_time, f.arrive_time, f.fare FROM airport a, flight f where a.id_airport=f.from_airport_code) as t1 WHERE air.id_airport=t1.destination_airport_code and t1.city='medellin' and air.city='bogota' and t1.flight_no=rs.flight_no order by t1.depart_date DESC, t1.depart_time;

SELECT t1.flight_no, t1.airbus_no, t1.capacity, t1.city, air.city, t1.depart_date, t1.depart_time, t1.arrive_date, t1.arrive_time, t1.fare, (t1.capacity - rs.ocurrences) as no_seats FROM airport air, (select flight_no, count(*) as ocurrences from ticket group by flight_no order by flight_no ASC) as rs, (SELECT f.flight_no, f.airbus_no, f.capacity, a.city, f.destination_airport_code, f.depart_date, f.arrive_date, f.depart_time, f.arrive_time, f.fare FROM airport a, flight f where a.id_airport=f.from_airport_code) as t1 WHERE air.id_airport=t1.destination_airport_code and t1.flight_no=rs.flight_no

SELECT t1.flight_no, t1.airbus_no, t1.capacity, t1.city, air.city, t1.depart_date, t1.depart_time, t1.arrive_date, t1.arrive_time, t1.fare , (t1.capacity - rs.ocurrences) as no_seats FROM airport air, (select flight_no, count(*) as ocurrences from ticket group by flight_no order by flight_no ASC) as rs,(SELECT f.flight_no, f.airbus_no, f.capacity, a.city, f.destination_airport_code, f.depart_date, f.arrive_date, f.depart_time, f.arrive_time, f.fare FROM airport a, flight f where a.id_airport=f.from_airport_code) as t1 WHERE air.id_airport=t1.destination_airport_code and t1.flight_no=rs.flight_no and t1.flight_no=?
*/

SELECT t.*, f.airbus_no, f.from_airport_code, f.destination_airport_code, f.depart_date, f.depart_time, f.arrive_date, f.arrive_time, f.fare FROM ticket t, flight f WHERE t.passenger_id=? and f.flight_no=t.flight_no 