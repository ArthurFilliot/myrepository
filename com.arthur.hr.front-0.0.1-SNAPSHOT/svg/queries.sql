delete from locations where LOCATION_ID!=35;
update locations set country_id='XX';
delete from COUNTRIES where COUNTRY_ID<>'XX';
update countries set REGION_ID=35;
delete from regions where REGION_ID<>35;

select * from regions;
select * from countries;
select * from locations;

