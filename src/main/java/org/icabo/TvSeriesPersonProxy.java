package org.icabo;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.vertx.core.json.JsonArray;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/search")
@RegisterRestClient(baseUri = "https://api.tvmaze.com")
public interface TvSeriesPersonProxy {
    //https://api.tvmaze.com/search/people?q=lauren

    @GET
    @Path("/people")
    JsonArray getTvSeriesByPerson(@QueryParam("q") String personName);
}
