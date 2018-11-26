package br.com.univille;


import java.util.List;

import retrofit2.*;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TaskApi {

	
	@Headers("Student: 1111007744")
	@GET("tasks")
	Call<List<Task>> getAllTask();

    @Headers("Student: 1111007744")
    @GET("tasks/{id}")
    Call<Task> getOneTarefa(@Path("id") int id);

    @Headers("Student: 1111007744")
    @POST("tasks")
    Call<Task> setTask(@Body Task description);

    @Headers("Student: 1111007744")
    @PUT("tasks/{id}")
    Call<Void> updateTask
    (@Path("id") int id, @Body Task description);

    @Headers("Student: 1111007744")
    @DELETE("tasks/{id}")
    Call<Void> deleteTask(@Path("id") int id);

	
	
    
    /****
	@Headers("Student: 1111007744")
    @GET("tasks")
    Call<List<Task>> getTask();

    @Headers("Student: 1111007744")
    @GET("tasks/{id}")
    Call<Task> getTaskById(@Path("id") long id);

    @Headers("Student: 1111007744")
    @POST("tasks")
    Call<Task> createTask(@Body Task task);

    @Headers("Student: 1111007744")
    @PUT("tasks/{id}")
    Call<Void> updateTask(@Path("id") long id, @Body Task task);

    @Headers("Student: 1111007744")
    @DELETE("tasks/{id}")
    Call<Void> deleteTask(@Path("id") long id);
    ****/
}
