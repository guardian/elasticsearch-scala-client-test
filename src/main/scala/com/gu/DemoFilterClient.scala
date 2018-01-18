package com.gu

import org.elasticsearch.action._
import org.elasticsearch.client.{Client, FilterClient}

class DemoFilterClient(underlyingClient: Client) extends FilterClient(underlyingClient) {
  override def doExecute[Request <: ActionRequest, Response <: ActionResponse, RequestBuilder <: ActionRequestBuilder[Request, Response, RequestBuilder]](action: Action[Request, Response, RequestBuilder], request: Request, listener: ActionListener[Response]) = super.doExecute(action, request, listener)
}