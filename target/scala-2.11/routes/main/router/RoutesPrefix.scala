
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/Skripsi/conf/routes
// @DATE:Sat May 11 22:40:59 ICT 2019


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
