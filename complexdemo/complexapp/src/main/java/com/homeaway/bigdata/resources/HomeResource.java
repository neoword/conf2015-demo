/**
 *
 */
package com.homeaway.bigdata.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.homeaway.bigdata.core.Response;

/**
 * Home Page
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HomeResource {
    @GET
    public Response homePage() {
        return new Response(System.currentTimeMillis(), "<h1>Complex Demo</h1>\n<li><a href=\"admin/healthcheck\">healthcheck</a></li><li><a href=\"log\">spew log</a></li>");
    }
}
