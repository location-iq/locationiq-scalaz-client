package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.math.BigDecimal

import DirectionsDirectionsRoutes._

case class DirectionsDirectionsRoutes (
  legs: Option[List[Any]],
weightName: Option[String],
geometry: Option[String],
weight: Option[BigDecimal],
distance: Option[BigDecimal],
duration: Option[BigDecimal])

object DirectionsDirectionsRoutes {
  import DateTimeCodecs._

  implicit val DirectionsDirectionsRoutesCodecJson: CodecJson[DirectionsDirectionsRoutes] = CodecJson.derive[DirectionsDirectionsRoutes]
  implicit val DirectionsDirectionsRoutesDecoder: EntityDecoder[DirectionsDirectionsRoutes] = jsonOf[DirectionsDirectionsRoutes]
  implicit val DirectionsDirectionsRoutesEncoder: EntityEncoder[DirectionsDirectionsRoutes] = jsonEncoderOf[DirectionsDirectionsRoutes]
}
