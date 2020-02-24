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

import org.openapitools.client.api.DirectionsMatching
import org.openapitools.client.api.Error

object MatchingApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def matching(host: String, coordinates: String, generateHints: String, approaches: String, exclude: String, bearings: String, radiuses: String, steps: String, annotations: String = "false", geometries: String = "polyline", overview: String = "simplified", timestamps: String, gaps: String = "split", tidy: String = "false", waypoints: String)(implicit generateHintsQuery: QueryParam[String], approachesQuery: QueryParam[String], excludeQuery: QueryParam[String], bearingsQuery: QueryParam[String], radiusesQuery: QueryParam[String], stepsQuery: QueryParam[String], annotationsQuery: QueryParam[String], geometriesQuery: QueryParam[String], overviewQuery: QueryParam[String], timestampsQuery: QueryParam[String], gapsQuery: QueryParam[String], tidyQuery: QueryParam[String], waypointsQuery: QueryParam[String]): Task[DirectionsMatching] = {
    implicit val returnTypeDecoder: EntityDecoder[DirectionsMatching] = jsonOf[DirectionsMatching]

    val path = "/matching/driving/{coordinates}".replaceAll("\\{" + "coordinates" + "\\}",escape(coordinates.toString))
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("generateHints", Some(generate_hintsQuery.toParamString(generate_hints))), ("approaches", Some(approachesQuery.toParamString(approaches))), ("exclude", Some(excludeQuery.toParamString(exclude))), ("bearings", Some(bearingsQuery.toParamString(bearings))), ("radiuses", Some(radiusesQuery.toParamString(radiuses))), ("steps", Some(stepsQuery.toParamString(steps))), ("annotations", Some(annotationsQuery.toParamString(annotations))), ("geometries", Some(geometriesQuery.toParamString(geometries))), ("overview", Some(overviewQuery.toParamString(overview))), ("timestamps", Some(timestampsQuery.toParamString(timestamps))), ("gaps", Some(gapsQuery.toParamString(gaps))), ("tidy", Some(tidyQuery.toParamString(tidy))), ("waypoints", Some(waypointsQuery.toParamString(waypoints))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[DirectionsMatching](req)

    } yield resp
  }
  
}

class HttpServiceMatchingApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def matching(coordinates: String, generateHints: String, approaches: String, exclude: String, bearings: String, radiuses: String, steps: String, annotations: String = "false", geometries: String = "polyline", overview: String = "simplified", timestamps: String, gaps: String = "split", tidy: String = "false", waypoints: String)(implicit generateHintsQuery: QueryParam[String], approachesQuery: QueryParam[String], excludeQuery: QueryParam[String], bearingsQuery: QueryParam[String], radiusesQuery: QueryParam[String], stepsQuery: QueryParam[String], annotationsQuery: QueryParam[String], geometriesQuery: QueryParam[String], overviewQuery: QueryParam[String], timestampsQuery: QueryParam[String], gapsQuery: QueryParam[String], tidyQuery: QueryParam[String], waypointsQuery: QueryParam[String]): Task[DirectionsMatching] = {
    implicit val returnTypeDecoder: EntityDecoder[DirectionsMatching] = jsonOf[DirectionsMatching]

    val path = "/matching/driving/{coordinates}".replaceAll("\\{" + "coordinates" + "\\}",escape(coordinates.toString))
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("generateHints", Some(generate_hintsQuery.toParamString(generate_hints))), ("approaches", Some(approachesQuery.toParamString(approaches))), ("exclude", Some(excludeQuery.toParamString(exclude))), ("bearings", Some(bearingsQuery.toParamString(bearings))), ("radiuses", Some(radiusesQuery.toParamString(radiuses))), ("steps", Some(stepsQuery.toParamString(steps))), ("annotations", Some(annotationsQuery.toParamString(annotations))), ("geometries", Some(geometriesQuery.toParamString(geometries))), ("overview", Some(overviewQuery.toParamString(overview))), ("timestamps", Some(timestampsQuery.toParamString(timestamps))), ("gaps", Some(gapsQuery.toParamString(gaps))), ("tidy", Some(tidyQuery.toParamString(tidy))), ("waypoints", Some(waypointsQuery.toParamString(waypoints))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[DirectionsMatching](req)

    } yield resp
  }
  
}
