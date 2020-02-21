package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Namedetails._

case class Namedetails (
  name: Option[String])

object Namedetails {
  import DateTimeCodecs._

  implicit val NamedetailsCodecJson: CodecJson[Namedetails] = CodecJson.derive[Namedetails]
  implicit val NamedetailsDecoder: EntityDecoder[Namedetails] = jsonOf[Namedetails]
  implicit val NamedetailsEncoder: EntityEncoder[Namedetails] = jsonEncoderOf[Namedetails]
}
