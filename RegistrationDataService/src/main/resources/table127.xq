declare variable $input-document external;

<vehicletype>
{
  for $vehicle in doc($input-document)/registrations/postcode[1]/vehicles/vehicle
  return
  <vehicle>{$vehicle/name/text()}</vehicle>
}
</vehicletype>