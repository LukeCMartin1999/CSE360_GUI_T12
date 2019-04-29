import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;


import DataStructures.Progress.Status;
import DataStructures.Date;
import DataStructures.Entry;
import DataStructures.ToDoList;

import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;


import org.eclipse.swt.widgets.Text;


public class itemChangesSettings {

	protected Shell shell;
	private Text descriptionChange;
	private Text priorityChange;
	private Text textMonth;
	private Text textDay;
	private Text textYear;
	private Label labelEnterNumber;
	private Label labelFormateDate;
	
	boolean isEntryDeleted = false;

	/**
	 * Open the window.
	 */
	
	public void open(ToDoList List, int entryIndex) {
		Display display = Display.getDefault();
		createContents(List, display, entryIndex);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */

	protected void createContents(ToDoList List, Display display, int entryIndex) {
		shell = new Shell();
		shell.setSize(600, 580);
		shell.setText("Change Item");

	    		
		Monitor primary = display.getPrimaryMonitor();
		 Rectangle bounds = primary.getBounds();
		 Rectangle rect = shell.getBounds();

		
		int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setLocation(x, y);
		
		Label lblEditItem = new Label(shell, SWT.NONE);
		lblEditItem.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));
		lblEditItem.setBounds(238, 10, 124, 27);
		lblEditItem.setText("Edit Item");
		
		Label lblChangeDescription = new Label(shell, SWT.NONE);
		lblChangeDescription.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		lblChangeDescription.setBounds(200, 71, 201, 25);
		lblChangeDescription.setText("Change Description");
		
		descriptionChange = new Text(shell, SWT.BORDER);
		descriptionChange.setBounds(231, 102, 137, 19);
		descriptionChange.setText(List.getEntry(entryIndex).getDescription());
		descriptionChange.setBounds(231, 102, 137, 26);
		
		Label lblChangePriority = new Label(shell, SWT.NONE);
		lblChangePriority.setText("Change Priority");
		lblChangePriority.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		lblChangePriority.setBounds(214, 138, 171, 25);
		
		priorityChange = new Text(shell, SWT.BORDER);
		priorityChange.setBounds(231, 169, 137, 19);
		priorityChange.setText(Integer.toString(List.getEntry(entryIndex).getPriority()));
		priorityChange.setBounds(231, 169, 137, 26);
		
		Label lblChangeDueDate = new Label(shell, SWT.NONE);
		lblChangeDueDate.setText("Change Due Date");
		lblChangeDueDate.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		lblChangeDueDate.setBounds(205, 211, 189, 25);
		
//		dueDateChange = new Text(shell, SWT.BORDER);
//		dueDateChange.setBounds(232, 242, 136, 19);
//		lblChangeDueDate.setBounds(235, 194, 129, 27);
		
		Button btnNotStarted = new Button(shell, SWT.RADIO);
		btnNotStarted.setFont(SWTResourceManager.getFont("Arial", 8, SWT.NORMAL));
		btnNotStarted.setBounds(244, 330, 103, 21);
		btnNotStarted.setSelection(true);
		btnNotStarted.setText("Not Started");
		
		Label lblChangeStatus = new Label(shell, SWT.NONE);
		lblChangeStatus.setText("Change Status");
		lblChangeStatus.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		lblChangeStatus.setBounds(205, 299, 189, 25);
		
		Button btnFinished = new Button(shell, SWT.RADIO);
		btnFinished.setText("Finished");
		btnFinished.setFont(SWTResourceManager.getFont("Arial", 8, SWT.NORMAL));
		btnFinished.setBounds(244, 384, 103, 21);
		
		Button btnInProgress = new Button(shell, SWT.RADIO);
		btnInProgress.setText("In Progress");
		btnInProgress.setFont(SWTResourceManager.getFont("Arial", 8, SWT.NORMAL));
		btnInProgress.setBounds(244, 357, 103, 21);
		
		Button buttonExit = new Button(shell, SWT.NONE);
		buttonExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				mainMenu mainMenuPanel = new mainMenu();
				mainMenuPanel.open(List);
			}
		});
		buttonExit.setText("Exit");
		buttonExit.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		buttonExit.setBounds(238, 464, 124, 34);
		
		Button buttonChange = new Button(shell, SWT.NONE);
		buttonChange.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				boolean uniqueDescription = true;
				boolean priorityNumber = true;
				boolean dayIsNum = true;
				boolean monthIsNum = true;
				boolean yearIsNum = true;
				
				String description = descriptionChange.getText();
				String priority =  priorityChange.getText();
				String month = textMonth.getText();
				String day = textDay.getText();
				String year = textYear.getText();
				
				dayIsNum = List.isDateNumber(day);
				monthIsNum = List.isDateNumber(month);
				yearIsNum = List.isDateNumber(year);
				
				priorityNumber = List.isPriorityNumber(priority);
	
				if(priorityNumber == false)
				{
					labelEnterNumber = new Label(shell, SWT.NONE);
					labelEnterNumber.setAlignment(SWT.CENTER);
					labelEnterNumber.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelEnterNumber.setBounds(180, 50, 240, 19);
					labelEnterNumber.setText("Please Enter a Number for Priority");
				}
				
				if((dayIsNum && monthIsNum && yearIsNum) == false)
				{
					labelFormateDate = new Label(shell, SWT.NONE);
					labelFormateDate.setAlignment(SWT.CENTER);
					labelFormateDate.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelFormateDate.setBounds(148, 33, 304, 18);
					labelFormateDate.setText("Enter Date as MM/DD/YY Example: 04/14/99");
					
					return;
				}
				
				if(uniqueDescription == false)
				{
					Label labelUniqueDescription = new Label(shell, SWT.NONE);
					labelUniqueDescription.setAlignment(SWT.CENTER);
					labelUniqueDescription.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelUniqueDescription.setBounds(207, 25, 186, 14);
					labelUniqueDescription.setText("Please Enter Unique Description");
					
					return;
				}
				if(priorityNumber == false || (dayIsNum && monthIsNum && yearIsNum) == false)
				{
					return;
				}
				if(!isEntryDeleted)
				{
					List.deleteEntry(entryIndex);
					isEntryDeleted = true;
				}
				uniqueDescription = List.isDecriptionUnique(description);

				if(uniqueDescription == false)
				{
					Label labelUniqueDescription = new Label(shell, SWT.NONE);
					labelUniqueDescription.setAlignment(SWT.CENTER);
					labelUniqueDescription.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelUniqueDescription.setBounds(207, 25, 186, 14);
					labelUniqueDescription.setText("Please Enter Unique Description");
					
					return;
				}
				
				int numPriority = Integer.parseInt(priority);
				int numMonth = Integer.parseInt(month);
				int numDay = Integer.parseInt(day);
				int numYear = Integer.parseInt(year);
				
				Entry newEntry = new Entry();
				newEntry.setDescription(description);
				newEntry.setPriority(numPriority);
			
				Date date = new Date();
				date.setYear(numYear);
				date.setMonth(numMonth);
				date.setDay(numDay);
				
				if(btnNotStarted.getSelection())
				{
					newEntry.setStatus(Status.NOT_STARTED);
				}
				else if(btnFinished.getSelection())
				{
					newEntry.setStatus(Status.FINISHED);
				}
				else if(btnInProgress.getSelection())
				{
					newEntry.setStatus(Status.IN_PROGRESS);
				}
				
				newEntry.setDueDate(date);
				
				List.addEntry(newEntry);
				
				shell.dispose();
				mainMenu mainMenuPanel = new mainMenu();
				mainMenuPanel.open(List);
			}
		});
		buttonChange.setText("Change");
		buttonChange.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonChange.setBounds(238, 424, 124, 34);
		
		textMonth = new Text(shell, SWT.BORDER);
		textMonth.setText(Integer.toString(List.getEntry(entryIndex).getDueDate().getMonth()));
		textMonth.setBounds(207, 264, 50, 26);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("Month");
		label_1.setFont(SWTResourceManager.getFont("Arial", 8, SWT.NORMAL));
		label_1.setBounds(212, 240, 50, 21);
		
		textDay = new Text(shell, SWT.BORDER);
		textDay.setText(Integer.toString(List.getEntry(entryIndex).getDueDate().getDay()));
		textDay.setBounds(268, 264, 50, 26);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("Day");
		label_2.setFont(SWTResourceManager.getFont("Arial", 8, SWT.NORMAL));
		label_2.setBounds(278, 240, 30, 21);
		
		textYear = new Text(shell, SWT.BORDER);
		textYear.setText(Integer.toString(List.getEntry(entryIndex).getDueDate().getYear()));
		textYear.setBounds(331, 264, 50, 26);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("Year");
		label_3.setFont(SWTResourceManager.getFont("Arial", 8, SWT.NORMAL));
		label_3.setBounds(339, 240, 30, 21);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("/");
		label_4.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));
		label_4.setBounds(259, 263, 8, 21);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("/");
		label_5.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));
		label_5.setBounds(320, 263, 15, 21);
	}
}
