package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.math.BigDecimal

import DirectionsMatrix._

case class DirectionsMatrix (
  code: Option[String],
distances: Option[List[BigDecimal]],
fallbackSpeedCells: Option[List[BigDecimal]],
sources: Option[List[DirectionsMatrixSources]],
destinations: Option[List[DirectionsMatrixSources]])

object DirectionsMatrix {
  import DateTimeCodecs._

  implicit val DirectionsMatrixCodecJson: CodecJson[DirectionsMatrix] = CodecJson.derive[DirectionsMatrix]
  implicit val DirectionsMatrixDecoder: EntityDecoder[DirectionsMatrix] = jsonOf[DirectionsMatrix]
  implicit val DirectionsMatrixEncoder: EntityEncoder[DirectionsMatrix] = jsonEncoderOf[DirectionsMatrix]
}
