package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Daybalance._

case class Daybalance (
  day: Option[Integer],
bonus: Option[Integer])

object Daybalance {
  import DateTimeCodecs._

  implicit val DaybalanceCodecJson: CodecJson[Daybalance] = CodecJson.derive[Daybalance]
  implicit val DaybalanceDecoder: EntityDecoder[Daybalance] = jsonOf[Daybalance]
  implicit val DaybalanceEncoder: EntityEncoder[Daybalance] = jsonEncoderOf[Daybalance]
}
