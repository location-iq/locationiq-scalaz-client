package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import java.io.File
import java.net.URLEncoder
import java.util.UUID

import org.http4s._
import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.http4s.client._
import org.http4s.client.blaze.PooledHttp1Client
import org.http4s.headers._

import org.joda.time.DateTime

import scalaz.concurrent.Task

import HelperCodecs._

import java.math.BigDecimal
import org.openapitools.client.api.Error
import org.openapitools.client.api.Location

object ReverseApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def reverse(host: String, lat: BigDecimal, lon: BigDecimal, format: String, normalizecity: Integer, addressdetails: Integer = 1, acceptLanguage: String, namedetails: Integer, extratags: Integer, statecode: Integer, showdistance: Integer, postaladdress: Integer)(implicit latQuery: QueryParam[BigDecimal], lonQuery: QueryParam[BigDecimal], formatQuery: QueryParam[String], normalizecityQuery: QueryParam[Integer], addressdetailsQuery: QueryParam[Integer], acceptLanguageQuery: QueryParam[String], namedetailsQuery: QueryParam[Integer], extratagsQuery: QueryParam[Integer], statecodeQuery: QueryParam[Integer], showdistanceQuery: QueryParam[Integer], postaladdressQuery: QueryParam[Integer]): Task[Location] = {
    implicit val returnTypeDecoder: EntityDecoder[Location] = jsonOf[Location]

    val path = "/reverse.php"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("lat", Some(latQuery.toParamString(lat))), ("lon", Some(lonQuery.toParamString(lon))), ("format", Some(formatQuery.toParamString(format))), ("normalizecity", Some(normalizecityQuery.toParamString(normalizecity))), ("addressdetails", Some(addressdetailsQuery.toParamString(addressdetails))), ("acceptLanguage", Some(accept-languageQuery.toParamString(accept-language))), ("namedetails", Some(namedetailsQuery.toParamString(namedetails))), ("extratags", Some(extratagsQuery.toParamString(extratags))), ("statecode", Some(statecodeQuery.toParamString(statecode))), ("showdistance", Some(showdistanceQuery.toParamString(showdistance))), ("postaladdress", Some(postaladdressQuery.toParamString(postaladdress))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[Location](req)

    } yield resp
  }
  
}

class HttpServiceReverseApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def reverse(lat: BigDecimal, lon: BigDecimal, format: String, normalizecity: Integer, addressdetails: Integer = 1, acceptLanguage: String, namedetails: Integer, extratags: Integer, statecode: Integer, showdistance: Integer, postaladdress: Integer)(implicit latQuery: QueryParam[BigDecimal], lonQuery: QueryParam[BigDecimal], formatQuery: QueryParam[String], normalizecityQuery: QueryParam[Integer], addressdetailsQuery: QueryParam[Integer], acceptLanguageQuery: QueryParam[String], namedetailsQuery: QueryParam[Integer], extratagsQuery: QueryParam[Integer], statecodeQuery: QueryParam[Integer], showdistanceQuery: QueryParam[Integer], postaladdressQuery: QueryParam[Integer]): Task[Location] = {
    implicit val returnTypeDecoder: EntityDecoder[Location] = jsonOf[Location]

    val path = "/reverse.php"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("lat", Some(latQuery.toParamString(lat))), ("lon", Some(lonQuery.toParamString(lon))), ("format", Some(formatQuery.toParamString(format))), ("normalizecity", Some(normalizecityQuery.toParamString(normalizecity))), ("addressdetails", Some(addressdetailsQuery.toParamString(addressdetails))), ("acceptLanguage", Some(accept-languageQuery.toParamString(accept-language))), ("namedetails", Some(namedetailsQuery.toParamString(namedetails))), ("extratags", Some(extratagsQuery.toParamString(extratags))), ("statecode", Some(statecodeQuery.toParamString(statecode))), ("showdistance", Some(showdistanceQuery.toParamString(showdistance))), ("postaladdress", Some(postaladdressQuery.toParamString(postaladdress))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[Location](req)

    } yield resp
  }
  
}
