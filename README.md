# springFrame
# tomcat config
--catalina.properties
shared.loader="${catalina.home}/webapps/springframe/WEB-INF/classes","${catalina.home}/mylibs","${catalina.home}/mylibs/*.jar"

--/mylibs
 add Myservice jar
 add Myservlet jar
 
--web.xml: add your servlet
<servlet-class>com.cch.servlet.MyBaseServlet</servlet-class>      
<load-on-startup>9</load-on-startup>


