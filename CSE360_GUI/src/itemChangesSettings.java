import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class itemChangesSettings {

	protected Shell shell;
	private Text descriptionChange;
	private Text priorityChange;
	private Text dueDateChange;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			itemChangesSettings window = new itemChangesSettings();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
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
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(500, 500);
		shell.setText("SWT Application");
		
		Label lblEditItem = new Label(shell, SWT.NONE);
		lblEditItem.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblEditItem.setBounds(208, 10, 84, 27);
		lblEditItem.setText("Edit Item");
		
		Label lblChangeDescription = new Label(shell, SWT.NONE);
		lblChangeDescription.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblChangeDescription.setBounds(181, 69, 137, 27);
		lblChangeDescription.setText("Change Description");
		
		descriptionChange = new Text(shell, SWT.BORDER);
		descriptionChange.setBounds(181, 102, 137, 19);
		
		Label lblChangePriority = new Label(shell, SWT.NONE);
		lblChangePriority.setText("Change Priority");
		lblChangePriority.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblChangePriority.setBounds(194, 136, 111, 27);
		
		priorityChange = new Text(shell, SWT.BORDER);
		priorityChange.setBounds(181, 169, 137, 19);
		
		Label lblChangeDueDate = new Label(shell, SWT.NONE);
		lblChangeDueDate.setText("Change Due Date");
		lblChangeDueDate.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblChangeDueDate.setBounds(188, 209, 129, 27);
		
		dueDateChange = new Text(shell, SWT.BORDER);
		dueDateChange.setBounds(181, 242, 136, 19);
		
		Button btnNotStarted = new Button(shell, SWT.RADIO);
		btnNotStarted.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		btnNotStarted.setBounds(181, 300, 103, 21);
		btnNotStarted.setText("Not Started");
		
		Label lblChangeStatus = new Label(shell, SWT.NONE);
		lblChangeStatus.setText("Change Status");
		lblChangeStatus.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblChangeStatus.setBounds(185, 267, 129, 27);
		
		Button btnFinished = new Button(shell, SWT.RADIO);
		btnFinished.setText("Finished");
		btnFinished.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		btnFinished.setBounds(181, 354, 103, 21);
		
		Button btnInProgress = new Button(shell, SWT.RADIO);
		btnInProgress.setText("In Progress");
		btnInProgress.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		btnInProgress.setBounds(181, 327, 103, 21);
		
		Button buttonExit = new Button(shell, SWT.NONE);
		buttonExit.setText("Exit");
		buttonExit.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		buttonExit.setBounds(188, 434, 124, 34);
		
		Button buttonChange = new Button(shell, SWT.NONE);
		buttonChange.setText("Change");
		buttonChange.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonChange.setBounds(188, 394, 124, 34);

	}
}
