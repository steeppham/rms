declare variable $input-document external;
declare variable $pattern external;
declare variable $sort external;

<registrations>
{
  for $fuel in doc($input-document)/registrations/fuel
  where (matches($fuel/name/text(), $pattern, "i"))
  order by
  		if ($sort eq "ascending") then $fuel/total/text() else () ascending ,
  		if ($sort eq "descending") then $fuel/total/text() else () descending,
  		if ($sort eq "none") then () else ()
  return $fuel
}
</registrations>