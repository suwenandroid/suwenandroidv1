package com.suwen.suwenandroid2016v1.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.suwen.suwenandroid2016v1.rest.services.ApiService;

import java.io.IOException;

import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.GzipSink;
import okio.Okio;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by  niuhongbin on 04/18/2016
 * Client Rest
 */
public class RestClient {
    public static final String BASE_URL = "http://app.vmoiver.com/apiv3";
    private static ApiService apiService;

    /**
     *  静态代码块调用构建一个请求适配器
     */
    static {
        setupRestClient();
    }

    /**
     * Constructor
     */
    private RestClient() {
    }


    private static void setupRestClient() {
        //实例化gson
        Gson gson = new GsonBuilder()
                .create();
        //实例化okhttp
        OkHttpClient client = new OkHttpClient();
        OkClient okclient = new OkClient(client);
        //设置okhttp的拦截器，可以在请求头中添加相应的数据
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
               // request.addHeader("api-version", "3.0");
                request.addHeader("user-agent", "Android " + "MX5" + " " + "5.1");
            }
        };
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setClient(okclient)
                .setLog(new AndroidLog("Retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                        //设置失败处理的策略
                .setErrorHandler(new CustomErrorHandler())
                        //设置拦截器策略
                .setRequestInterceptor(requestInterceptor)
                .build();

        apiService = restAdapter.create(ApiService.class);

    }

    /**
     * @return apiService
     */
    public static ApiService getApiService() {
        return apiService;
    }
}

/**
 * GZIP请求，在项目中没用到，需要服务器支持，可以减小json的体积
 */
final class GzipRequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        if (originalRequest.body() == null || originalRequest.header("Content-Encoding") != null) {
            return chain.proceed(originalRequest);
        }

        Request compressedRequest = originalRequest.newBuilder()
                .header("Content-Encoding", "gzip")
                .method(originalRequest.method(), requestBodyWithContentLength(gzip(originalRequest.body())))
                .build();
        Response response = chain.proceed(compressedRequest);
        return chain.proceed(compressedRequest);
    }

    private RequestBody gzip(final RequestBody body) {
        return new RequestBody() {
            @Override
            public MediaType contentType() {
                return body.contentType();
            }

            @Override
            public long contentLength() {
                return 0;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                BufferedSink gzipSink = Okio.buffer(new GzipSink(sink));
                body.writeTo(gzipSink);
                gzipSink.close();
            }
        };
    }

    private RequestBody requestBodyWithContentLength(final RequestBody requestBody) throws IOException {
        final Buffer buffer = new Buffer();
        try {
            requestBody.writeTo(buffer);
        } catch (IOException e) {
            throw new IOException("Unable to copy RequestBody");
        }
        return new RequestBody() {
            @Override
            public MediaType contentType() {
                return requestBody.contentType();
            }

            @Override
            public long contentLength() {
                return buffer.size();
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                sink.write(ByteString.read(buffer.inputStream(), (int) buffer.size()));
            }
        };
    }
}