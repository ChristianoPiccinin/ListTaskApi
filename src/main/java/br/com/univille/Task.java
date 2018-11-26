package br.com.univille;

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
