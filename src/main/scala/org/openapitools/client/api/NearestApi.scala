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

import org.openapitools.client.api.DirectionsNearest
import org.openapitools.client.api.Error

object NearestApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def nearest(host: String, coordinates: String, generateHints: String, exclude: String, bearings: String, radiuses: String, approaches: String, number: Integer)(implicit generateHintsQuery: QueryParam[String], excludeQuery: QueryParam[String], bearingsQuery: QueryParam[String], radiusesQuery: QueryParam[String], approachesQuery: QueryParam[String], numberQuery: QueryParam[Integer]): Task[DirectionsNearest] = {
    implicit val returnTypeDecoder: EntityDecoder[DirectionsNearest] = jsonOf[DirectionsNearest]

    val path = "/nearest/driving/{coordinates}".replaceAll("\\{" + "coordinates" + "\\}",escape(coordinates.toString))
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("generateHints", Some(generate_hintsQuery.toParamString(generate_hints))), ("exclude", Some(excludeQuery.toParamString(exclude))), ("bearings", Some(bearingsQuery.toParamString(bearings))), ("radiuses", Some(radiusesQuery.toParamString(radiuses))), ("approaches", Some(approachesQuery.toParamString(approaches))), ("number", Some(numberQuery.toParamString(number))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[DirectionsNearest](req)

    } yield resp
  }
  
}

class HttpServiceNearestApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def nearest(coordinates: String, generateHints: String, exclude: String, bearings: String, radiuses: String, approaches: String, number: Integer)(implicit generateHintsQuery: QueryParam[String], excludeQuery: QueryParam[String], bearingsQuery: QueryParam[String], radiusesQuery: QueryParam[String], approachesQuery: QueryParam[String], numberQuery: QueryParam[Integer]): Task[DirectionsNearest] = {
    implicit val returnTypeDecoder: EntityDecoder[DirectionsNearest] = jsonOf[DirectionsNearest]

    val path = "/nearest/driving/{coordinates}".replaceAll("\\{" + "coordinates" + "\\}",escape(coordinates.toString))
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("generateHints", Some(generate_hintsQuery.toParamString(generate_hints))), ("exclude", Some(excludeQuery.toParamString(exclude))), ("bearings", Some(bearingsQuery.toParamString(bearings))), ("radiuses", Some(radiusesQuery.toParamString(radiuses))), ("approaches", Some(approachesQuery.toParamString(approaches))), ("number", Some(numberQuery.toParamString(number))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[DirectionsNearest](req)

    } yield resp
  }
  
}
