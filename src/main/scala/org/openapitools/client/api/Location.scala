package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.math.BigDecimal

import Location._

case class Location (
  distance: Option[BigDecimal],
placeId: Option[String],
licence: Option[String],
osmType: Option[String],
osmId: Option[String],
boundingbox: Option[List[String]],
lat: Option[String],
lon: Option[String],
displayName: Option[String],
`class`: Option[String],
`type`: Option[String],
importance: Option[BigDecimal],
address: Option[Address],
namedetails: Option[Namedetails],
matchquality: Option[Matchquality])

object Location {
  import DateTimeCodecs._

  implicit val LocationCodecJson: CodecJson[Location] = CodecJson.derive[Location]
  implicit val LocationDecoder: EntityDecoder[Location] = jsonOf[Location]
  implicit val LocationEncoder: EntityEncoder[Location] = jsonEncoderOf[Location]
}
