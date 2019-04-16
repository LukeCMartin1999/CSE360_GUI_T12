import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.List;

public class removeItem {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			removeItem window = new removeItem();
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
		
		Label lblRemoveItem = new Label(shell, SWT.NONE);
		lblRemoveItem.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblRemoveItem.setBounds(191, 44, 117, 21);
		lblRemoveItem.setText("Remove Item");
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(64, 110, 371, 220);
		
		Button buttonExit = new Button(shell, SWT.NONE);
		buttonExit.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		buttonExit.setBounds(191, 396, 118, 34);
		buttonExit.setText("Exit");
		
		Button buttonRemove = new Button(shell, SWT.NONE);
		buttonRemove.setText("Remove");
		buttonRemove.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonRemove.setBounds(191, 352, 118, 34);

	}
}
