declare variable $input-document external;

<fueltype>
{
  for $fuel in doc($input-document)/registrations/fuel
  return
  <fuel>
  <name>{$fuel/name}</name>
  </fuel>
}
</fueltype>