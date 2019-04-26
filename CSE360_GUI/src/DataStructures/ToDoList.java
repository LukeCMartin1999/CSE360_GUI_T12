package DataStructures;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import DataStructures.Progress.Status;

public class ToDoList implements Serializable {
	public enum Sort { DESC, PRIORITY, DUE_DATE, STATUS };
	
	private List<Entry> entries;
	private Sort sort;
	private StringBuilder logBuilder;
	private final static String SAVE_FILE_DIR = "ToDoSave.dat";
	private static final long serialVersionUID = 1L;
	
	public ToDoList() {
		entries = new ArrayList<Entry>();
		sort = Sort.PRIORITY;
		logBuilder = new StringBuilder();
		log("List created");
	}
	
	public void become(ToDoList other) {
		this.startOver();
		if (other.entries != null) {
			this.entries = other.entries;
		}
		else {
			this.entries = new ArrayList<Entry>();
		}
		this.sort = other.sort;
		if (other.logBuilder != null) {
			this.logBuilder = other.logBuilder;
		}
		else {
			this.logBuilder = new StringBuilder("");
		}
	}
	
	public static void save(ToDoList list) throws FileNotFoundException, IOException {
		File file = new File(SAVE_FILE_DIR);
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(list);
		}
		finally {
			if (out != null) out.close();
		}
	}

	public static ToDoList load() throws ClassNotFoundException, IOException {
		File file = new File(SAVE_FILE_DIR);
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(file));
			return (ToDoList) in.readObject();
		}
		finally {
			if (in != null) in.close();
		}
	}
	
	public List<Entry> getEntries() {
		removeFinishedEntries();
		return entries;
	}

	public void addEntry(Entry newEntry) {
		if (newEntry.getDescription() != null) {
			log("Added entry: " + newEntry.getDescription());
		}
		entries.add(newEntry);
		ensureUniquePriorities();
		sortEntries();
		newEntry.setList(this);
	}

	private void ensureUniquePriorities() {
		sortEntries(Sort.PRIORITY);
		for (int i = 0; i < entries.size() - 1; i++) {
			Entry entry = entries.get(i);
			Entry next = entries.get(i + 1);
			if (entry.getPriority() == next.getPriority()) {
				next.setPriority(entry.getPriority() + 1);
			}
		}
	}

	public void removeEntryByIndex(int index) {
		log("Removed entry: " + entries.get(index).getDescription());
		entries.remove(index);
	}
	
	public void removeEntryByPriority(int priority) {
		int index = -1;
		for (int i = 0; i < entries.size(); i++) {
			if (entries.get(i).getPriority() == priority) {
				index = i;
				break;
			}
		}
		
		if (index > -1) removeEntryByIndex(index);
	}
	
	public Sort getSort() {
		return sort;
	}
	
	public Entry getEntry(int index)
	{
		Entry currentEntry;
		currentEntry = entries.get(index);
		return currentEntry;
	}
	
	public void deleteEntry(int index) {
		log("Removed entry: " + entries.get(index).getDescription());
		entries.remove(index);
		sortEntries();
	}
	
	public boolean isDateNumber(String date) {
		boolean isNumber;
		isNumber = date.matches("-?\\d+(\\.\\d+)?");
		if(isNumber && date.length() == 2) {
			isNumber = true;
			return isNumber;
		}
		else {
			isNumber = false;
			return isNumber;
		}
		
	}
	
	public boolean isPriorityNumber(String priority) {
		boolean isNumber;
		isNumber = priority.matches("-?\\d+(\\.\\d+)?");
		return isNumber;
		
	}
	
	public boolean isDecriptionUnique(String description) {
		boolean isUnique;
		for (Entry entry : entries) {
			String currentDecription = entry.getDescription();
			if(description.equals(currentDecription)) {
				isUnique = false;
				return isUnique;
			}
		}	
		
		isUnique = true;
		return isUnique;
		
	}

	public void setSort(Sort sort) {
		log("Sort criteria changed");
		this.sort = sort;
		sortEntries();
	}
	
	public void startOver() {
		log("List reset");
		entries = new ArrayList<Entry>();
		sort = Sort.PRIORITY;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("");
		for (Entry entry : entries) {
			builder.append("Priority ").append(entry.getPriority()).append(": \n");
			builder.append("\tDesc: ").append(entry.getDescription()).append("\n");
			builder.append("\tDue: ").append(entry.getDueDate().getYear()).append("-")
				.append(entry.getDueDate().getMonth()).append("-")
				.append(entry.getDueDate().getDay()).append("\n");
			// TODO
			builder.append("\tProgress: not implemented\n");
		}
		
		return builder.toString();
	}

	public void printLog() {
		PrintWriter out = null;
		try {
			out = new PrintWriter("log.txt");
			out.print(logBuilder.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) out.close();
		}
	}
	
	public void log(String str) {
		Date current = new Date();
		logBuilder.append(current.getYear()).append("-")
		.append(current.getMonth()).append("-")
		.append(current.getDay()).append(": ")
		.append(str).append("\n");
	}
	
	private void sortEntries() {
		Collections.sort(entries, new EntryComparator());
	}
	
	private void sortEntries(Sort _sort) {
		Collections.sort(entries, new EntryComparator(_sort));
	}
	
	private void removeFinishedEntries() {
		for (int i = 0; i < entries.size(); i++) {
			if (entries.get(i).getProgress().getStatus() == Status.FINISHED) {
				removeEntryByPriority(entries.get(i).getPriority());
			}
		}
	}
	
	private class EntryComparator implements Comparator<Entry> {
		Sort sortSort;
		
		public EntryComparator() {
			sortSort = sort;
		}
		
		public EntryComparator(Sort _sort) {
			sortSort = _sort;
		}
		
		@Override
		public int compare(Entry first, Entry second) {
			switch (sortSort) {
			case DESC:
				return first.getDescription().compareTo(second.getDescription());
			case PRIORITY:
				return first.getPriority() - second.getPriority();
			case DUE_DATE:
				return first.getDueDate().compareTo(second.getDueDate());
			case STATUS:
				if (first.getProgress().getStatus() == second.getProgress().getStatus()) return 0;
				
				if (first.getProgress().getStatus() == Progress.Status.NOT_STARTED) return -1;
				if (second.getProgress().getStatus() == Progress.Status.FINISHED) return -1;
				
				return 1;
			default:
				return first.getPriority() - second.getPriority();
			
			}
		}
	}






}


