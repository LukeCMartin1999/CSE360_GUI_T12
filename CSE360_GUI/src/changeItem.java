import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;

public class changeItem {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			changeItem window = new changeItem();
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
		shell.setSize(500, 499);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblNewLabel.setBounds(193, 38, 113, 28);
		lblNewLabel.setText("Change Item");
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(67, 102, 366, 217);
		
		Button Exit = new Button(shell, SWT.NONE);
		Exit.setText("Exit");
		Exit.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		Exit.setBounds(188, 412, 124, 34);
		
		Button buttonChangeItem = new Button(shell, SWT.NONE);
		buttonChangeItem.setText("Change Item");
		buttonChangeItem.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonChangeItem.setBounds(188, 368, 124, 34);

	}

}
