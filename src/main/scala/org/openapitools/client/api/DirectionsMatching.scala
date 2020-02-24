package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DirectionsMatching._

case class DirectionsMatching (
  code: Option[String],
tracepoints: Option[List[Any]],
matchings: Option[List[Any]])

object DirectionsMatching {
  import DateTimeCodecs._

  implicit val DirectionsMatchingCodecJson: CodecJson[DirectionsMatching] = CodecJson.derive[DirectionsMatching]
  implicit val DirectionsMatchingDecoder: EntityDecoder[DirectionsMatching] = jsonOf[DirectionsMatching]
  implicit val DirectionsMatchingEncoder: EntityEncoder[DirectionsMatching] = jsonEncoderOf[DirectionsMatching]
}
