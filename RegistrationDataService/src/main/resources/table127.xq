declare variable $input-document external;
declare variable $sort external;

<vehicletype>
{
  for $vehicle in doc($input-document)/registrations/postcode[1]/vehicles/vehicle
  order by
  		if ($sort eq "ascending") then $vehicle/name/text() else () ascending ,
  		if ($sort eq "descending") then $vehicle/name/text() else () descending,
  		if ($sort eq "none") then () else ()
  return
  <vehicle>{$vehicle/name/text()}</vehicle>
}
</vehicletype>