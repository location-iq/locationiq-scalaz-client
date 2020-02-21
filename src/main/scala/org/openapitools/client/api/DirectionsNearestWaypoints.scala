package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.math.BigDecimal

import DirectionsNearestWaypoints._

case class DirectionsNearestWaypoints (
  nodes: Option[List[BigDecimal]],
distance: Option[BigDecimal],
location: Option[List[BigDecimal]],
name: Option[String])

object DirectionsNearestWaypoints {
  import DateTimeCodecs._

  implicit val DirectionsNearestWaypointsCodecJson: CodecJson[DirectionsNearestWaypoints] = CodecJson.derive[DirectionsNearestWaypoints]
  implicit val DirectionsNearestWaypointsDecoder: EntityDecoder[DirectionsNearestWaypoints] = jsonOf[DirectionsNearestWaypoints]
  implicit val DirectionsNearestWaypointsEncoder: EntityEncoder[DirectionsNearestWaypoints] = jsonEncoderOf[DirectionsNearestWaypoints]
}
