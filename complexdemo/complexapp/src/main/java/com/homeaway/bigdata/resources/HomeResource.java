/**
 *
 */
package com.homeaway.bigdata.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Home Page
 */
@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HomeResource {
    @GET
    public String homePage() {
        return "<h1>Complex Demo</h1>\n<li><a href=\"admin/healthcheck\">healthcheck</a></li><li><a href=\"log\">spew log</a></li>";
    }
}
