import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import DataStructures.ToDoList;;



public class mainMenu {

	 
	protected Shell shlTodoList;
	
	
	public static void main(String[] args) {
		 ToDoList ToDoListTest = new ToDoList();
		try {
			mainMenu window = new mainMenu();
			window.open(ToDoListTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	/**
	 * Open the window.
	 */
	public void open(ToDoList List) {
		Display display = Display.getDefault();
		createContents(List, display);
		shlTodoList.open();
		shlTodoList.layout();
		while (!shlTodoList.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(ToDoList ToDoListTest, Display display) {
		
		
		
		shlTodoList = new Shell();
		shlTodoList.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlTodoList.setSize(600, 600);
		shlTodoList.setText("To-Do List");
		
		 Monitor primary = display.getPrimaryMonitor();
		 Rectangle bounds = primary.getBounds();
		 Rectangle rect = shlTodoList.getBounds();

		
		int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    


	    shlTodoList.setLocation(x, y);

		//shlTodoList.setLocation(null);
		
		Label lblToDoList = new Label(shlTodoList, SWT.NONE);
		lblToDoList.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblToDoList.setBounds(248, 38, 99, 31);
		lblToDoList.setText("To Do List");
		
		Button buttonRemoveItem = new Button(shlTodoList, SWT.NONE);
		buttonRemoveItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlTodoList.dispose();
				removeItem removeItemPanel = new removeItem();
				removeItemPanel.open(ToDoListTest);
			}
		});
		buttonRemoveItem.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		buttonRemoveItem.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonRemoveItem.setBounds(195, 188, 210, 40);
		buttonRemoveItem.setText("Remove Item from List ");
		
		Button buttonAddItem = new Button(shlTodoList, SWT.NONE);
		buttonAddItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlTodoList.dispose();
				addItem addItemPanel = new addItem();
				addItemPanel.open(ToDoListTest);
			}
		});
		buttonAddItem.setText("Add Item to List");
		buttonAddItem.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonAddItem.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		buttonAddItem.setBounds(195, 96, 210, 40);
		
		Button buttonDisplayList = new Button(shlTodoList, SWT.NONE);
		buttonDisplayList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlTodoList.dispose();
				displayList displayListPanel = new displayList();
				displayListPanel.open(ToDoListTest);
			} 
		});
		buttonDisplayList.setText("Display List");
		buttonDisplayList.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonDisplayList.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		buttonDisplayList.setBounds(195, 142, 210, 40);
		
		Button buttonChangeItem = new Button(shlTodoList, SWT.NONE);
		buttonChangeItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlTodoList.dispose();
				changeItem changeItemPanel = new changeItem();
				changeItemPanel.open(ToDoListTest);
			}
		});
		buttonChangeItem.setText("Change Item on List");
		buttonChangeItem.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonChangeItem.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		buttonChangeItem.setBounds(195, 234, 210, 40);
		
		Button buttonRestoreList = new Button(shlTodoList, SWT.NONE);
		buttonRestoreList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ToDoList loaded = null;
				try {
					loaded = ToDoList.load();
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (loaded != null) {
					ToDoListTest.become(loaded);
				}
			}
		});
		buttonRestoreList.setText("Restore Previous List");
		buttonRestoreList.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonRestoreList.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		buttonRestoreList.setBounds(195, 280, 210, 40);
		
		Button buttonSaveCurrentList = new Button(shlTodoList, SWT.NONE);
		buttonSaveCurrentList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					ToDoList.save(ToDoListTest);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		buttonSaveCurrentList.setText("Save Current List");
		buttonSaveCurrentList.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonSaveCurrentList.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		buttonSaveCurrentList.setBounds(195, 326, 210, 40);
		
		Button buttonQuitApp = new Button(shlTodoList, SWT.NONE);
		buttonQuitApp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		buttonQuitApp.setText("Quit Application");
		buttonQuitApp.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		buttonQuitApp.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		buttonQuitApp.setBounds(195, 474, 210, 40);
		
		Button buttonPrintLog = new Button(shlTodoList, SWT.NONE);
		buttonPrintLog.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ToDoListTest.printLog();
			}
		});
		buttonPrintLog.setText("Print List History");
		buttonPrintLog.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonPrintLog.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		buttonPrintLog.setBounds(195, 372, 210, 40);
		
		Button btnStartOver = new Button(shlTodoList, SWT.NONE);
		btnStartOver.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ToDoListTest.startOver();
			}
		});
		btnStartOver.setText("Start Over");
		btnStartOver.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnStartOver.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		btnStartOver.setBounds(195, 418, 210, 40);

	}
}
