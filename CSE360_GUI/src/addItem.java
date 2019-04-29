import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import DataStructures.Date;
import DataStructures.Entry;
import DataStructures.ToDoList;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;

public class addItem {

	protected Shell shell;
	private Text textItemDescription;
	private Label lblPriority;
	private Text textPriority;
	private Label labelDuDate;
	private Text textMonth;
	private Label labelMonth;
	private Text textDay;
	private Label labelDay;
	private Text textYear;
	private Label labelYear;
	private Label labelSlash1;
	private Label labelSlaph2;
	private Label labelEnterNumber;
	private Label labelFormateDate;

	/**
	 * Launch the application.
	 * @param args
	 */

	/**
	 * Open the window.
	 */
	public void open(ToDoList List) {
		Display display = Display.getDefault();
		createContents(List, display);
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
	protected void createContents(ToDoList List, Display display) {
		shell = new Shell();
		shell.setSize(600, 500);
		shell.setText("SWT Application");
		shell.setText("Add Item");
		
		 Monitor primary = display.getPrimaryMonitor();
		 Rectangle bounds = primary.getBounds();
		 Rectangle rect = shell.getBounds();

		
		int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    

	    shell.setLocation(x, y);
		
		
	    
	    shell.setLocation(x, y);
		
		Label lblAddItem = new Label(shell, SWT.NONE);
		lblAddItem.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblAddItem.setBounds(243, 10, 140, 30);
		lblAddItem.setText("Add Item");
		
		Label lblItemDescription = new Label(shell, SWT.NONE);
		lblItemDescription.setText("Item Description");
		lblItemDescription.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblItemDescription.setBounds(232, 55, 200, 26);
		
		textItemDescription = new Text(shell, SWT.BORDER);
		textItemDescription.setBounds(243, 82, 114, 27);
		
		lblPriority = new Label(shell, SWT.NONE);
		lblPriority.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblPriority.setBounds(265, 136, 90, 21);
		lblPriority.setText("Priority");
		
		textPriority = new Text(shell, SWT.BORDER);
		textPriority.setBounds(243, 163, 114, 27);
		
		labelDuDate = new Label(shell, SWT.NONE);
		labelDuDate.setText("Due Date");
		labelDuDate.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		labelDuDate.setBounds(257, 229, 120, 21);
		
		textMonth = new Text(shell, SWT.BORDER);
		textMonth.setBounds(214, 284, 50, 27);
		
		Button buttonExit = new Button(shell, SWT.NONE);
		buttonExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				shell.dispose();
				mainMenu mainMenuPanel = new mainMenu();
				mainMenuPanel.open(List);
				
			}
		});
		buttonExit.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		buttonExit.setBounds(241, 389, 118, 34);
		buttonExit.setText("Exit");
		
		Button buttonAdd = new Button(shell, SWT.NONE);
		buttonAdd.setText("Add");
		buttonAdd.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonAdd.setBounds(241, 341, 118, 34);
		
		labelMonth = new Label(shell, SWT.NONE);
		labelMonth.setText("Month");
		labelMonth.setFont(SWTResourceManager.getFont("Arial", 8, SWT.NORMAL));
		labelMonth.setBounds(219, 260, 50, 21);
		
		textDay = new Text(shell, SWT.BORDER);

		textDay.setBounds(275, 284, 50, 19);

		textDay.setBounds(275, 284, 50, 27);
		
		labelDay = new Label(shell, SWT.NONE);
		labelDay.setText("Day");
		labelDay.setFont(SWTResourceManager.getFont("Arial", 8, SWT.NORMAL));
		labelDay.setBounds(285, 260, 30, 21);
		
		textYear = new Text(shell, SWT.BORDER);

		textYear.setBounds(338, 284, 50, 19);

		textYear.setBounds(338, 284, 50, 27);

		
		labelYear = new Label(shell, SWT.NONE);
		labelYear.setText("Year");
		labelYear.setFont(SWTResourceManager.getFont("Arial", 8, SWT.NORMAL));
		labelYear.setBounds(346, 260, 30, 21);
		
		labelSlash1 = new Label(shell, SWT.NONE);
		labelSlash1.setText("/");
		labelSlash1.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));
		labelSlash1.setBounds(266, 283, 8, 21);
		
		labelSlaph2 = new Label(shell, SWT.NONE);
		labelSlaph2.setText("/");
		labelSlaph2.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));
		labelSlaph2.setBounds(327, 283, 15, 21);


		
		
		
		
		buttonAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean uniqueDescription = true;
				boolean priorityNumber = true;
				boolean dayIsNum = true;
				boolean monthIsNum = true;
				boolean yearIsNum = true;

				
				

				String description = textItemDescription.getText();
				String priority =  textPriority.getText();
				String month = textMonth.getText();
				String day = textDay.getText();
				String year = textYear.getText();
				
				

				//String dueDate = textDueDate.getText();

				
				dayIsNum = List.isDateNumber(day);
				monthIsNum = List.isDateNumber(month);
				yearIsNum = List.isDateNumber(year);
				
				uniqueDescription = List.isDecriptionUnique(description);
				priorityNumber = List.isPriorityNumber(priority);
				
				if(uniqueDescription == false)
				{
					Label labelUniqueDescription = new Label(shell, SWT.NONE);
					labelUniqueDescription.setAlignment(SWT.CENTER);
					labelUniqueDescription.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelUniqueDescription.setBounds(173, 106, 246, 19);
					labelUniqueDescription.setText("Please Enter Unique Description");
					
				}
				if(priorityNumber == false)
				{
					labelEnterNumber = new Label(shell, SWT.NONE);
					labelEnterNumber.setAlignment(SWT.CENTER);
					labelEnterNumber.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelEnterNumber.setBounds(210, 187, 180, 20);
					labelEnterNumber.setText("Please Enter a Number");

				}
				
				if((dayIsNum && monthIsNum && yearIsNum) == false)
				{
					labelFormateDate = new Label(shell, SWT.NONE);
					labelFormateDate.setAlignment(SWT.CENTER);
					labelFormateDate.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelFormateDate.setBounds(148, 309, 304, 20);
					labelFormateDate.setText("Enter Date as MM/DD/YY Example: 04/14/99");
					return;
				}
				
				if(uniqueDescription == false || priorityNumber == false || (dayIsNum && monthIsNum && yearIsNum) == false)
				{
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
				

				newEntry.setDueDate(date);
				

				List.addEntry(newEntry);
				
				shell.dispose();
				mainMenu mainMenuPanel = new mainMenu();
				mainMenuPanel.open(List);
				
			}
		});

	}
   
  }

