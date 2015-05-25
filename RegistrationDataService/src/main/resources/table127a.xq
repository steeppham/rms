declare variable $input-document external;
declare variable $pattern external;
declare variable $sort external;

<registrations>
{
  for $postcode in doc($input-document)/registrations/postcode
  where (matches($postcode/code/text(), $pattern, "i"))
  order by
  		if ($sort eq "ascending") then $postcode/total/text() else () ascending ,
  		if ($sort eq "descending") then $postcode/total/text() else () descending,
  		if ($sort eq "none") then () else ()
  return $postcode
}
</registrations>