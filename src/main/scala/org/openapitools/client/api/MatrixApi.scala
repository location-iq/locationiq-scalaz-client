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
import org.openapitools.client.api.DirectionsMatrix
import org.openapitools.client.api.Error

object MatrixApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def matrix(host: String, coordinates: String, bearings: String, radiuses: String, generateHints: String, approaches: String, exclude: String, annotations: String, sources: Integer, destinations: Integer, fallbackSpeed: BigDecimal, fallbackCoordinate: String = "input")(implicit bearingsQuery: QueryParam[String], radiusesQuery: QueryParam[String], generateHintsQuery: QueryParam[String], approachesQuery: QueryParam[String], excludeQuery: QueryParam[String], annotationsQuery: QueryParam[String], sourcesQuery: QueryParam[Integer], destinationsQuery: QueryParam[Integer], fallbackSpeedQuery: QueryParam[BigDecimal], fallbackCoordinateQuery: QueryParam[String]): Task[DirectionsMatrix] = {
    implicit val returnTypeDecoder: EntityDecoder[DirectionsMatrix] = jsonOf[DirectionsMatrix]

    val path = "/matrix/driving/{coordinates}".replaceAll("\\{" + "coordinates" + "\\}",escape(coordinates.toString))
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("bearings", Some(bearingsQuery.toParamString(bearings))), ("radiuses", Some(radiusesQuery.toParamString(radiuses))), ("generateHints", Some(generate_hintsQuery.toParamString(generate_hints))), ("approaches", Some(approachesQuery.toParamString(approaches))), ("exclude", Some(excludeQuery.toParamString(exclude))), ("annotations", Some(annotationsQuery.toParamString(annotations))), ("sources", Some(sourcesQuery.toParamString(sources))), ("destinations", Some(destinationsQuery.toParamString(destinations))), ("fallbackSpeed", Some(fallback_speedQuery.toParamString(fallback_speed))), ("fallbackCoordinate", Some(fallback_coordinateQuery.toParamString(fallback_coordinate))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[DirectionsMatrix](req)

    } yield resp
  }
  
}

class HttpServiceMatrixApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def matrix(coordinates: String, bearings: String, radiuses: String, generateHints: String, approaches: String, exclude: String, annotations: String, sources: Integer, destinations: Integer, fallbackSpeed: BigDecimal, fallbackCoordinate: String = "input")(implicit bearingsQuery: QueryParam[String], radiusesQuery: QueryParam[String], generateHintsQuery: QueryParam[String], approachesQuery: QueryParam[String], excludeQuery: QueryParam[String], annotationsQuery: QueryParam[String], sourcesQuery: QueryParam[Integer], destinationsQuery: QueryParam[Integer], fallbackSpeedQuery: QueryParam[BigDecimal], fallbackCoordinateQuery: QueryParam[String]): Task[DirectionsMatrix] = {
    implicit val returnTypeDecoder: EntityDecoder[DirectionsMatrix] = jsonOf[DirectionsMatrix]

    val path = "/matrix/driving/{coordinates}".replaceAll("\\{" + "coordinates" + "\\}",escape(coordinates.toString))
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("bearings", Some(bearingsQuery.toParamString(bearings))), ("radiuses", Some(radiusesQuery.toParamString(radiuses))), ("generateHints", Some(generate_hintsQuery.toParamString(generate_hints))), ("approaches", Some(approachesQuery.toParamString(approaches))), ("exclude", Some(excludeQuery.toParamString(exclude))), ("annotations", Some(annotationsQuery.toParamString(annotations))), ("sources", Some(sourcesQuery.toParamString(sources))), ("destinations", Some(destinationsQuery.toParamString(destinations))), ("fallbackSpeed", Some(fallback_speedQuery.toParamString(fallback_speed))), ("fallbackCoordinate", Some(fallback_coordinateQuery.toParamString(fallback_coordinate))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[DirectionsMatrix](req)

    } yield resp
  }
  
}
