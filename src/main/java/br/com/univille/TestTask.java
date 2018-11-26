package br.com.univille;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

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

            /***
            
            
            Task task = new Task();
            task.setDescription("new task created");
            Call<List<Task>> listAllTask = taskApi.();
                        Response<Task> responseCreateTask = 
            
            Task taskPost = new Task();
            taskPost.setDescription("Alô");
            Call<Task> callPost = taskApi.createTask(taskPost);
            Response<Task> rPost = callPost.execute();

            Task tPost = rPost.body();
            System.out.println(tPost);

            
            Task taskPut = new Task();
            taskPut.setDescription("Teste");
            Call<Void> callPut = taskApi.updateTask(62, taskPut);
            Response<Void> rPut = callPut.execute();
            if (rPut.isSuccessful()) {
                System.out.println("Updateou!");
            }


            
            Call<Void> callDelete = taskApi.deleteTask(63);
            Response<Void> rDelete = callDelete.execute();
            
            if (rDelete.isSuccessful()) {
                System.out.println("Se foi!");
            }

			***/

            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
