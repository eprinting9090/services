
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/Project/eprinting-service/services/conf/routes
// @DATE:Sun May 12 06:16:18 ICT 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
