package DataStructures;

import java.io.Serializable;

import DataStructures.Progress.Status;

public class Entry implements Serializable {
	private String description;
	private int priority;
	private Date dueDate;
	private Progress progress;
	private ToDoList list;
	private static final long serialVersionUID = 2L;
	
	public Entry() {
		description = "No description";
		priority = 0;
		dueDate = new Date();
		progress = new Progress();
	}
	
	public Entry(String description, int priority) {
		this.description = description;
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (list != null) {
			if (this.description == null) this.description = "";
			list.log("Description changed from \"" + this.description 
					+ "\" to \"" + description + "\"");
		}
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		if (list != null) {
			list.log("Priority changed from \"" + this.priority 
					+ "\" to \"" + priority + "\"");	
		}
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		if (list != null) {
			list.log("Priority " + priority + " due date changed");	
		}
		this.dueDate = dueDate;
	}

	public Progress getProgress() {
		return progress;
	}

	public void setStatus(Status status) {
		if (list != null) {
			list.log("Priority " + priority + " status changed from \"" + statusAsString(getProgress().getStatus()) 
					+ "\" to \"" + statusAsString(status));	
		}
		this.progress.setStatus(status);
	}
	
	private static String statusAsString(Status status) {
		switch(status) {
		case NOT_STARTED:
			return "NOT_STARTED";
		case IN_PROGRESS:
			return "IN_PROGRESS";
		case FINISHED:
			return "FINISHED";
		default:
			return "NOT_STARTED";	
		}
	}

	public void setList(ToDoList list) {
		this.list = list;
	}
}
