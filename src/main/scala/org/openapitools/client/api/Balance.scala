package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Balance._

case class Balance (
  status: Option[String],
balance: Option[Daybalance])

object Balance {
  import DateTimeCodecs._

  implicit val BalanceCodecJson: CodecJson[Balance] = CodecJson.derive[Balance]
  implicit val BalanceDecoder: EntityDecoder[Balance] = jsonOf[Balance]
  implicit val BalanceEncoder: EntityEncoder[Balance] = jsonEncoderOf[Balance]
}
