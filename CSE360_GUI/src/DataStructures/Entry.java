package DataStructures;

import java.io.Serializable;

public class Entry implements Serializable {
	private ToDoList list;
	private String description;
	private int priority;
	private Date dueDate;
	private Progress progress;
	private static final long serialVersionUID = 2L;
	
	public Entry(ToDoList list) {
		description = "No description";
		priority = 0;
		dueDate = new Date();
		progress = new Progress();
		this.list = list;
	}
	
	public Entry(ToDoList list, String description, int priority) {
		this.description = description;
		this.priority = priority;
		this.list = list;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Progress getProgress() {
		return progress;
	}

	public void setProgress(Progress progress) {
		this.progress = progress;
	}
}
