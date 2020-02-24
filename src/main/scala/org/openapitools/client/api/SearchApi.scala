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

import org.openapitools.client.api.Error
import org.openapitools.client.api.Location

object SearchApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def search(host: String, q: String, format: String, normalizecity: Integer, addressdetails: Integer, viewbox: String, bounded: Integer, limit: Integer = 10, acceptLanguage: String, countrycodes: String, namedetails: Integer, dedupe: Integer, extratags: Integer, statecode: Integer, matchquality: Integer, postaladdress: Integer)(implicit qQuery: QueryParam[String], formatQuery: QueryParam[String], normalizecityQuery: QueryParam[Integer], addressdetailsQuery: QueryParam[Integer], viewboxQuery: QueryParam[String], boundedQuery: QueryParam[Integer], limitQuery: QueryParam[Integer], acceptLanguageQuery: QueryParam[String], countrycodesQuery: QueryParam[String], namedetailsQuery: QueryParam[Integer], dedupeQuery: QueryParam[Integer], extratagsQuery: QueryParam[Integer], statecodeQuery: QueryParam[Integer], matchqualityQuery: QueryParam[Integer], postaladdressQuery: QueryParam[Integer]): Task[List[Location]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Location]] = jsonOf[List[Location]]

    val path = "/search.php"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("q", Some(qQuery.toParamString(q))), ("format", Some(formatQuery.toParamString(format))), ("normalizecity", Some(normalizecityQuery.toParamString(normalizecity))), ("addressdetails", Some(addressdetailsQuery.toParamString(addressdetails))), ("viewbox", Some(viewboxQuery.toParamString(viewbox))), ("bounded", Some(boundedQuery.toParamString(bounded))), ("limit", Some(limitQuery.toParamString(limit))), ("acceptLanguage", Some(accept-languageQuery.toParamString(accept-language))), ("countrycodes", Some(countrycodesQuery.toParamString(countrycodes))), ("namedetails", Some(namedetailsQuery.toParamString(namedetails))), ("dedupe", Some(dedupeQuery.toParamString(dedupe))), ("extratags", Some(extratagsQuery.toParamString(extratags))), ("statecode", Some(statecodeQuery.toParamString(statecode))), ("matchquality", Some(matchqualityQuery.toParamString(matchquality))), ("postaladdress", Some(postaladdressQuery.toParamString(postaladdress))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Location]](req)

    } yield resp
  }
  
}

class HttpServiceSearchApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def search(q: String, format: String, normalizecity: Integer, addressdetails: Integer, viewbox: String, bounded: Integer, limit: Integer = 10, acceptLanguage: String, countrycodes: String, namedetails: Integer, dedupe: Integer, extratags: Integer, statecode: Integer, matchquality: Integer, postaladdress: Integer)(implicit qQuery: QueryParam[String], formatQuery: QueryParam[String], normalizecityQuery: QueryParam[Integer], addressdetailsQuery: QueryParam[Integer], viewboxQuery: QueryParam[String], boundedQuery: QueryParam[Integer], limitQuery: QueryParam[Integer], acceptLanguageQuery: QueryParam[String], countrycodesQuery: QueryParam[String], namedetailsQuery: QueryParam[Integer], dedupeQuery: QueryParam[Integer], extratagsQuery: QueryParam[Integer], statecodeQuery: QueryParam[Integer], matchqualityQuery: QueryParam[Integer], postaladdressQuery: QueryParam[Integer]): Task[List[Location]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Location]] = jsonOf[List[Location]]

    val path = "/search.php"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("q", Some(qQuery.toParamString(q))), ("format", Some(formatQuery.toParamString(format))), ("normalizecity", Some(normalizecityQuery.toParamString(normalizecity))), ("addressdetails", Some(addressdetailsQuery.toParamString(addressdetails))), ("viewbox", Some(viewboxQuery.toParamString(viewbox))), ("bounded", Some(boundedQuery.toParamString(bounded))), ("limit", Some(limitQuery.toParamString(limit))), ("acceptLanguage", Some(accept-languageQuery.toParamString(accept-language))), ("countrycodes", Some(countrycodesQuery.toParamString(countrycodes))), ("namedetails", Some(namedetailsQuery.toParamString(namedetails))), ("dedupe", Some(dedupeQuery.toParamString(dedupe))), ("extratags", Some(extratagsQuery.toParamString(extratags))), ("statecode", Some(statecodeQuery.toParamString(statecode))), ("matchquality", Some(matchqualityQuery.toParamString(matchquality))), ("postaladdress", Some(postaladdressQuery.toParamString(postaladdress))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Location]](req)

    } yield resp
  }
  
}
