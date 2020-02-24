package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.math.BigDecimal

import DirectionsMatrixSources._

case class DirectionsMatrixSources (
  distance: Option[BigDecimal],
location: Option[List[BigDecimal]],
name: Option[String])

object DirectionsMatrixSources {
  import DateTimeCodecs._

  implicit val DirectionsMatrixSourcesCodecJson: CodecJson[DirectionsMatrixSources] = CodecJson.derive[DirectionsMatrixSources]
  implicit val DirectionsMatrixSourcesDecoder: EntityDecoder[DirectionsMatrixSources] = jsonOf[DirectionsMatrixSources]
  implicit val DirectionsMatrixSourcesEncoder: EntityEncoder[DirectionsMatrixSources] = jsonEncoderOf[DirectionsMatrixSources]
}
