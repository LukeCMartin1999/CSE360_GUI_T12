import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class addItem {

	protected Shell shell;
	private Text textItemDescription;
	private Label lblPriority;
	private Text textPriority;
	private Label labelDuDate;
	private Text textDueDate;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			addItem window = new addItem();
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
		
		Label lblAddItem = new Label(shell, SWT.NONE);
		lblAddItem.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblAddItem.setBounds(180, 10, 140, 21);
		lblAddItem.setText("Add Item to List");
		
		Label lblItemDescription = new Label(shell, SWT.NONE);
		lblItemDescription.setText("Item Description");
		lblItemDescription.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblItemDescription.setBounds(193, 55, 114, 21);
		
		textItemDescription = new Text(shell, SWT.BORDER);
		textItemDescription.setBounds(193, 82, 114, 19);
		
		lblPriority = new Label(shell, SWT.NONE);
		lblPriority.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblPriority.setBounds(220, 146, 59, 21);
		lblPriority.setText("Priority");
		
		textPriority = new Text(shell, SWT.BORDER);
		textPriority.setBounds(193, 173, 114, 19);
		
		labelDuDate = new Label(shell, SWT.NONE);
		labelDuDate.setText("Due Date");
		labelDuDate.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		labelDuDate.setBounds(217, 237, 65, 21);
		
		textDueDate = new Text(shell, SWT.BORDER);
		textDueDate.setBounds(193, 264, 114, 19);
		
		Button buttonExit = new Button(shell, SWT.NONE);
		buttonExit.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		buttonExit.setBounds(191, 389, 118, 34);
		buttonExit.setText("Exit");
		
		Button buttonAdd = new Button(shell, SWT.NONE);
		buttonAdd.setText("Add");
		buttonAdd.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonAdd.setBounds(191, 341, 118, 34);

	}
}
