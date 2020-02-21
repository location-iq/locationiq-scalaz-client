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
import org.openapitools.client.api.DirectionsDirections
import org.openapitools.client.api.Error

object DirectionsApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def directions(host: String, coordinates: String, bearings: String, radiuses: String, generateHints: String, approaches: String, exclude: String, alternatives: BigDecimal, steps: String, annotations: String = "false", geometries: String = "polyline", overview: String = "simplified", continueStraight: String = "default")(implicit bearingsQuery: QueryParam[String], radiusesQuery: QueryParam[String], generateHintsQuery: QueryParam[String], approachesQuery: QueryParam[String], excludeQuery: QueryParam[String], alternativesQuery: QueryParam[BigDecimal], stepsQuery: QueryParam[String], annotationsQuery: QueryParam[String], geometriesQuery: QueryParam[String], overviewQuery: QueryParam[String], continueStraightQuery: QueryParam[String]): Task[DirectionsDirections] = {
    implicit val returnTypeDecoder: EntityDecoder[DirectionsDirections] = jsonOf[DirectionsDirections]

    val path = "/directions/driving/{coordinates}".replaceAll("\\{" + "coordinates" + "\\}",escape(coordinates.toString))
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("bearings", Some(bearingsQuery.toParamString(bearings))), ("radiuses", Some(radiusesQuery.toParamString(radiuses))), ("generateHints", Some(generate_hintsQuery.toParamString(generate_hints))), ("approaches", Some(approachesQuery.toParamString(approaches))), ("exclude", Some(excludeQuery.toParamString(exclude))), ("alternatives", Some(alternativesQuery.toParamString(alternatives))), ("steps", Some(stepsQuery.toParamString(steps))), ("annotations", Some(annotationsQuery.toParamString(annotations))), ("geometries", Some(geometriesQuery.toParamString(geometries))), ("overview", Some(overviewQuery.toParamString(overview))), ("continueStraight", Some(continue_straightQuery.toParamString(continue_straight))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[DirectionsDirections](req)

    } yield resp
  }
  
}

class HttpServiceDirectionsApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def directions(coordinates: String, bearings: String, radiuses: String, generateHints: String, approaches: String, exclude: String, alternatives: BigDecimal, steps: String, annotations: String = "false", geometries: String = "polyline", overview: String = "simplified", continueStraight: String = "default")(implicit bearingsQuery: QueryParam[String], radiusesQuery: QueryParam[String], generateHintsQuery: QueryParam[String], approachesQuery: QueryParam[String], excludeQuery: QueryParam[String], alternativesQuery: QueryParam[BigDecimal], stepsQuery: QueryParam[String], annotationsQuery: QueryParam[String], geometriesQuery: QueryParam[String], overviewQuery: QueryParam[String], continueStraightQuery: QueryParam[String]): Task[DirectionsDirections] = {
    implicit val returnTypeDecoder: EntityDecoder[DirectionsDirections] = jsonOf[DirectionsDirections]

    val path = "/directions/driving/{coordinates}".replaceAll("\\{" + "coordinates" + "\\}",escape(coordinates.toString))
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("bearings", Some(bearingsQuery.toParamString(bearings))), ("radiuses", Some(radiusesQuery.toParamString(radiuses))), ("generateHints", Some(generate_hintsQuery.toParamString(generate_hints))), ("approaches", Some(approachesQuery.toParamString(approaches))), ("exclude", Some(excludeQuery.toParamString(exclude))), ("alternatives", Some(alternativesQuery.toParamString(alternatives))), ("steps", Some(stepsQuery.toParamString(steps))), ("annotations", Some(annotationsQuery.toParamString(annotations))), ("geometries", Some(geometriesQuery.toParamString(geometries))), ("overview", Some(overviewQuery.toParamString(overview))), ("continueStraight", Some(continue_straightQuery.toParamString(continue_straight))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[DirectionsDirections](req)

    } yield resp
  }
  
}
