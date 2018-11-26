# ListTaskApi
Atividade da  Disciplina de POO

## Class Task
```java

public class Task {
  
	private int id;
	private String description;
	private Boolean done;
	

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", done=" + done + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getDone() {
		return done;
	}
	public void setDone(Boolean done) {
		this.done = done;
	}

}


```
## Class TestTask
```java

public class TestTask {
    public static void main(String args[]) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-35-166-113-35.us-west-2.compute.amazonaws.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TaskApi taskApi = retrofit.create(TaskApi.class);

        try {
            
        	/* todas as tarefas*/
            Call<List<Task>> listAllTask = taskApi.getAllTask();
            Response<List<Task>> responseList = listAllTask.execute();
            List<Task> taskList = responseList.body();
            System.out.println("Todas as Tarefas: " + taskList);
		
		}catch(Exception e) {
            e.printStackTrace();
        }


```

## Class TaskApi
```java
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

}

```
