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
	private final static String SAVE_FILE_DIR = "ToDoSave.dat";
	private static final long serialVersionUID = 1L;
	private String textwriter;
	
	public ToDoList() {
		entries = new ArrayList<Entry>();
		sort = Sort.PRIORITY;
	}
	
	public static void save(ToDoList list) throws FileNotFoundException, IOException {
		File file = new File(SAVE_FILE_DIR);
		ObjectOutputStream out = null;
		try {
			System.out.println("Here Save");
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
			System.out.println("Here Load");
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
		entries.add(newEntry);
		ensureUniquePriorities();
		sortEntries();
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
		
		String textwriter = currentEntry;
		fileWriter = new FileWriter(file);
		fileWriter.write(textwriter);
		fileWriter.close();
	}
	
	public void deleteEntry(int index) {
		entries.remove(index);
		sortEntries();
		
		String textwriter = deleteEntry;
		fileWriter = new FileWriter(file);
		fileWriter.write(textwriter);
		fileWriter.close();
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
		this.sort = sort;
		sortEntries();
		
		String textwriter = setSort;
		fileWriter = new FileWriter(file);
		fileWriter.write(textwriter);
		fileWriter.close();
	}
	
	public void startOver() {
		entries = new ArrayList<Entry>();
		sort = Sort.PRIORITY;
		
		String textwriter = startOver;
		fileWriter = new FileWriter(file);
		fileWriter.write(textwriter);
		fileWriter.close();
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
				System.out.println("Due Dare Comp");
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


