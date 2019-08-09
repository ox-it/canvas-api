package edu.ksu.canvas.impl;

import com.google.gson.reflect.TypeToken;
import edu.ksu.canvas.interfaces.ProgressReader;
import edu.ksu.canvas.interfaces.ProgressWriter;
import edu.ksu.canvas.model.Progress;

import edu.ksu.canvas.net.Response;
import edu.ksu.canvas.net.RestClient;
import edu.ksu.canvas.oauth.OauthToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import org.apache.log4j.Logger;

public class ProgressImpl extends BaseImpl<Progress, ProgressReader, ProgressWriter> implements ProgressReader, ProgressWriter {

    private static final Logger LOG = Logger.getLogger(ProgressImpl.class);

    public ProgressImpl(String canvasBaseUrl, Integer apiVersion, OauthToken oauthToken, RestClient restClient,
                                int connectTimeout, int readTimeout, Integer paginationPageSize, Boolean serializeNulls) {
        super(canvasBaseUrl, apiVersion, oauthToken, restClient, connectTimeout, readTimeout,
                paginationPageSize, serializeNulls);
    }

    @Override
    public Optional<Progress> getProgress(String url) throws IOException {
        LOG.info("getting the progress of an asynchronous API operation with url " + url);
        Response response = canvasMessenger.getSingleResponseFromCanvas(oauthToken, url);
        return responseParser.parseToObject(Progress.class, response);
    }

    @Override
    protected Type listType() {
        return new TypeToken<Progress>(){}.getType();
    }

    @Override
    protected Class<Progress> objectType() {
        return Progress.class;
    }
}
