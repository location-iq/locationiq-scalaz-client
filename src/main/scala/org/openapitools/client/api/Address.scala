package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Address._

case class Address (
  houseNumber: Option[String],
road: Option[String],
residential: Option[String],
borough: Option[String],
neighbourhood: Option[String],
quarter: Option[String],
hamlet: Option[String],
suburb: Option[String],
island: Option[String],
village: Option[String],
town: Option[String],
city: Option[String],
cityDistrict: Option[String],
county: Option[String],
state: Option[String],
stateDistrict: Option[String],
postcode: Option[String],
country: Option[String],
countryCode: Option[String],
stateCode: Option[String])

object Address {
  import DateTimeCodecs._

  implicit val AddressCodecJson: CodecJson[Address] = CodecJson.derive[Address]
  implicit val AddressDecoder: EntityDecoder[Address] = jsonOf[Address]
  implicit val AddressEncoder: EntityEncoder[Address] = jsonEncoderOf[Address]
}
