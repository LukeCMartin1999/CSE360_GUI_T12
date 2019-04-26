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
		shlTodoList.setSize(600, 550);
		shlTodoList.setText("To-Do List");
		
		 Monitor primary = display.getPrimaryMonitor();
		 Rectangle bounds = primary.getBounds();
		 Rectangle rect = shlTodoList.getBounds();

		
		int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    


	    shlTodoList.setLocation(x, y);

		//shlTodoList.setLocation(null);
		
		Label lblNewLabel = new Label(shlTodoList, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));
		lblNewLabel.setBounds(225, 23, 150, 28);
		lblNewLabel.setText("Welcome to Your");
		
		Label lblToDoList = new Label(shlTodoList, SWT.NONE);
		lblToDoList.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));
		lblToDoList.setBounds(253, 48, 94, 21);
		lblToDoList.setText("To Do List ");
		
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
		buttonRemoveItem.setBounds(215, 188, 170, 40);
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
		buttonAddItem.setText("Add Item to List ");
		buttonAddItem.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonAddItem.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		buttonAddItem.setBounds(215, 96, 169, 40);
		
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
		buttonDisplayList.setBounds(215, 142, 170, 40);
		
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
		buttonChangeItem.setBounds(215, 234, 170, 40);
		
		Button buttonRestoreList = new Button(shlTodoList, SWT.NONE);
		buttonRestoreList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					
					 ToDoListTest.become(ToDoList.load());
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonRestoreList.setText("Restore Previous List");
		buttonRestoreList.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonRestoreList.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		buttonRestoreList.setBounds(215, 280, 170, 40);
		
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
		buttonSaveCurrentList.setBounds(215, 326, 170, 40);
		
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
		buttonQuitApp.setBounds(215, 372, 170, 40);
		buttonQuitApp.setBounds(215, 418, 170, 40);
		
		Button buttonPrintLog = new Button(shlTodoList, SWT.NONE);
		buttonPrintLog.setText("Print List History");
		buttonPrintLog.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonPrintLog.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		buttonPrintLog.setBounds(215, 372, 170, 40);
		
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
		btnStartOver.setBounds(216, 464, 167, 40);

	}
}
