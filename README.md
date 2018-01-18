### How do you override `org.elasticsearch.client.FilterClient#FilterClient.doExecute()` in Scala?

Specifically with `"org.elasticsearch" % "elasticsearch" % "2.4.x"` (it does work with later versions
of ElasticSearch where `ActionRequest` no lnoger takes a parameter type, but we can't update to those
just yet!).

The naive attempt fails:

```
[info] Compiling 1 Scala source to /home/roberto/development/elasticsearch-scala-client-test/target/scala-2.11/classes ...
[error] /home/roberto/development/elasticsearch-scala-client-test/src/main/scala/com/gu/DemoFilterClient.scala:7:101: type arguments [Request,Response,RequestBuilder] do not conform to class ActionRequestBuilder's type parameter bounds [Request <: org.elasticsearch.action.ActionRequest[_ <: org.elasticsearch.action.ActionRequest[_ <: org.elasticsearch.action.ActionRequest[_ <: AnyRef]]],Response <: org.elasticsearch.action.ActionResponse,RequestBuilder <: org.elasticsearch.action.ActionRequestBuilder[Request,Response,RequestBuilder]]
[error]   override def doExecute[Request <: ActionRequest[_], Response <: ActionResponse, RequestBuilder <: ActionRequestBuilder[Request, Response, RequestBuilder]](action: Action[Request, Response, RequestBuilder], request: Request, listener: ActionListener[Response]) = super.doExecute(action, request, listener)
[error]                                                                                                     ^
[error] one error found
```

To lay out that compiler error more clearly:

```
type arguments
[Request,Response,RequestBuilder]
do not conform to class ActionRequestBuilder's type parameter bounds
[
  Request <: org.elasticsearch.action.ActionRequest[_ <: org.elasticsearch.action.ActionRequest[_ <: org.elasticsearch.action.ActionRequest[_ <: AnyRef]]],
  Response <: org.elasticsearch.action.ActionResponse,
  RequestBuilder <: org.elasticsearch.action.ActionRequestBuilder[Request,Response,RequestBuilder]
]
```
