select 
    r.REGION_ID, r.REGION_NAME, c.COUNTRY_ID, c.COUNTRY_NAME, l.LOCATION_ID, l.STATE_PROVINCE, l.POSTAL_CODE, l.CITY, l.STREET_ADDRESS 
from LOCATIONS l
join countries c
    join regions r on r.REGION_ID=c.REGION_ID
on c.COUNTRY_ID=l.COUNTRY_ID
order by
        r.REGION_NAME, c.COUNTRY_ID, c.COUNTRY_NAME, l.STATE_PROVINCE, l.POSTAL_CODE, l.CITY, l.STREET_ADDRESS;