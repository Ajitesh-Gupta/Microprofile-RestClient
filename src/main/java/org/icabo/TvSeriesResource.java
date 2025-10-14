package org.icabo;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.vertx.core.json.JsonArray;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/tvseries")
public class TvSeriesResource {

    @Inject
    @RestClient
    TvSeriesIdProxy proxy;

    @GET
    @Path("/{id}")
    public TvSeries getTvSeriesById(@PathParam("id") int id) {
        return proxy.getTvSeriesById(id);
    }

    @GET
    @Path("/person/{personName}")
    public JsonArray getTvSeriesByPersonName(@PathParam("personName") String personName) {
        return proxy.getTvSeriesByPersonName(personName);
    }
}
