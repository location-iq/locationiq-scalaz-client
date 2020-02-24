package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DirectionsDirections._

case class DirectionsDirections (
  code: Option[String],
waypoints: Option[List[Any]],
routes: Option[List[DirectionsDirectionsRoutes]])

object DirectionsDirections {
  import DateTimeCodecs._

  implicit val DirectionsDirectionsCodecJson: CodecJson[DirectionsDirections] = CodecJson.derive[DirectionsDirections]
  implicit val DirectionsDirectionsDecoder: EntityDecoder[DirectionsDirections] = jsonOf[DirectionsDirections]
  implicit val DirectionsDirectionsEncoder: EntityEncoder[DirectionsDirections] = jsonEncoderOf[DirectionsDirections]
}
