declare variable $input-document external;
declare variable $sort external;

<fueltype>
{
  for $fuel in doc($input-document)/registrations/fuel
  	order by
  		if ($sort eq "ascending") then $fuel/name/text() else () ascending ,
  		if ($sort eq "descending") then $fuel/name/text() else () descending,
  		if ($sort eq "none") then () else ()
  return
  <fuel>{$fuel/name/text()}</fuel>
}
</fueltype>