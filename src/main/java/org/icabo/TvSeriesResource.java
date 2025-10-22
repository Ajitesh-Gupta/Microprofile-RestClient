package org.icabo;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.vertx.core.json.JsonArray;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/tvseries")
public class TvSeriesResource {

    @Inject
    @RestClient
    TvSeriesIdProxy proxy;

    @GET
    @Fallback(fallbackMethod = "getTvSeriesByIdFallback")
    @Path("/{id}")
    public Response getTvSeriesById(@PathParam("id") int id) {
        return Response.ok(proxy.getTvSeriesById(id)).build();
    }

    public Response getTvSeriesByIdFallback(int id) {
        return Response.ok("Site is under maintenance").build();
    }

    @GET
    @Path("/person/{personName}")
    public JsonArray getTvSeriesByPersonName(@PathParam("personName") String personName) {
        return proxy.getTvSeriesByPersonName(personName);
    }
}
