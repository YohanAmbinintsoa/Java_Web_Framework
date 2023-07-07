-The servletMapping in the web.xml must have a specific url part 
    e.g: /milay/*
    <servlet-mapping>
        <servlet-name>FrontServlet</servlet-name>
        <url-pattern>/milay/*</url-pattern>
    </servlet-mapping>

-The Model class has to have an empty parameters constructor

-All the methods in Model Class must return ModelView Class with the name or the path of the jsp

-The methods have to be annoted @Url(url="Your Url")

-You have to call the "addItem" method in order to add a request Attribute 

-Forms input name must match with attributes name in Model class

-Argument name must match the parameter name if you want it to be filled 

