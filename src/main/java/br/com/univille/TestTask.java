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
            
        	/*** Todas as tarefas ***/
            Call<List<Task>> listAllTask = taskApi.getAllTask();
            Response<List<Task>> responseList = listAllTask.execute();
            List<Task> taskList = responseList.body();
            System.out.println("========= Todas as Tarefas ========= \n" + taskList);
            System.out.println("====================================");

            
            
            
            
            /*** Criar tarefa ***/
            
            Task newTask = new Task();
            newTask.setDescription(" nova tarefa está sendo criada");
            Call<Task> createTask = taskApi.setTask(newTask);
            Response<Task> responeNewTask = createTask.execute();
            Task taskCreated = responeNewTask.body();
            responeNewTask.isSuccessful();
            Call<Task> retundIdTask = taskApi.getOneTask(taskCreated.getId());
            Response<Task> responseIdTask = retundIdTask.execute();
            Task taskId = responseIdTask.body();
            System.out.println("======== Tarefa Criada ========"); 
            System.out.println(taskId + "\n");
            
            
            /*** Pegar tarefa especifica - tarefa 1441 ***/
            Call<Task> returnGetById = taskApi.getOneTask(1441);
            Response<Task> reponseGetById = returnGetById.execute();
            Task taskGetById = reponseGetById.body();
            System.out.println("========= Tarefa escolhida ==========");
            System.out.println(taskGetById);
            
            
            /*** Editar uma tarefa ***/
            Task editTask = new Task();
            editTask.setId(1440);
            editTask.setDescription("Task edited by Chrsitiano lindo");
            editTask.setDone(true);
            Call<Void> editTask2 = taskApi.updateTask(editTask.getId(), editTask);
            Response<Void> responseEdit = editTask2.execute();
            responseEdit.isSuccessful();
            
            if (responseEdit.isSuccessful()) {
            	System.out.println("========= Tarefa Editada =======");
            	Call<Task> returnEditedTask = taskApi.getOneTask(editTask.getId());
            	Response<Task> responseEditedTask = returnEditedTask.execute();
            	Task editedTasks = responseEditedTask.body();
            	System.out.println(editedTasks);
            }
            
                        
            /*** Deletar tarefa ***/
            int id =1445 ;
            Call<Void> deleteTask = taskApi.deleteTask(1445); 
            Response<Void> responseDelTask = deleteTask.execute();
            responseDelTask.isSuccessful();
            if (responseDelTask.isSuccessful()) {
                System.out.println(" ======== Tarefa Deletada ======= ");
                System.out.println(id);
            }
            
            
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
