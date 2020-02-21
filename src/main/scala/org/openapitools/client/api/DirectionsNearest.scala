package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DirectionsNearest._

case class DirectionsNearest (
  code: Option[String],
waypoints: Option[List[DirectionsNearestWaypoints]])

object DirectionsNearest {
  import DateTimeCodecs._

  implicit val DirectionsNearestCodecJson: CodecJson[DirectionsNearest] = CodecJson.derive[DirectionsNearest]
  implicit val DirectionsNearestDecoder: EntityDecoder[DirectionsNearest] = jsonOf[DirectionsNearest]
  implicit val DirectionsNearestEncoder: EntityEncoder[DirectionsNearest] = jsonEncoderOf[DirectionsNearest]
}
