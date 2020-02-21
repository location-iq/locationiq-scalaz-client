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

object AutocompleteApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def autocomplete(host: String, q: String, normalizecity: Integer, limit: Integer = 10, viewbox: String, bounded: Integer, countrycodes: String, acceptLanguage: String, tag: String)(implicit qQuery: QueryParam[String], limitQuery: QueryParam[Integer], viewboxQuery: QueryParam[String], boundedQuery: QueryParam[Integer], countrycodesQuery: QueryParam[String], normalizecityQuery: QueryParam[Integer], acceptLanguageQuery: QueryParam[String], tagQuery: QueryParam[String]): Task[List[Any]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Any]] = jsonOf[List[Any]]

    val path = "/autocomplete.php"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("q", Some(qQuery.toParamString(q))), ("limit", Some(limitQuery.toParamString(limit))), ("viewbox", Some(viewboxQuery.toParamString(viewbox))), ("bounded", Some(boundedQuery.toParamString(bounded))), ("countrycodes", Some(countrycodesQuery.toParamString(countrycodes))), ("normalizecity", Some(normalizecityQuery.toParamString(normalizecity))), ("acceptLanguage", Some(accept-languageQuery.toParamString(accept-language))), ("tag", Some(tagQuery.toParamString(tag))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Any]](req)

    } yield resp
  }
  
}

class HttpServiceAutocompleteApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def autocomplete(q: String, normalizecity: Integer, limit: Integer = 10, viewbox: String, bounded: Integer, countrycodes: String, acceptLanguage: String, tag: String)(implicit qQuery: QueryParam[String], limitQuery: QueryParam[Integer], viewboxQuery: QueryParam[String], boundedQuery: QueryParam[Integer], countrycodesQuery: QueryParam[String], normalizecityQuery: QueryParam[Integer], acceptLanguageQuery: QueryParam[String], tagQuery: QueryParam[String]): Task[List[Any]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Any]] = jsonOf[List[Any]]

    val path = "/autocomplete.php"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("q", Some(qQuery.toParamString(q))), ("limit", Some(limitQuery.toParamString(limit))), ("viewbox", Some(viewboxQuery.toParamString(viewbox))), ("bounded", Some(boundedQuery.toParamString(bounded))), ("countrycodes", Some(countrycodesQuery.toParamString(countrycodes))), ("normalizecity", Some(normalizecityQuery.toParamString(normalizecity))), ("acceptLanguage", Some(accept-languageQuery.toParamString(accept-language))), ("tag", Some(tagQuery.toParamString(tag))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Any]](req)

    } yield resp
  }
  
}
