package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Matchquality._

case class Matchquality (
  matchcode: Option[String],
matchtype: Option[String],
matchlevel: Option[String])

object Matchquality {
  import DateTimeCodecs._

  implicit val MatchqualityCodecJson: CodecJson[Matchquality] = CodecJson.derive[Matchquality]
  implicit val MatchqualityDecoder: EntityDecoder[Matchquality] = jsonOf[Matchquality]
  implicit val MatchqualityEncoder: EntityEncoder[Matchquality] = jsonEncoderOf[Matchquality]
}
