
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/Project/eprinting-service/services/conf/routes
// @DATE:Sun May 12 06:16:18 ICT 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

object Routes extends Routes

class Routes extends GeneratedRouter {

  import ReverseRouteContext.empty

  override val errorHandler: play.api.http.HttpErrorHandler = play.api.http.LazyHttpErrorHandler

  private var _prefix = "/"

  def withPrefix(prefix: String): Routes = {
    _prefix = prefix
    router.RoutesPrefix.setPrefix(prefix)
    
    this
  }

  def prefix: String = _prefix

  lazy val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation: Seq[(String, String, String)] = List(
    ("""GET""", prefix, """controllers.Application.index"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/test/getall""", """controllers.UserController.getAll"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/test/get/$id<[^/]+>""", """controllers.UserController.get(id:Integer)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/test/insertAll""", """controllers.UserController.insertAll()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/test/insert""", """controllers.UserController.insert()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    controllers.Application.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_UserController_getAll1_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/test/getall")))
  )
  private[this] lazy val controllers_UserController_getAll1_invoker = createInvoker(
    controllers.UserController.getAll,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getAll",
      Nil,
      "GET",
      """""",
      this.prefix + """api/test/getall"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_UserController_get2_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/test/get/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_get2_invoker = createInvoker(
    controllers.UserController.get(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "get",
      Seq(classOf[Integer]),
      "GET",
      """""",
      this.prefix + """api/test/get/$id<[^/]+>"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UserController_insertAll3_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/test/insertAll")))
  )
  private[this] lazy val controllers_UserController_insertAll3_invoker = createInvoker(
    controllers.UserController.insertAll(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "insertAll",
      Nil,
      "POST",
      """""",
      this.prefix + """api/test/insertAll"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UserController_insert4_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/test/insert")))
  )
  private[this] lazy val controllers_UserController_insert4_invoker = createInvoker(
    controllers.UserController.insert(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "insert",
      Nil,
      "POST",
      """""",
      this.prefix + """api/test/insert"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Assets_at5_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at5_invoker = createInvoker(
    controllers.Assets.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
      }
  
    // @LINE:8
    case controllers_UserController_getAll1_route(params) =>
      call { 
        controllers_UserController_getAll1_invoker.call(controllers.UserController.getAll)
      }
  
    // @LINE:9
    case controllers_UserController_get2_route(params) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_UserController_get2_invoker.call(controllers.UserController.get(id))
      }
  
    // @LINE:11
    case controllers_UserController_insertAll3_route(params) =>
      call { 
        controllers_UserController_insertAll3_invoker.call(controllers.UserController.insertAll())
      }
  
    // @LINE:12
    case controllers_UserController_insert4_route(params) =>
      call { 
        controllers_UserController_insert4_invoker.call(controllers.UserController.insert())
      }
  
    // @LINE:15
    case controllers_Assets_at5_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at5_invoker.call(controllers.Assets.at(path, file))
      }
  }
}