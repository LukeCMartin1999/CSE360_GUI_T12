import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import DataStructures.Date;
import DataStructures.Entry;
import DataStructures.ToDoList;

import DataStructures.Progress;
import DataStructures.Progress.Status;

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
		
		
	    
	    System.out.println(x);
	    System.out.println(y);
	    shell.setLocation(x, y);
		
		Label lblAddItem = new Label(shell, SWT.NONE);
		lblAddItem.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblAddItem.setBounds(230, 10, 140, 21);
		lblAddItem.setText("Add Item to List");
		
		Label lblItemDescription = new Label(shell, SWT.NONE);
		lblItemDescription.setText("Item Description");
		lblItemDescription.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblItemDescription.setBounds(243, 55, 114, 21);
		
		textItemDescription = new Text(shell, SWT.BORDER);
		textItemDescription.setBounds(243, 82, 114, 22);
		
		lblPriority = new Label(shell, SWT.NONE);
		lblPriority.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblPriority.setBounds(270, 146, 59, 21);
		lblPriority.setText("Priority");
		
		textPriority = new Text(shell, SWT.BORDER);
		textPriority.setBounds(243, 173, 114, 22);
		
		labelDuDate = new Label(shell, SWT.NONE);
		labelDuDate.setText("Due Date");
		labelDuDate.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		labelDuDate.setBounds(267, 229, 65, 21);
		
		textMonth = new Text(shell, SWT.BORDER);
		textMonth.setBounds(214, 284, 50, 19);
		textMonth.setBounds(214, 284, 50, 21);
		
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
		labelMonth.setText("Month ");
		labelMonth.setFont(SWTResourceManager.getFont("Arial", 12, SWT.NORMAL));
		labelMonth.setBounds(219, 260, 50, 21);
		
		textDay = new Text(shell, SWT.BORDER);

		textDay.setBounds(275, 284, 50, 19);

		textDay.setBounds(275, 284, 50, 21);
		
		labelDay = new Label(shell, SWT.NONE);
		labelDay.setText("Day");
		labelDay.setFont(SWTResourceManager.getFont("Arial", 12, SWT.NORMAL));
		labelDay.setBounds(285, 260, 30, 21);
		
		textYear = new Text(shell, SWT.BORDER);

		textYear.setBounds(338, 284, 50, 19);

		textYear.setBounds(338, 284, 50, 21);

		
		labelYear = new Label(shell, SWT.NONE);
		labelYear.setText("Year");
		labelYear.setFont(SWTResourceManager.getFont("Arial", 12, SWT.NORMAL));
		labelYear.setBounds(346, 260, 30, 21);
		
		labelSlash1 = new Label(shell, SWT.NONE);
		labelSlash1.setText("/");
		labelSlash1.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		labelSlash1.setBounds(266, 283, 8, 21);
		
		labelSlaph2 = new Label(shell, SWT.NONE);
		labelSlaph2.setText("/");
		labelSlaph2.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
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
					labelUniqueDescription.setBounds(207, 106, 186, 14);
					labelUniqueDescription.setText("Please Enter Unique Description");
					
				}
				if(priorityNumber == false)
				{
					labelEnterNumber = new Label(shell, SWT.NONE);
					labelEnterNumber.setAlignment(SWT.CENTER);
					labelEnterNumber.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelEnterNumber.setBounds(230, 197, 140, 14);
					labelEnterNumber.setText("Please Enter a Number");

				}
				
				if((dayIsNum && monthIsNum && yearIsNum) == false)
				{
					labelFormateDate = new Label(shell, SWT.NONE);
					labelFormateDate.setAlignment(SWT.CENTER);
					labelFormateDate.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelFormateDate.setBounds(168, 306, 264, 14);
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

				Progress newPrpgress = new Progress();
				
				newPrpgress.setStatus(Status.NOT_STARTED);

				newEntry.setDueDate(date);
				newEntry.setProgress(newPrpgress);
				

				List.addEntry(newEntry);
				
				shell.dispose();
				mainMenu mainMenuPanel = new mainMenu();
				mainMenuPanel.open(List);
				
			}
		});

	}
   
  }

